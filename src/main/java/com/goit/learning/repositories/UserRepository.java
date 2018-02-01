package com.goit.learning.repositories;

import com.goit.learning.model.Role;
import com.goit.learning.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByEmail(String email);

    @Modifying
    @Transactional
    @Query("update User u set u.firstName = :firstName, u.lastName = :lastName, u.email = :email, u.role = :role " +
            "where u.id = :id")
    void updateUser(@Param("id") UUID id,
                    @Param("firstName") String firstName,
                    @Param("lastName") String lastName,
                    @Param("email") String email,
                    @Param("role") Role role);
}
