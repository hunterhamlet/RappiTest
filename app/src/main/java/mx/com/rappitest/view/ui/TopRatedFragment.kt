package mx.com.rappitest.view.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_movies.*

import mx.com.rappitest.R
import mx.com.rappitest.model.Movie
import mx.com.rappitest.view.adapter.MoviesAdapter

class TopRatedFragment : Fragment() {

 override fun onCreateView(
  inflater: LayoutInflater, container: ViewGroup?,
  savedInstanceState: Bundle?): View? {
  return inflater.inflate(R.layout.fragment_movies, container, false)
 }

 override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
  super.onViewCreated(view, savedInstanceState)
  var listOfMovies =
   mutableListOf(Movie("el libro de la selva"), Movie("john wick"), Movie("tarzan"),
    Movie("el libro de la selva"), Movie("john wick"), Movie("tarzan"))

  //test
  listMovies.adapter = MoviesAdapter(listOfMovies)
 }


}
