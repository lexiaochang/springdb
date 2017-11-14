package com.chris.springdb.repository.impl;

import com.chris.springdb.entity.PersonEntity;
import com.chris.springdb.repository.PersonRepository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
        Session currentSession = getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.persist(entity);
        transaction.commit();
        currentSession.close();
    }

    public Long save(PersonEntity entity) {
        Session currentSession = getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();
        Long save = (Long) currentSession.save(entity);
        transaction.commit();
        currentSession.close();
        return save;
    }

    public void saveOrUpdate(PersonEntity entity) {
        Session currentSession = getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.saveOrUpdate(entity);
        transaction.commit();
        currentSession.close();
    }

    public void delete(Long id) {
        Session currentSession = getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();
        PersonEntity person = load(id);
        currentSession.delete(person);
        transaction.commit();
        currentSession.close();
    }

    public void flush() {
        Session currentSession = getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.flush();
        transaction.commit();
        currentSession.close();
    }
}