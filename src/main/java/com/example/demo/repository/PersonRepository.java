package com.example.demo.repository;

import com.example.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query("SELECT p FROM Person p WHERE p.name = ?1")
    List<Person> findUserByName(String name);

    @Query(value = "SELECT p FROM Person p WHERE p.name IN :names")
    List<Person> findUserByNameList(@Param("names") Collection<String> names);
}
