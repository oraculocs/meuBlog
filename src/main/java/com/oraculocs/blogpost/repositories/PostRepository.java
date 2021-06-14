package com.oraculocs.blogpost.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oraculocs.blogpost.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}
