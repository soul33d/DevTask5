package com.goit.learning.dao.hibernate;

import com.goit.learning.model.Manufacturer;
import com.goit.learning.model.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EntityDaoHolder {
    private static Map<Class, EntityDAO> daoMap;

    private EntityDaoHolder() {
    }

    static {
        daoMap = new HashMap<Class, EntityDAO>();
        daoMap.put(Manufacturer.class, new EntityDAO<Manufacturer, UUID>(Manufacturer.class));
        daoMap.put(Product.class, new EntityDAO<Product, UUID>(Product.class));
    }

    @SuppressWarnings("unchecked")
    public static <T> EntityDAO<T, UUID> getDao(Class<T> tClass) {
        return daoMap.get(tClass);
    }
}
