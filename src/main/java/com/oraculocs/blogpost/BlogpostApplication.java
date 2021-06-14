package com.oraculocs.blogpost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.oraculocs.blogpost.repositories.PostRepository;

@SpringBootApplication
public class BlogpostApplication implements CommandLineRunner{
	
	
	@Autowired
	private PostRepository postRepository;

	public static void main(String[] args) {
		SpringApplication.run(BlogpostApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		
//		List<Post> list = new ArrayList<>();
//
//		Post post1 = new Post(null, "Java Spring", "Carlos Augusto", LocalDate.now(), "O maior benefício de usar o Spring Boot é "
//				+ "conseguir otimizar seu tempo e aumentar sua produtividade, já que ele simplifica o desenvolvimento de aplicações.");
//		
//		Post post2 = new Post(null, "Banco de Dados", "Alex Vargas", LocalDate.now(), "Um sistema de banco de dados (DBMS) é uma coleção de dados"
//				+ " inter-relacionados e um conjunto de programas para acessar esses dados.");
//		
//		Post post3 = new Post(null, "Angular", "Beto Silva", LocalDate.now(), "O AngularJS é um framework de código aberto usado para construir aplicativos para web baseados "
//				+ "em uma única página dinâmica");
//		
//		list.addAll(Arrays.asList(post1, post2, post3));
//		
//		postRepository.saveAll(list);
	}

}
