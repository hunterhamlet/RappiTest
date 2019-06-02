package mx.com.rappitest.viewmodel

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_movies.*
import mx.com.rappitest.framework.FilmRepository
import mx.com.rappitest.framework.MoviewDbApi
import mx.com.rappitest.model.Film
import mx.com.rappitest.util.TAG
import mx.com.rappitest.util.TOP_RATED
import mx.com.rappitest.util.apiHeadersMap
import mx.com.rappitest.view.adapter.MoviesAdapter
import mx.com.rappitest.view.ui.TopRatedFragment

class TopRatedViewModel : ViewModel() {

 //val
 private val moviesApi by lazy {
  MoviewDbApi.createApiClient()
 }

 //var
 private lateinit var  fragment: TopRatedFragment
 private lateinit var disposable: Disposable


 //init
 fun initialize(fragment: TopRatedFragment){
  this.fragment = fragment
  getPopulatedMovies()
 }

 //stop
 fun stop(){
  disposable.dispose()
 }

 fun searchMovies(searchWord : String){
  getQueryList(searchWord)
 }

 private fun getPopulatedMovies(){
  disposable = moviesApi.getTopRatedMovies(apiHeadersMap())
   .subscribeOn(Schedulers.io())
   .observeOn(AndroidSchedulers.mainThread())
   .subscribe({
     response -> showListTopRated(response.results)
   }, {
    error -> requestError(error)
   })
 }

 private fun showListTopRated(filmList : MutableList<Film>){
  setTypeFilm(filmList)
  fragment.progressListUpdate.visibility = View.GONE
  fragment.listMovies.adapter = MoviesAdapter(filmList)
  FilmRepository().addListOfMovies(filmList)
 }

 private fun requestError(error : Throwable){
  error.printStackTrace()
 }

 private fun setTypeFilm(filmList : MutableList<Film>){
  filmList.forEach {
   it.type = TOP_RATED
  }
 }

 private fun getQueryList(query: String){
  Log.d(TAG,"movie: ${FilmRepository().searchAll()}")
 }

}