package com.example.demo.repository;

import com.example.demo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NamedJdbcPersonRepository {

    @Autowired
//    @Qualifier("namedJdbcTemplate")
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Person save(Person person) {
        String sql = "insert into person (id, name, phone_number, address) values(:id,:name,:phone_number,:address)";
        BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(person);
        namedParameterJdbcTemplate.update(sql, paramSource);
        return new Person(person.getId(), person.getName(), person.getPhone_number(), person.getAddress());
    }

    public List<Person> getEmployees() {
        return namedParameterJdbcTemplate.query(
                "SELECT * FROM PERSON",
                (rs, rowNum) -> new Person(rs.getInt("id"), rs.getString("name"),
                        rs.getString("phone_number"), rs.getString("address")));
    }
}
