package com.example.swarguru

import com.example.swarguru.DataClass.AddQuestionData
import com.example.swarguru.DataClass.AddQuestionResponseData
import com.example.swarguru.DataClass.AddVocablaryResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {
    @POST("question")
    fun sendData(@Body data: AddQuestionData): Call<AddQuestionResponseData>

    @Multipart
    @POST("upload")
    fun upload(
        @Part("level") level: RequestBody,
        @Part img: MultipartBody.Part,
        @Part("hindiText") hindiText: RequestBody,
        @Part("englishText") englishText: RequestBody,
        @Part audio: MultipartBody.Part
    ): Call<AddVocablaryResponse>


}