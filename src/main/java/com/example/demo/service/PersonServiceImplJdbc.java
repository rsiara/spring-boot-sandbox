package com.example.demo.service;

import com.example.demo.entity.Person;
import com.example.demo.repository.JdbcPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("personServiceJdbc")
public class PersonServiceImplJdbc implements PersonService {
    @Autowired
    JdbcPersonRepository jdbcPersonRepository;

    @Override
    public Person saveUser(Person person) {
        return jdbcPersonRepository.save(person);
    }

    @Override
    public List<Person> getAllUsers() {
        return jdbcPersonRepository.findAll();
    }

    @Override
    public Person updateUser(Person person, Integer personId) {
        jdbcPersonRepository.update(person, personId);
        return person;
    }

    @Override
    public void deleteUserById(Integer personId) {
        jdbcPersonRepository.deleteById(personId);
    }

    @Override
    public Optional<Person> findById(Integer personId) {
        return jdbcPersonRepository.findById(personId);
    }

    @Override
    public List<Person> findByName(String name) {
        return jdbcPersonRepository.findByName(name);
    }

    @Override
    public List<Person> findByNameList(List<String> names) {
        return jdbcPersonRepository.findByNameList(names);
    }
}
