package com.securitytest.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.securitytest.test.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
