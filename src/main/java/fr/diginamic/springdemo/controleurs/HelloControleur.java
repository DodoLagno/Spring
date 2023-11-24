package fr.diginamic.springdemo.controleurs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // Indique à Spring Boot que c'est un contrôleur REST
@RequestMapping("/hello")  // Mappe le contrôleur sur l'URL /hello
public class HelloControleur {

    @GetMapping  // Intercepte les requêtes de type GET
    public String direHello() {
        return "Hello";  // Retourne simplement le message "Hello"
    }
}

