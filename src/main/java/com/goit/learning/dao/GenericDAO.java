package com.goit.learning.dao;

import java.util.Set;

public interface GenericDAO<T, ID> {
    Set<T> readAll();

    T getById(ID id);

    void write(T t);

    void update(T t);

    void delete(T t);
}
