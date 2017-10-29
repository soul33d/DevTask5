package com.goit.learning.dao.hibernate;

import com.goit.learning.dao.GenericDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static com.goit.learning.dao.hibernate.SessionFactorySingleton.getSessionFactory;

public class EntityDAO<T, ID extends Serializable> implements GenericDAO<T, ID> {

    private Class<T> tClass;
    private String simpleName;

    public EntityDAO(Class<T> tClass) {
        this.tClass = tClass;
        simpleName = tClass.getSimpleName();
    }

    @SuppressWarnings("unchecked")
    public Set<T> readAll() {
        Session session = getSessionFactory().openSession();
        List<T> list = session.createQuery("from " + simpleName).list();
        return new TreeSet<T>(list);
    }

    public T getById(ID id) {
        Session session = getSessionFactory().openSession();
        return session.get(tClass, id);
    }

    public void write(T t) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(t);
        transaction.commit();
        session.close();
    }

    public void update(T t) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(t);
        transaction.commit();
        session.close();
    }

    public void delete(T t) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(t);
        transaction.commit();
        session.close();
    }
}
