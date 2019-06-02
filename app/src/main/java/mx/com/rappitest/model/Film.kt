package mx.com.rappitest.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


//movieClass
open class Film : RealmObject {

 //attributes
 @PrimaryKey
 @SerializedName("id")
 var id : Int? = null

 @SerializedName("title")
 var title : String? = null

 @SerializedName("poster_path")
 var posterPath : String? = null

 @SerializedName("original_title")
 var originalTitle : String? = null

 @SerializedName("overview")
 var overview : String? = null

 @SerializedName("release_date")
 var releaseDate : String? = null


 var type : String? = null


 //constructor
 constructor()

 constructor(title: String?) {
  this.title = title
 }

 constructor(
  id: Int?,
  title: String?,
  posterPath: String?,
  originalTitle: String?,
  overview: String?,
  releaseDate: String?,
  type: String?
 ) : super() {
  this.id = id
  this.title = title
  this.posterPath = posterPath
  this.originalTitle = originalTitle
  this.overview = overview
  this.releaseDate = releaseDate
  this.type = type
 }


 //gral fun
 fun imagePath (posterPath : String?): String?{
  var arrayPosterPath = posterPath?.split("/")
  //Log.d(TAG,"posterPath: ${arrayPosterPath?.get(1)}")
  return "https://image.tmdb.org/t/p/w500/${arrayPosterPath?.get(1)}"
 }

 override fun toString(): String {
  return "Film(id=$id, " +
     "title=$title, " +
     "posterPath=$posterPath, " +
     "originalTitle=$originalTitle," +
     " overview=$overview," +
     " releaseDate=$releaseDate, " +
     "type=$type)"
 }


}