package com.chris.springdb.repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Chris on 2017/11/13.
 * 数据库访问层（repository）
 */

public interface DomainRepository<T,PK extends Serializable>{
    T load(PK id);

    T get(PK id);

    List<T> findAll();

    void persist(T entity);

    PK save(T entity);

    void saveOrUpdate(T entity);

    void delete(PK id);

    void flush();
}