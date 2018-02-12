import java.io.File

class Day08 {

    fun part1(path: String, width: Int = 50, height: Int = 6): Long {
        return File(path).bufferedReader().lines()
            .count()
    }
}