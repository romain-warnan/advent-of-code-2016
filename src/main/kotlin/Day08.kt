import java.io.File

class Day08 {

    fun part1(path: String): Long {
        return File(path).bufferedReader().lines()
            .count()
    }
}