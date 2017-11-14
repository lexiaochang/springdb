package com.chris.springdb.service;

import com.chris.springdb.entity.PersonEntity;

/**
 * Created by Chris on 2017/11/13.
 */

public interface PersonService {
    Long savePerson(String username,String phone,String addrss,String remark);
    void saveOrUpdatePerson(String username,String phone,String addrss,String remark);

    PersonEntity loadPerson(Long id);
    PersonEntity getPerson(Long id);
    void findAll();
}