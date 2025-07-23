package app.advice_generator.domain.repository

interface AdviceRepository {
    suspend fun getAdvice(): String
}