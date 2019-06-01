package mx.com.rappitest.util

//utils
const val TAG = "JHMM"
//const val AUTHORIZATION_STRING = "Authorization"
const val AUTHORIZATION_STRING = "api_key"
//const val AUTHORIZATION_API_KEY = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI3ZmNiOTkxNTFhNWY0ZTY0NWE4YzQ4MTQ3NWY3OWUwMCIsInN1YiI6IjVjZjA4M2U2MGUwYTI2NzBjZWM5OTg0MSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.Wpb02_DvOaqH2ZE4jD-dEPpBLabVd9srjI49bwLxrxU"
const val AUTHORIZATION_API_KEY = "7fcb99151a5f4e645a8c481475f79e00"
const val CONTENT_TYPE_STRING = "Content-Type"
const val CONTENT_TYPE_VALUE = "application/json;charset=utf-8"
const val MOVIES_BASE_URL = "https://api.themoviedb.org/3/"
const val API_CONFIG = "configuration"
const val GET_POPULATE = "movie/popular"
const val GET_TOP_RATED = "movie/top_rated"
const val GET_UPCOMING = "movie/upcoming"

//fun
fun apiHeadersMap() : Map<String, String>{
 return mapOf(
  Pair(AUTHORIZATION_STRING, AUTHORIZATION_API_KEY),
  Pair(CONTENT_TYPE_STRING, CONTENT_TYPE_VALUE)
  )
}