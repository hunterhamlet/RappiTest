package mx.com.rappitest.view.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_movies.*

import mx.com.rappitest.R
import mx.com.rappitest.framework.MoviewDbApi
import mx.com.rappitest.model.Movies
import mx.com.rappitest.util.apiHeadersMap
import mx.com.rappitest.view.adapter.MoviesAdapter
import mx.com.rappitest.viewmodel.PopulatedViewModel


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

  //search
  searchBtn.setOnClickListener {
   viewModel.searchMovies(searchMovie.text.toString())
  }

 }

 override fun onPause() {
  super.onPause()
  viewModel.stop()
 }



}
