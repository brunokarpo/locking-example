package nom.brunokarpo.lockingexample.resource

import nom.brunokarpo.lockingexample.resource.dto.PersonDTO
import nom.brunokarpo.lockingexample.services.PersonService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("/person")
class PersonResource(
        private val service: PersonService
    ) {

    @PostMapping
    fun create(@RequestBody personDTO: PersonDTO): ResponseEntity<PersonDTO> {
        val person = service.create(personDTO.toPerson())
        return ResponseEntity.created(URI.create("/person/${person.id}")).body(PersonDTO(person))
    }

}