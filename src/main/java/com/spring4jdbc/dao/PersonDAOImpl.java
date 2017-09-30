package com.spring4jdbc.dao;

import com.spring4jdbc.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class PersonDAOImpl implements PersonDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addPerson(Person person) {
        jdbcTemplate.update("INSERT INTO trn_person (person_id, first_name, Last_name, age) VALUES (?, ?, ?, ?)",
                person.getPersonId(), person.getFirstName(), person.getLastName(), person.getAge());
        System.out.println("Person Added!!");
    }

    public void editPerson(Person person, int personId) {
        jdbcTemplate.update("UPDATE trn_person SET first_name = ? , last_name = ? , age = ? WHERE person_id = ? ",
                person.getFirstName(), person.getLastName(), person.getAge(), personId);
        System.out.println("Person Updated!!");
    }

    public void deletePerson(int personId) {
        jdbcTemplate.update("DELETE from trn_person WHERE person_id = ? ", personId);
        System.out.println("Person Deleted!!");
    }

    public Person find(int personId) {
        Person person = (Person) jdbcTemplate.queryForObject("SELECT * FROM trn_person where person_id = ? ",
                new Object[] { personId }, new BeanPropertyRowMapper(Person.class));

        return person;
    }

    public List< Person > findAll() {
        List < Person > persons = jdbcTemplate.query("SELECT * FROM trn_person", new BeanPropertyRowMapper(Person.class));
        return persons;
    }
}
