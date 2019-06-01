package mx.com.rappitest.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.row_movies.view.*
import mx.com.rappitest.R
import mx.com.rappitest.model.Movies
import mx.com.rappitest.util.TAG

class MoviesAdapter(val listMovies : MutableList<Movies.Movie>) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

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
  fun bindView(movie : Movies.Movie){
   itemView.titleMovie.text = "Titlte : ${movie.title}"
   itemView.originalTitleMovie.text =  "Original title: ${movie.originalTitle}"
   itemView.yearMovie.text = "Date: ${movie.releaseDate}"
   Glide.with(itemView)
    .load(movie.imagePath(movie.posterPath))
    .centerCrop()
    .placeholder(R.drawable.ic_popcorn)
    .into(itemView.imageMovie)

   itemView.movieContent.setOnClickListener {
    Toast.makeText(itemView.context, "title: ${movie.title}", Toast.LENGTH_SHORT).show()
   }
  }

 }
}