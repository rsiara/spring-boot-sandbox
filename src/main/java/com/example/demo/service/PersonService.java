package com.example.demo.service;

import com.example.demo.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    // Save operation
    Person saveUser(Person person);

    // Read operation
    List<Person> getAllUsers();

    // Update operation
    Person updateUser(Person person,
                                Integer personId);

    // Delete operation
    void deleteUserById(Integer personId);

    Optional<Person> findById(Integer personId);

    List<Person> findByName(String name);

    List<Person> findByNameList(List<String> names);
}
