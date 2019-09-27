package nom.brunokarpo.lockingexample.lock

interface ILock {

    fun lock(): Boolean

    fun unlock()

}