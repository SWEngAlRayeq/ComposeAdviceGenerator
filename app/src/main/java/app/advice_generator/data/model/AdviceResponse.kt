package app.advice_generator.data.model

data class AdviceResponse(
    val slip: AdviceSlip
)

data class AdviceSlip(
    val id: Int,
    val advice: String
)