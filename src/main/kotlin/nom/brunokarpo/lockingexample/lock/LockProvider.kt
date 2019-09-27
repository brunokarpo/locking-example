package nom.brunokarpo.lockingexample.lock

interface LockProvider {

    fun getLock(key: String): ILock

}