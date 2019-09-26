package nom.brunokarpo.lockingexample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LockingExampleApplication

fun main(args: Array<String>) {
	runApplication<LockingExampleApplication>(*args)
}
