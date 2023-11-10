import kotlin.random.Random
data class Philosopher(val name: String)
enum class ForkState {
    FREE, TAKEN
}
data class Fork(val id: Int, var state: ForkState = ForkState.FREE)
fun main() {
    val numPhilosophers = readLine()?.toIntOrNull() ?: 0
    val philosophers = mutableListOf<Philosopher>()
    val forks = mutableListOf<Fork>()

    for (i in 0 until numPhilosophers) {
        philosophers.add(Philosopher("Philosopher $i"))
        forks.add(Fork(i))
    }
    philosophers.shuffle()
    for (i in 0 until numPhilosophers) {
        val philosopher = philosophers[i]
        val leftFork = forks[i]
        val rightFork = forks[(i + 1) % numPhilosophers]

        if (leftFork.state == ForkState.FREE && rightFork.state == ForkState.FREE) {
            leftFork.state = ForkState.TAKEN
            rightFork.state = ForkState.TAKEN
            println("${philosopher.name} is dining")
        } else {
            println("${philosopher.name} is contemplating")
        }
    }
}