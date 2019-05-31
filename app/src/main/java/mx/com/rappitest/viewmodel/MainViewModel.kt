package mx.com.rappitest.viewmodel

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.activity_main.*
import mx.com.rappitest.R
import mx.com.rappitest.view.ui.*

class MainViewModel : ViewModel(){

 //attributes
 private lateinit var main : MainActivity


 //initFunctions
 fun initialize(main : MainActivity){
  this.main = main
  checkBottomView()
  fragmentInit()
  checkBottomView()
 }

 //checkBottomView
 private fun checkBottomView(){
  main.categoryBottomMenu.setOnNavigationItemSelectedListener {
   when(it.itemId){
    R.id.moviesPopulate -> {
     showMessage("Populate")
     changeFragment(PopulatedFragment())
     return@setOnNavigationItemSelectedListener true
    }
    R.id.moviesTopRated ->{
     showMessage("TopRated")
     changeFragment(TopRatedFragment())
     return@setOnNavigationItemSelectedListener true
    }
    R.id.moviesUpComing -> {
     showMessage("Upcoming")
     changeFragment(UpcomingFragment())
     return@setOnNavigationItemSelectedListener true
    }
    else -> true
   }
  }
 }

 private fun showMessage(msg : String){
  Toast.makeText(main, msg, Toast.LENGTH_SHORT).show()
 }

 private fun changeFragment(fragment : Fragment){
  main.supportFragmentManager
   .beginTransaction()
   .replace(R.id.contentFragments,fragment)
   .commitAllowingStateLoss()

  }

 private fun fragmentInit(){
  main.supportFragmentManager
   .beginTransaction()
   .replace(R.id.contentFragments, PopulatedFragment())
   .commitAllowingStateLoss()
 }


}