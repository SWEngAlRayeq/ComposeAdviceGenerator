package app.advice_generator.data.repo

import app.advice_generator.data.api.AdviceApi
import app.advice_generator.domain.repository.AdviceRepository
import javax.inject.Inject

class AdviceRepoImpl @Inject constructor(
    private val api: AdviceApi
): AdviceRepository {
    override suspend fun getAdvice(): String {
        return api.getAdvice().slip.advice
    }
}