package com.example.demo.service;

import com.example.demo.entity.Person;
import com.example.demo.repository.NamedJdbcPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("PersonServiceNamedJdbc")
public class PersonServiceNamedJdbc implements PersonService{

    @Autowired
    NamedJdbcPersonRepository namedJdbcPersonRepository;

    @Override
    public Person saveUser(Person person) {
        return namedJdbcPersonRepository.save(person);
    }

    @Override
    public List<Person> getAllUsers() {
        return namedJdbcPersonRepository.getEmployees();
    }

    @Override
    public Person updateUser(Person person, Integer personId) {
        return null;
    }

    @Override
    public void deleteUserById(Integer personId) {

    }

    @Override
    public Optional<Person> findById(Integer personId) {
        return Optional.empty();
    }

    @Override
    public List<Person> findByName(String name) {
        return null;
    }

    @Override
    public List<Person> findByNameList(List<String> names) {
        return null;
    }
}
