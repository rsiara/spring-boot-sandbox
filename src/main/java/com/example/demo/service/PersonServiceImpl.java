package com.example.demo.service;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service("personService")
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Override
    public Person saveUser(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> getAllUsers() {
       return (List<Person>) personRepository.findAll();
    }

    @Override
    public Person updateUser(Person person, Integer personId) {
        Person userDb
                = personRepository.findById(personId)
                .get();

        if (Objects.nonNull(person.getName())
                && !"".equalsIgnoreCase(
                person.getName())) {
            userDb.setName(
                    person.getName());
        }

        return personRepository.save(userDb);
    }

    @Override
    public void deleteUserById(Integer personId) {
        personRepository.deleteById(personId);
    }

    @Override
    public Optional<Person> findById(Integer personId) {
        return personRepository.findById(personId);
    }

    @Override
    public List<Person> findByName(String name) {

        return personRepository.findUserByName(name);
    }

    @Override
    public List<Person> findByNameList(List<String> names) {
        return personRepository.findUserByNameList(names);
    }
}
