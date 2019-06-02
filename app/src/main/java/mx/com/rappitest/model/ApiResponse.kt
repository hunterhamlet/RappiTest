package mx.com.rappitest.model

import com.google.gson.annotations.SerializedName

data class ApiResponse(
 @SerializedName("images")
 val images : Images
)