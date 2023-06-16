package com.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.models.User;

@Repository
public interface TestH2Repository extends JpaRepository<User, Integer> {

}
