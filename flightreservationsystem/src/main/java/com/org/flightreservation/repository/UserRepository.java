package com.org.flightreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.flightreservation.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);

}
