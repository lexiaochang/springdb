package com.chris.springdb.service.impl;

import com.chris.springdb.entity.PersonEntity;
import com.chris.springdb.repository.PersonRepository;
import com.chris.springdb.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Chris on 2017/11/13.
 */

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Long savePerson() {
        PersonEntity person = new PersonEntity();
        person.setUsername("XRog");
        person.setPhone("18381005946");
        person.setAddress("chenDu");
        person.setRemark("this is XRog");
        return personRepository.save(person);
    }
}