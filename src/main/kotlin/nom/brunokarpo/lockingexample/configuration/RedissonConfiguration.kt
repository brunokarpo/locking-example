package nom.brunokarpo.lockingexample.configuration

import org.redisson.Redisson
import org.redisson.api.RedissonClient
import org.redisson.config.Config
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RedissonConfiguration {

    @Bean
    fun redissonClient(@Value("\${redis.url}") redisUrl: String): RedissonClient {
        val config = Config()
        config.useSingleServer().address = redisUrl

        return Redisson.create(config)
    }

}