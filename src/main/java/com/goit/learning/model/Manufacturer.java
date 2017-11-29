package com.goit.learning.model;

import org.hibernate.annotations.GenericGenerator;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "manufacturers")
public class Manufacturer implements Comparable<Manufacturer> {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "manufacturer")
    private Set<Product> products;

    public Manufacturer() {
    }

    public Manufacturer(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public Manufacturer setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Manufacturer setName(String name) {
        this.name = name;
        return this;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public Manufacturer setProducts(Set<Product> products) {
        this.products = products;
        return this;
    }

    public int compareTo(@NotNull Manufacturer o) {
        return name.compareTo(o.name);
    }
}
