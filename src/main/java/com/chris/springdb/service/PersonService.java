package com.chris.springdb.service;

/**
 * Created by Chris on 2017/11/13.
 */

public interface PersonService {
    Long savePerson(String username,String phone,String addrss,String remark);
}