package mx.com.rappitest.viewmodel

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
     changeFragment(PopulatedFragment())
     return@setOnNavigationItemSelectedListener true
    }
    R.id.moviesTopRated ->{
     changeFragment(TopRatedFragment())
     return@setOnNavigationItemSelectedListener true
    }
    R.id.moviesUpComing -> {
     changeFragment(UpcomingFragment())
     return@setOnNavigationItemSelectedListener true
    }
    else -> true
   }
  }
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