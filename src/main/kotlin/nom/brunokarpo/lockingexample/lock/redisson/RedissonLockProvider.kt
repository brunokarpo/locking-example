package nom.brunokarpo.lockingexample.lock.redisson

import nom.brunokarpo.lockingexample.lock.ILock
import nom.brunokarpo.lockingexample.lock.LockProvider
import org.redisson.api.RedissonClient
import org.springframework.stereotype.Component

@Component
class RedissonLockProvider(
        private val redissonClient: RedissonClient
    ): LockProvider {

    override fun getLock(key: String): ILock {
        return RedissonLock(redissonClient.getLock(key))
    }
}