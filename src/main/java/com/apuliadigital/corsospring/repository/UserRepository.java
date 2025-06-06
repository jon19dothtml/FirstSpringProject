package com.apuliadigital.corsospring.repository;

import com.apuliadigital.corsospring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
