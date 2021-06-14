package com.oraculocs.blogpost.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.oraculocs.blogpost.entities.Post;
import com.oraculocs.blogpost.services.PostService;

@RestController
public class PostRestResource {
	
	@Autowired
	private PostService postService;
	
	//Requisições para Teste no Postman ou via Browser
	@GetMapping(value = "/apiposts")
	public ResponseEntity<List<Post>> findAll(){
		List<Post> list = postService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/apiposts/{id}")
	public ResponseEntity<Post> findById(@PathVariable("id") Long id){
		Post post = postService.findById(id);
		return ResponseEntity.ok().body(post);
	}
	
	
	
	
}
