package nom.brunokarpo.lockingexample.services

import nom.brunokarpo.lockingexample.lock.LockService
import nom.brunokarpo.lockingexample.model.Person
import nom.brunokarpo.lockingexample.repository.PersonRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonService(
        private val repository: PersonRepository,
        private val lockService: LockService<Person>
) {

    fun create(person: Person): Person {
        person.id = UUID.randomUUID()
        return repository.save(person)
    }

    fun retrieveById(id: UUID): Person {
        return repository.findById(id).get()
    }

    fun update(person: Person): Person {
        return lockService.lock(person.id!!.toString()) {
            Thread.sleep(30000)
            repository.save(person)
        }
    }

}