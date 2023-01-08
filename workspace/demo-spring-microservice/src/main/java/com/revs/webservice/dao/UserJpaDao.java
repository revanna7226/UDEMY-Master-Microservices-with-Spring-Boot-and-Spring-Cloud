package com.revs.webservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revs.webservice.entity.User;

public interface UserJpaDao extends JpaRepository<User, Integer> {

}
