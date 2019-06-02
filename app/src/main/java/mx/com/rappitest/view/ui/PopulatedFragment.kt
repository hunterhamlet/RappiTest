package mx.com.rappitest.view.ui

import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_movies.*

import mx.com.rappitest.R
import mx.com.rappitest.framework.FilmRepository
import mx.com.rappitest.util.TAG
import mx.com.rappitest.viewmodel.PopulatedViewModel
import java.util.*


class PopulatedFragment : Fragment() {

 //val

 //var
 lateinit var viewModel : PopulatedViewModel

 //override fun
 override fun onCreateView(
  inflater: LayoutInflater, container: ViewGroup?,
  savedInstanceState: Bundle?): View? {
  return inflater.inflate(R.layout.fragment_movies, container, false)
 }

 override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
  super.onViewCreated(view, savedInstanceState)

  //initViewModel
  viewModel = ViewModelProviders.of(this@PopulatedFragment).get(PopulatedViewModel::class.java)
  viewModel.initialize(this@PopulatedFragment)

  searchBtn.setOnClickListener {
   Log.d(TAG,"movie: ${FilmRepository().searchMovieByTitleInPopulate(searchMovie.text.toString())}")
   Log.d(TAG,"movieAll: ${FilmRepository().searchMovieByTitle(searchMovie.text.toString())}")
  }

 }

 override fun onPause() {
  super.onPause()
  viewModel.stop()
 }



}
