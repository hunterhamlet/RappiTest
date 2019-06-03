package mx.com.rappitest.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.activity_film_detail.*
import mx.com.rappitest.R
import mx.com.rappitest.framework.FilmRepository
import mx.com.rappitest.model.Film
import mx.com.rappitest.util.FILM_ID
import mx.com.rappitest.util.TAG
import mx.com.rappitest.view.ui.FilmDetailActivity

class FilmDetailViewModel  : ViewModel(){

 //var
 var filmId : Int = 0
 lateinit var film : Film
 lateinit var activity: FilmDetailActivity

 //init
 fun initialize(activity : FilmDetailActivity){
  this.activity = activity
  filmId = activity.intent.getIntExtra(FILM_ID,1010)
  film = FilmRepository().searchMovieById(filmId)[0]
  setUI(film)
 }

 private fun setUI(film: Film){
  activity.titleText.text = film.title
  activity.originalTitleMovie.text = "Original title: ${film.originalTitle}"
  activity.relaseDateMovie.text = "Release date: ${film.releaseDate}"
  activity.voteCountMovie.text = "Vote count: ${film.voteCount}"
  activity.popularityMovie.text = "Popularity: ${film.popularity}"
  activity.ratingVoteMovie.rating = film.voteAverage!!.div(2)
  activity.overviewMovie.text = film.overview
  Glide.with(activity)
   .load(film.imagePath(film.posterPath))
   .placeholder(R.drawable.ic_popcorn)
   .diskCacheStrategy(DiskCacheStrategy.ALL)
   .into(activity.imageFilm)
 }
}