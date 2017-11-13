package com.chris.springdb.repository.impl;

import com.chris.springdb.entity.PersonEntity;
import com.chris.springdb.repository.PersonRepository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Chris on 2017/11/13.
 */

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    public PersonEntity load(Long id) {
        return (PersonEntity)getCurrentSession().load(PersonEntity.class,id);
    }

    public PersonEntity get(Long id) {
        return (PersonEntity)getCurrentSession().get(PersonEntity.class,id);
    }

    public List<PersonEntity> findAll() {
        return null;
    }

    public void persist(PersonEntity entity) {
        getCurrentSession().persist(entity);
    }

    public Long save(PersonEntity entity) {
        return (Long)getCurrentSession().save(entity);
    }

    public void saveOrUpdate(PersonEntity entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Long id) {
        PersonEntity person = load(id);
        getCurrentSession().delete(person);
    }

    public void flush() {
        getCurrentSession().flush();
    }
}