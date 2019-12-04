import centile.model.Centile
import centile.model.Gender
import centile.model.Type
import java.io.File

fun main() {
    println("Hi Jack!")
    getCentiles().forEach{ println(it) }
}

fun getCentiles(): List<Centile> {
        val csvFile = "./src/centile/centiles.csv"
        val centiles = mutableListOf<Centile>()
        val reader = File(csvFile).readLines()
        for (line in reader) {
            val centileField = line.split(",")
            centiles.add(
                Centile(
                    Gender.valueOf(centileField[0]),
                    Type.valueOf(centileField[1]),
                    centileField[2].toInt(),
                    centileField[3].toDouble(),
                    centileField[4].toDouble(),
                    centileField[5].toDouble(),
                    centileField[6].toDouble(),
                    centileField[7].toDouble(),
                    centileField[8].toDouble(),
                    centileField[9].toDouble(),
                    centileField[10].toDouble(),
                    centileField[11].toDouble(),
                    centileField[12].toDouble(),
                    centileField[13].toDouble(),
                    centileField[14].toDouble()
                )
            )
        }
        return centiles
    }
