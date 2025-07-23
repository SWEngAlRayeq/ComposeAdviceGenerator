package app.advice_generator.di

import app.advice_generator.data.api.AdviceApi
import app.advice_generator.data.repo.AdviceRepoImpl
import app.advice_generator.domain.repository.AdviceRepository
import app.advice_generator.domain.usecase.GetAdviceUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import kotlin.jvm.java

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "https://api.adviceslip.com/"

    @Provides
    @Singleton
    fun provideApi(): AdviceApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(
            OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }).build()
        )
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(AdviceApi::class.java)


    @Provides
    @Singleton
    fun provideRepository(api: AdviceApi): AdviceRepository =
        AdviceRepoImpl(api)

    @Provides
    @Singleton
    fun provideUseCase(repository: AdviceRepository) : GetAdviceUseCase =
        GetAdviceUseCase(repository)

}