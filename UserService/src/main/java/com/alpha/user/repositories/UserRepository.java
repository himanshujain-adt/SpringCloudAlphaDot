package com.alpha.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.user.entites.User;


public interface UserRepository extends JpaRepository<User, String> {

}
