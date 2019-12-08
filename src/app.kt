import centile.Centile
import centile.model.Standard
import centile.model.Gender
import centile.model.Type
import java.io.File
import kotlin.math.pow

fun main() {
    println("Hi Jack!")
    findCentile(Gender.BOY, 80, 22.0, 116.0)
}

fun findCentile(gender: Gender, age: Int, weight: Double, height: Double) {
    val standards = getCentiles()
        .filter { it.gender == gender && it.age == age }

    if (standards.isNotEmpty()) {
        val bmi = weight / (height / 100).pow(2.0)
        val typeToValue = mapOf(Type.WEIGHT to weight, Type.HEIGHT to height, Type.BMI to bmi)

        typeToValue.forEach { printCentile(it.key, it.value, standards) }
    } else {
        println("No data for this age")
    }
}

fun printCentile(type: Type, value: Double, standards: List<Standard>) {
    val standard = standards
        .filter { it.type == type }
        .firstOrNull()

    if (standard != null) println("Centile $type: ${getPercentile(standard.centiles, value)}") else println("$type: No data for this age")
}

fun getPercentile(centiles: List<Centile>, value: Double) : Int {
    val centile = centiles
        .filter { it.value <= value }
        .lastOrNull()

    return if (centile != null) centile.percentile else 1
}

fun getCentiles(): List<Standard> {
        val csvFile = "./src/centile/centiles.csv"
        val centiles = mutableListOf<Standard>()
        val reader = File(csvFile).readLines()
        for (line in reader) {
            val dataField = line.split(",")
            centiles.add(
                Standard(
                    Gender.valueOf(dataField[0]),
                    Type.valueOf(dataField[1]),
                    dataField[2].toInt(),
                    listOf(
                        Centile(1, dataField[3].toDouble()),
                        Centile(3, dataField[4].toDouble()),
                        Centile(5, dataField[5].toDouble()),
                        Centile(10, dataField[6].toDouble()),
                        Centile(15, dataField[7].toDouble()),
                        Centile(25, dataField[8].toDouble()),
                        Centile(50, dataField[9].toDouble()),
                        Centile(75, dataField[10].toDouble()),
                        Centile(85, dataField[11].toDouble()),
                        Centile(90, dataField[12].toDouble()),
                        Centile(95, dataField[13].toDouble()),
                        Centile(97, dataField[14].toDouble()),
                        Centile(99, dataField[15].toDouble())
                    )
                )
            )
        }
        return centiles
    }
