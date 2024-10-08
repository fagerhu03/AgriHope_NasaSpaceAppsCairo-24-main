package com.example.agriwise.data.network

import com.example.agriwise.data.model.*
import com.example.banquemisr.interceptor.HeaderInterceptor
import com.example.example.CropRecommendationResponse
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit


interface AgriWiseApi{
    @POST("soil-fertilizer/")
    fun soilFertilizer(@Body soilFertilizerData: SoilFertilizerData) : Call<SoilFertilizerResponse>

    @POST("/croprecommendation")
    fun cropRecommendation(@Body cropRecommendationData: CropRecommendationData) : Call<CropRecommendationResponse>
//
//    @POST("/croprecommendation")
//    fun cropRecommendation(@Body cropRecommendationData: CropRecommendationData): Call<String>

    @POST("soil-quality/soil/")
    fun soilQuality(@Body soilQualityData: SoilQualityData) : Call<SoilQualityResponse>


    @POST("auth/users/")
    fun register(@Body body: RegisterBody) : Call<Unit>

    @POST("auth/jwt/create/")
    fun login(@Body body: LoginBody) : Call<LoginResponse>


    @POST("soil-type/predict/")
    @Multipart
    fun soilType(@Part Image: MultipartBody.Part) : Call<SoilTypeResponse>


    @POST("plant-diseases/predict/")
    @Multipart
    fun plantDisease(@Part Image: MultipartBody.Part) : Call<PlantDiseaseResponse>

  //  fun soilType(@Header("Content-Type")fileType:String,@Part Image: MultipartBody.Part) : Call<SoilTypeResponse>

    @GET("profiles/me")
    fun getProfile() : Call<User>

    @PUT("profiles/me")
    fun updateProfile(@Body user: User) : Call<User>
}

val httpLogging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

val client = OkHttpClient().newBuilder()
    .readTimeout(60, TimeUnit.SECONDS)
    .writeTimeout(60, TimeUnit.SECONDS)
    .addInterceptor(httpLogging)
    .addInterceptor(HeaderInterceptor())
    .build()

val retrofit = Retrofit.Builder()
   // .baseUrl("https://coffee-shop2022.herokuapp.com/")
    .baseUrl("https://f2ec-196-157-10-41.ngrok-free.app")
    .client(client)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val service = retrofit.create(AgriWiseApi::class.java)