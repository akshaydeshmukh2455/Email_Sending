package com.app.emailSending.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.emailSending.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
