package centile.model

import centile.Centile

data class Standard (
    val gender: Gender,
    val type: Type,
    val age: Int,
    val centiles: List<Centile>
)