package mx.com.rappitest.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import mx.com.rappitest.R
import mx.com.rappitest.viewmodel.FilmDetailViewModel

class FilmDetailActivity : AppCompatActivity() {

 //var
 lateinit var viewModel : FilmDetailViewModel

 override fun onCreate(savedInstanceState: Bundle?) {
  super.onCreate(savedInstanceState)
  setContentView(R.layout.activity_film_detail)

  //init
  viewModel =
   ViewModelProviders.of(this@FilmDetailActivity).get(FilmDetailViewModel::class.java)
  viewModel.initialize(this@FilmDetailActivity)

 }
}
