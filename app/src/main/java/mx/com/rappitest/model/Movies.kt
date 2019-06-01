package mx.com.rappitest.model

import android.util.Log
import com.google.gson.annotations.SerializedName
import mx.com.rappitest.util.TAG

class Movies {

 //populate
 data class populateResponse(

  @SerializedName("page")
  val page : Int? = null,

  @SerializedName("total_results")
  val totalResults : Int? = null,

  @SerializedName("results")
  val results : MutableList<Movie>
 )

 //upcoming
 data class upcomingResponse(

  @SerializedName("page")
  val page : Int? = null,

  @SerializedName("total_results")
  val totalResults : Int? = null,

  @SerializedName("results")
  val results : MutableList<Movie>
 )

 //topRated
 data class topRatedResponse(

  @SerializedName("page")
  val page : Int? = null,

  @SerializedName("total_results")
  val totalResults : Int? = null,

  @SerializedName("results")
  val results : MutableList<Movie>
 )



 //movieClass
 data class Movie(

  @SerializedName("id")
  val id : Int? = null,

  @SerializedName("title")
  val title : String? = null,

  @SerializedName("poster_path")
  val posterPath : String? = null,

  @SerializedName("original_title")
  val originalTitle : String? = null,

  @SerializedName("overview")
  val overview : String? = null,

  @SerializedName("release_date")
  val releaseDate : String? = null
 ){
  fun imagePath (posterPath : String?): String?{
   var arrayPosterPath = posterPath?.split("/")
   //Log.d(TAG,"posterPath: ${arrayPosterPath?.get(1)}")
   return "https://image.tmdb.org/t/p/w500/${arrayPosterPath?.get(1)}"
  }
 }

}