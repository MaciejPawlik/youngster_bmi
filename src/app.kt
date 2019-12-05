import centile.Centile
import centile.model.Standard
import centile.model.Gender
import centile.model.Type
import java.io.File

fun main() {
    println("Hi Jack!")
    getCentiles().forEach{ println(it) }
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
