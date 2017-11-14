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

    public Long savePerson(String username,String phone,String addrss,String remark) {
        PersonEntity person = new PersonEntity();
        person.setUsername(username);
        person.setPhone(phone);
        person.setAddress(addrss);
        person.setRemark(remark);
        return personRepository.save(person);
    }
}