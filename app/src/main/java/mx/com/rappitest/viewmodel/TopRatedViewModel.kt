package mx.com.rappitest.viewmodel

import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_movies.*
import mx.com.rappitest.framework.MoviewDbApi
import mx.com.rappitest.model.Movies
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
  Toast.makeText(fragment.context,"textx: ${searchWord}", Toast.LENGTH_SHORT).show()
 }

 private fun getPopulatedMovies(){
  disposable = moviesApi.getTopRatedMovies(apiHeadersMap())
   .subscribeOn(Schedulers.io())
   .observeOn(AndroidSchedulers.mainThread())
   .subscribe({
     response -> showListTopRated(response.results)
   }, {

   })
 }

 private fun showListTopRated(moviesList : MutableList<Movies.Movie>){
  fragment.progressListUpdate.visibility = View.GONE
  fragment.listMovies.adapter = MoviesAdapter(moviesList)
 }

}