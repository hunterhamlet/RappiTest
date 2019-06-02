package mx.com.rappitest.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.row_movies.view.*
import mx.com.rappitest.R
import mx.com.rappitest.model.Film

class MoviesAdapter(val listMovies : MutableList<Film>) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

 //fun override
 override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
  return MoviesViewHolder(LayoutInflater.from(parent.context)
   .inflate(R.layout.row_movies, parent, false))
 }

 override fun getItemCount(): Int {
  return listMovies.size
 }

 override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
  holder.bindView(listMovies[position])
 }

 //inner class
 class MoviesViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

  //onBindView
  fun bindView(movie : Film){
   itemView.titleMovie.text = "Titlte : ${movie.title}"
   itemView.originalTitleMovie.text =  "Original title: ${movie.originalTitle}"
   itemView.yearMovie.text = "Date: ${movie.releaseDate}"
   Glide.with(itemView)
    .load(movie.imagePath(movie.posterPath))
    .centerCrop()
    .placeholder(R.drawable.ic_popcorn)
    .diskCacheStrategy(DiskCacheStrategy.ALL)
    .into(itemView.imageMovie)

   itemView.movieContent.setOnClickListener {
    Toast.makeText(itemView.context, "title: ${movie.title}", Toast.LENGTH_SHORT).show()
   }
  }

 }
}