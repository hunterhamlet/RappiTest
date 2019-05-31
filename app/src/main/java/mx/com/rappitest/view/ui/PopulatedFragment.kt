package mx.com.rappitest.view.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_movies.*

import mx.com.rappitest.R
import mx.com.rappitest.framework.MoviewDbApi
import mx.com.rappitest.model.Movie
import mx.com.rappitest.model.Movies
import mx.com.rappitest.util.apiHeadersMap
import mx.com.rappitest.view.adapter.MoviesAdapter
import retrofit2.Call


class PopulatedFragment : Fragment() {

 val moviesApi by lazy {
  MoviewDbApi.createApiClient()
 }
 lateinit var disposable: Disposable

 override fun onCreateView(
  inflater: LayoutInflater, container: ViewGroup?,
  savedInstanceState: Bundle?): View? {
  return inflater.inflate(R.layout.fragment_movies, container, false)
 }

 override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
  super.onViewCreated(view, savedInstanceState)
  var listOfMovies =
   mutableListOf(Movie("el libro de la selva"), Movie("john wick"), Movie("tarzan"),
    Movie("el libro de la selva"), Movie("john wick"), Movie("tarzan"),
    Movie("el libro de la selva"), Movie("john wick"), Movie("tarzan"))


  //test
  listMovies.adapter = MoviesAdapter(listOfMovies)

  //getInfo
  /*
  disposable = moviesApi.getPopulateMovies(apiHeadersMap())
   .subscribeOn(Schedulers.io())
   .observeOn(AndroidSchedulers.mainThread())
   .subscribe({response ->
    showResponse(response)
   },{error ->
    Log.e("JHMM", "ERROR: ")
    error.printStackTrace()
   })
  */


  disposable = moviesApi.getConfigsApi(apiHeadersMap())
   .subscribeOn(Schedulers.io())
   .observeOn(AndroidSchedulers.mainThread())
   .subscribe({
    Log.d("JHMM", it.toString())
    if(it.images.posterSize.contains("w500")){
     Toast.makeText(context,"ofCourse",Toast.LENGTH_SHORT).show()
    }
   }, {
     Log.e("JHMM", "ERROR: ")
     it.printStackTrace()
    })





 }



 companion object {
  fun newInstance(){

    }
   }

 fun showResponse(populate : Movies.populateResponse){
  Log.d("JHMM", populate.toString())
 }



}
