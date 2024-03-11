package com.javacompany.springbootkafakaexample.repository;

import com.javacompany.springbootkafakaexample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
