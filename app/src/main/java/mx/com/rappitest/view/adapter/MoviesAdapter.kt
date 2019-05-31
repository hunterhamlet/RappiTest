package mx.com.rappitest.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_movies.view.*
import mx.com.rappitest.R
import mx.com.rappitest.model.Movie

class MoviesAdapter(val listMovies : MutableList<Movie>) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

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
  fun bindView(movie : Movie){
   itemView.titleMovie.text = movie.title
   itemView.movieContent.setOnClickListener {
    Toast.makeText(itemView.context, "title: ${movie.title}", Toast.LENGTH_SHORT).show()
   }
  }

 }
}