package mx.com.rappitest.view.ui


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
import mx.com.rappitest.viewmodel.TopRatedViewModel

class TopRatedFragment : Fragment() {

 //val

 //var
 lateinit var viewModel : TopRatedViewModel

 //override fun
 override fun onCreateView(
  inflater: LayoutInflater, container: ViewGroup?,
  savedInstanceState: Bundle?): View? {
  return inflater.inflate(R.layout.fragment_movies, container, false)
 }

 override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
  super.onViewCreated(view, savedInstanceState)

  //initViewModel
  viewModel = ViewModelProviders.of(this@TopRatedFragment).get(TopRatedViewModel::class.java)
  viewModel.initialize(this@TopRatedFragment)

  //search
  searchMovie.addTextChangedListener(object : TextWatcher{
   override fun afterTextChanged(s: Editable?) { viewModel.filterMovie(s.toString()) }

   override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

   override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

  })

 }


 override fun onPause() {
  super.onPause()
  viewModel.stop()
 }


}
