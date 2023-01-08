package com.revs.webservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revs.webservice.dao.PostJpaDao;
import com.revs.webservice.entity.Post;

import jakarta.validation.Valid;

@Service
public class PostJpaService {
	
	@Autowired
	private PostJpaDao dao;

	public Post save(@Valid Post post) {
		// TODO Auto-generated method stub
		
		Post postSaved = dao.save(post);
		
		return postSaved;
	}

	
	
	
}
