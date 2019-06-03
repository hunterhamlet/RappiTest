package mx.com.rappitest.model

import com.google.gson.annotations.SerializedName

//topRated
data class TopRatedResponse(

 @SerializedName("page")
 val page : Int? = null,

 @SerializedName("total_results")
 val totalResults : Int? = null,

 @SerializedName("results")
 val results : MutableList<Film>
)