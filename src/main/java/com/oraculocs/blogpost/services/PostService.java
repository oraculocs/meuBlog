package com.oraculocs.blogpost.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oraculocs.blogpost.entities.Post;
import com.oraculocs.blogpost.repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public List<Post> findAll(){
		return postRepository.findAll();
	}

	public Post findById(Long id) {
		return postRepository.findById(id).get();
	}
	
	public Post save(Post post) {
		return postRepository.save(post);
	}
}
