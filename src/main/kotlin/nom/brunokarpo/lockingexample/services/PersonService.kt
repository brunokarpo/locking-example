package nom.brunokarpo.lockingexample.services

import nom.brunokarpo.lockingexample.model.Person
import nom.brunokarpo.lockingexample.repository.PersonRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonService(
        private val repository: PersonRepository
) {

    fun create(person: Person): Person {
        person.id = UUID.randomUUID()
        return repository.save(person)
    }

    fun retrieveById(id: UUID): Person {
        return repository.findById(id).get()
    }

    fun update(person: Person): Person {
        Thread.sleep(30000)
        return repository.save(person)
    }

}