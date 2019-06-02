package mx.com.rappitest.model

import com.google.gson.annotations.SerializedName

data class Images(
 @SerializedName("secure_base_url")
 val baserUrl : String,

 @SerializedName("poster_sizes")
 val posterSize : List<String>
){
 //getBaseUrlWhitPosterSize
 fun getBaseUrlWhitPosterSize() : String{
  return if(posterSize.contains("w500")){
   baserUrl + "w500"
  }else{
   baserUrl + "w342"
  }
 }
}