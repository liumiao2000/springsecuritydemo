package com.securitytest.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.securitytest.test.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
	public User findByName(String userName);
}
