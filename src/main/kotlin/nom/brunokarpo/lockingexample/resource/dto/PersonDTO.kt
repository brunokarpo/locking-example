package nom.brunokarpo.lockingexample.resource.dto

import nom.brunokarpo.lockingexample.model.Person
import java.util.*

data class PersonDTO(
        var codigo: UUID? = null,
        var nome: String,
        var idade: Int
) {
    constructor(person: Person) : this(codigo = person.id ,nome = person.name!!, idade = person.age!!)

    fun toPerson(): Person
            = Person(id = this.codigo, name = this.nome, age = this.idade)
}