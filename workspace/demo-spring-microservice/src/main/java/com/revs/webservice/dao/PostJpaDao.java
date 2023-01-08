package com.revs.webservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revs.webservice.entity.Post;

public interface PostJpaDao extends JpaRepository<Post, Integer>{

}
