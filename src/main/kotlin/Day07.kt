import java.io.File

class Day07 {

    fun part1(path: String): Long {
        return File(path).bufferedReader().lines()
            .filter { supportsTLS(it) }
            .count()
    }

    fun supportsTLS(ip: String): Boolean {
        return false
    }
}