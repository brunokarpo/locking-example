package nom.brunokarpo.lockingexample.lock

import org.springframework.stereotype.Service

@Service
class LockService<T>(
        private val lockProvider: LockProvider
    ) {

    fun lock(key: String, func: () -> T): T {
        val lock = lockProvider.getLock(key)
        try {
            val locked = lock.lock()
            if (!locked) {
                throw RuntimeException("Could not get lock")
            }
            return func.invoke()
        } finally {
            lock.unlock()
        }
    }

}