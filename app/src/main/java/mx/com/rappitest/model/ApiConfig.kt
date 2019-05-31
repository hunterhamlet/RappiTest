package mx.com.rappitest.model

import com.google.gson.annotations.SerializedName

class ApiConfig {

 data class Response(
  @SerializedName("images")
  var images : Images
 )

 data class Images(
  @SerializedName("secure_base_url")
  var baserUrl : String,

  @SerializedName("poster_sizes")
  var posterSize : List<String>
 )

}