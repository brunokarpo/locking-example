package nom.brunokarpo.lockingexample.resource

import nom.brunokarpo.lockingexample.resource.dto.PersonDTO
import nom.brunokarpo.lockingexample.services.PersonService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.util.*

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

    @GetMapping
    fun retrieve(@RequestParam("codigo") id: UUID): ResponseEntity<PersonDTO> {
        val person = service.retrieveById(id)
        return ResponseEntity.ok(PersonDTO(person))
    }

    @PutMapping
    fun update(@RequestBody personDTO: PersonDTO): ResponseEntity<PersonDTO> {
        val person = service.update(personDTO.toPerson())
        return ResponseEntity.ok(PersonDTO(person))
    }

}