package nom.brunokarpo.lockingexample.lock.redisson

import nom.brunokarpo.lockingexample.lock.ILock
import org.redisson.api.RLock
import java.util.concurrent.TimeUnit

class RedissonLock(
        private val redisLock: RLock
    ): ILock {

    override fun lock(): Boolean {
        return redisLock.tryLock(10, TimeUnit.SECONDS)
    }

    override fun unlock() {
        redisLock.unlock()
    }
}