package com.goit.learning.dao.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class SessionFactorySingleton {
    private SessionFactorySingleton() {
    }

    public static SessionFactory getSessionFactory() {
        return FactoryHolder.SESSION_FACTORY;
    }

    private static final class FactoryHolder {
        private static final SessionFactory SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }
}
