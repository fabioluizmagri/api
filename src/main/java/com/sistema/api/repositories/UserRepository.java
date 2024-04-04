package com.sistema.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sistema.api.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {


}
