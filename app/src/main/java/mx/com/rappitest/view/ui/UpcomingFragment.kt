package mx.com.rappitest.view.ui


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_movies.*

import mx.com.rappitest.R
import mx.com.rappitest.framework.FilmRepository
import mx.com.rappitest.util.TAG
import mx.com.rappitest.view.adapter.MoviesAdapter
import mx.com.rappitest.viewmodel.UpcomingViewModel

class UpcomingFragment : Fragment() {

//val

 //var
 lateinit var viewModel : UpcomingViewModel

 //override fun
 override fun onCreateView(
  inflater: LayoutInflater, container: ViewGroup?,
  savedInstanceState: Bundle?): View? {
  return inflater.inflate(R.layout.fragment_movies, container, false)
 }


 override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
  super.onViewCreated(view, savedInstanceState)

  //initViewModel
  viewModel = ViewModelProviders.of(this@UpcomingFragment).get(UpcomingViewModel::class.java)
  viewModel.initialize(this@UpcomingFragment)

  //search
  searchBtn.setOnClickListener {
   Log.d(TAG,"movie: ${FilmRepository().searchMovieByTitleInUpcoming(searchMovie.text.toString())}")
   Log.d(TAG,"movieAll: ${FilmRepository().searchMovieByTitle(searchMovie.text.toString())}")
  }

 }

 override fun onPause() {
  super.onPause()
  viewModel.stop()
 }

}
