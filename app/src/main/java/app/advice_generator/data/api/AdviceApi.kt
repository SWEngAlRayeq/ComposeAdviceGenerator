package app.advice_generator.data.api

import app.advice_generator.data.model.AdviceResponse
import retrofit2.http.GET

interface AdviceApi {

    @GET("advice")
    suspend fun getAdvice(): AdviceResponse


}