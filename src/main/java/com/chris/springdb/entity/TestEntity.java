package com.chris.springdb.entity;

/**
 * Created by Chris on 2017/11/10.
 */

public class TestEntity {
    String firstName;
    String lastName;

    public TestEntity(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
