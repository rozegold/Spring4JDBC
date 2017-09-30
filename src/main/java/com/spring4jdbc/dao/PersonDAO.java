package com.spring4jdbc.dao;

import com.spring4jdbc.bean.Person;

import java.util.List;

public interface PersonDAO {
    void addPerson(Person person);

    void editPerson(Person person, int personId);

    void deletePerson(int personId);

    Person find(int personId);

    List< Person > findAll();
}
