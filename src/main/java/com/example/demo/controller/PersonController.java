package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    @Qualifier("personService")
    private PersonService personService;

    @GetMapping("/users")
    public List<Person> getAllUsers() {
        return personService.getAllUsers();
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<Person> getUser(@PathVariable("id") Integer id) {

        Optional<Person> user = personService.findById(id);
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }

    @GetMapping(value = "/usersByName/{name}")
    public List<Person> getUser(@PathVariable("name") String name) {

        List<Person> user = personService.findByName(name);
        return user;
    }

    @GetMapping(value = "/usersByNameList/{names}")
    public List<Person> getUser(@PathVariable("names") List<String> names) {

        return personService.findByNameList(names);
    }

    // Save operation
    @PostMapping("/users")
    public Person saveUser(@Valid @RequestBody Person person) {

        return personService.saveUser(person);
    }

    @PutMapping("/users/{id}")
    public Person updateUser(@RequestBody Person person,
                             @PathVariable("id") Integer userId) {

        return personService.updateUser(person, userId);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable("id") Integer userId) {

        personService.deleteUserById(userId);
        return "Deleted Successfully";
    }
}
