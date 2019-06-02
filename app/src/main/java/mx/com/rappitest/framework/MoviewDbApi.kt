package mx.com.rappitest.framework

import io.reactivex.Observable
import mx.com.rappitest.model.ApiResponse
import mx.com.rappitest.model.PopulateResponse
import mx.com.rappitest.model.TopRatedResponse
import mx.com.rappitest.model.UpcomingResponse
import mx.com.rappitest.util.*
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.QueryMap
import java.util.concurrent.TimeUnit

interface MoviewDbApi {

 //methods
 @GET(API_CONFIG)
 fun getConfigsApi(@QueryMap headers: Map<String,String>) : Observable<ApiResponse>
 @GET(GET_POPULATE)
 fun getPopulateMovies(@QueryMap headers: Map<String,String>) : Observable<PopulateResponse>
 @GET(GET_TOP_RATED)
 fun getTopRatedMovies(@QueryMap headers: Map<String,String>) : Observable<TopRatedResponse>
 @GET(GET_UPCOMING)
 fun getUpcommingMovies(@QueryMap headers: Map<String,String>) : Observable<UpcomingResponse>

 companion object{
  fun createApiClient() : MoviewDbApi{

   //addHeaders
   val okHttpClient = OkHttpClient.Builder()
    .readTimeout(2, TimeUnit.MINUTES)
    .writeTimeout(2, TimeUnit.MINUTES)
    .connectTimeout(2, TimeUnit.MINUTES)
    .build()

   /*
   val interceptor = Interceptor{chain ->
    val request =
     chain.request().newBuilder()
      .addHeader(AUTHORIZATION_STRING , AUTHORIZATION_API_KEY)
      .addHeader(CONTENT_TYPE_STRING, CONTENT_TYPE_VALUE)
      .build()
    chain.proceed(request)
   }

   okHttpClientBuilder.addNetworkInterceptor(interceptor)
   */

   val retrofit = Retrofit.Builder()
    .client(okHttpClient)
    .baseUrl(MOVIES_BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .build()

   return retrofit.create(MoviewDbApi::class.java)
  }

 }
}