package app.advice_generator.domain.usecase

import app.advice_generator.domain.repository.AdviceRepository
import javax.inject.Inject

class GetAdviceUseCase @Inject constructor(
    private val repository: AdviceRepository
) {
    suspend operator fun invoke(): String {
        return repository.getAdvice()
    }
}