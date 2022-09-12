package com.example.demo.repository;

import com.example.demo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcPersonRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public Person save(Person person) {
         jdbcTemplate.update(
                "insert into person (id, name, phone_number, address) values(?,?,?,?)",
                person.getId(),person.getName(), person.getPhone_number(), person.getAddress());
         return new Person(person.getId(),person.getName(), person.getPhone_number(), person.getAddress());
    }

    public int update(Person person, Integer personId) {
        return jdbcTemplate.update(
                "update person set address = ? where id = ?",
                person.getAddress(), personId);
    }

    public List<Person> findAll() {
        return jdbcTemplate.query(
                "select * from person",
                (rs, rowNum) ->
                        new Person(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("phone_Number"),
                                rs.getString("address")
                        )
        );
    }

    public int deleteById(Integer id) {
        return jdbcTemplate.update(
                "delete person where id = ?",
                id);
    }


    public Optional<Person> findById(Integer id) {
        return jdbcTemplate.queryForObject(
                "select * from person where id = ?",
                new Object[]{id},
                (rs, rowNum) ->
                        Optional.of(new Person(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("phone_Number"),
                                rs.getString("address")
                        ))
        );
    }


    public List<Person> findByName(String name) {
        return jdbcTemplate.query(
                "select * from person where name like ?",
                new Object[]{"%" + name + "%"},
                (rs, rowNum) ->
                        new Person(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("phone_Number"),
                                rs.getString("address")
                        )
        );
    }

    public List<Person> findByNameList(List<String> names) {
        String inSql = String.join(",", Collections.nCopies(names.size(), "?"));

        List<Person> employees = jdbcTemplate.query(
                String.format("SELECT * FROM PERSON WHERE name IN (%s)", inSql),
                names.toArray(),
                (rs, rowNum) -> new Person(rs.getInt("id"), rs.getString("name"),
                        rs.getString("phone_number"), rs.getString("address")));

        return employees;
    }
}
