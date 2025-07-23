package app.advice_generator.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.advice_generator.domain.usecase.GetAdviceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdviceViewModel @Inject constructor(
    private val useCase: GetAdviceUseCase
) : ViewModel() {

    var advice by mutableStateOf("Get Advice")
        private set

    var isLoading by mutableStateOf(false)

    fun getAdvice() {
        viewModelScope.launch {
            isLoading = true
            try {
                advice = useCase()
            } catch (e: Exception) {
                advice = "❌ Failed to load advice."
            } finally {
                isLoading = false
            }
        }
    }

}