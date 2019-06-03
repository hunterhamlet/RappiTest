package mx.com.rappitest.view.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.row_movies.view.*
import mx.com.rappitest.R
import mx.com.rappitest.model.Film
import mx.com.rappitest.util.FILM_ID
import mx.com.rappitest.view.ui.FilmDetailActivity

class MoviesAdapter(private var listMovies : MutableList<Film>, private val activity: FragmentActivity?) :
 RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

 //var

 //fun override
 override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
  return MoviesViewHolder(LayoutInflater.from(parent.context)
   .inflate(R.layout.row_movies, parent, false),activity)
 }

 override fun getItemCount(): Int {
  return listMovies.size
 }

 override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
  holder.bindView(listMovies[position])
 }

 //gral fun
 fun addItems(listMovies: MutableList<Film>){
  val callBack = FilmDiffCallBack(this.listMovies, listMovies)
  val diffResult = DiffUtil.calculateDiff(callBack)
  this.listMovies.clear()
  this.listMovies.addAll(listMovies)
  diffResult.dispatchUpdatesTo(this)
 }

 fun filteredList(filteredList : MutableList<Film>){
  listMovies = filteredList
  notifyDataSetChanged()
 }


 //inner class
 class MoviesViewHolder(itemView : View,val activity: FragmentActivity?) : RecyclerView.ViewHolder(itemView) {


  //onBindView
  fun bindView(movie : Film){
   itemView.titleMovie.text = "Title : ${movie.title}"
   itemView.originalTitleMovie.text =  "Original title: ${movie.originalTitle}"
   itemView.yearMovie.text = "Date: ${movie.releaseDate}"
   Glide.with(itemView)
    .load(movie.imagePath(movie.posterPath))
    .centerCrop()
    .placeholder(R.drawable.ic_popcorn)
    .diskCacheStrategy(DiskCacheStrategy.ALL)
    .into(itemView.imageMovie)

   itemView.movieContent.setOnClickListener {
    val intent = Intent(activity, FilmDetailActivity::class.java)
    intent.putExtra(FILM_ID,movie.id)
    activity?.startActivity(intent)
   }
  }

 }

 class FilmDiffCallBack(private val oldList : MutableList<Film>, private val newList : MutableList<Film>)
  : DiffUtil.Callback() {


  override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
   return oldList[oldItemPosition].id == newList[newItemPosition].id
  }

  override fun getOldListSize(): Int {
   return oldList.size
  }

  override fun getNewListSize(): Int {
   return newList.size
  }

  override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
   val oldFilm = oldList[oldItemPosition]
   val newFilm = newList[newItemPosition]
   return oldFilm.id == newFilm.id
  }

 }




}