package nom.brunokarpo.lockingexample.resource

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello")
class HelloWorldResource {

    @GetMapping
    fun sayHello(): ResponseEntity<String> = ResponseEntity.ok("Hello World")

}