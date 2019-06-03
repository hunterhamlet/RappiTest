package mx.com.rappitest.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_movies.*
import mx.com.rappitest.framework.FilmRepository
import mx.com.rappitest.framework.MoviewDbApi
import mx.com.rappitest.model.Film
import mx.com.rappitest.util.UPCOMING
import mx.com.rappitest.util.apiHeadersMap
import mx.com.rappitest.util.checkConnectivity
import mx.com.rappitest.view.adapter.MoviesAdapter
import mx.com.rappitest.view.ui.UpcomingFragment

class UpcomingViewModel : ViewModel() {

 //val
 private val moviesApi by lazy {
  MoviewDbApi.createApiClient()
 }

 //var
 private lateinit var  fragment: UpcomingFragment
 private lateinit var disposable: Disposable
 private lateinit var moviesAdapter : MoviesAdapter
 private lateinit var listOfFilms : MutableList<Film>


 //init
 fun initialize(fragment: UpcomingFragment){
  this.fragment = fragment
  getPopulatedMovies()
 }

 //stop
 fun stop(){
  if(checkConnectivity(fragment.context)){
   disposable.dispose()
  }
 }


 fun filterMovie(title : String){
  val listFilteredFilm =
   listOfFilms.filter { film -> film.title?.toLowerCase()!!.contains(title.toLowerCase())}
  moviesAdapter.filteredList(listFilteredFilm.toMutableList())

 }

 private fun getPopulatedMovies(){
  if(checkConnectivity(fragment.context)){
   disposable = moviesApi.getUpcommingMovies(apiHeadersMap())
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe({
      response -> showListUpcoming(response.results)
    }, {
      error -> requestError(error)
    })
  }else{
   showListUpcoming(FilmRepository().searchAllByPopulated().toMutableList())
  }

 }

 private fun showListUpcoming(filmList : MutableList<Film>){
  setTypeFilm(filmList)
  listOfFilms = filmList
  moviesAdapter = MoviesAdapter(filmList,fragment.activity)
  fragment.listMovies.adapter = moviesAdapter
  FilmRepository().addListOfMovies(filmList)
  fragment.progressListUpdate.visibility = View.GONE

 }

 private fun requestError(error : Throwable){
  error.printStackTrace()
 }

 private fun setTypeFilm(filmList : MutableList<Film>){
  filmList.forEach {
   it.type = UPCOMING
  }
 }


}