package mx.com.rappitest.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import mx.com.rappitest.R
import mx.com.rappitest.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

 lateinit var mainViewModel: MainViewModel

 override fun onCreate(savedInstanceState: Bundle?) {
  super.onCreate(savedInstanceState)
  setContentView(R.layout.activity_main)

  //initView model
  mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
  mainViewModel.initialize(this@MainActivity)

 }
}
