package centile.model

import java.io.File

data class Centile (
    val gender: Gender,
    val type: Type,
    val age: Int,
    val p1: Double,
    val p3: Double,
    val p5: Double,
    val p10: Double,
    val p15: Double,
    val p25: Double,
    val p50: Double,
    val p75: Double,
    val p90: Double,
    val p95: Double,
    val p97: Double,
    val p99: Double
)