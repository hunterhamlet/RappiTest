package mx.com.rappitest.model

import com.google.gson.annotations.SerializedName

class Movies {

 //populate
 data class populateResponse(

  @SerializedName("id")
  var id : Int? = null,

  @SerializedName("page")
  var page : Int? = null,

  @SerializedName("total_results")
  var totalResults : Int? = null
 )

}