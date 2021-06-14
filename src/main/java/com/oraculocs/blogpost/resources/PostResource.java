package com.oraculocs.blogpost.resources;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oraculocs.blogpost.entities.Post;
import com.oraculocs.blogpost.services.PostService;

@Controller
public class PostResource {
	
	@Autowired
	private PostService postService;
	
	//Requisições que retornam para a página HTML no Thymeleaf
	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public ModelAndView getPosts() {
		ModelAndView mv = new ModelAndView("posts");
		List<Post> posts = postService.findAll();
		mv.addObject("posts", posts);
		return mv;
	}
	
	@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
	public ModelAndView getPostDetalhes(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("postDetalhes");
		Post post = postService.findById(id);
		mv.addObject("post", post);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/newpost" )
	public String getPostForm() {
		return "postForm";
	}
	
	@RequestMapping(value = "/newpost", method = RequestMethod.POST)
	public String savePost(@Validated Post post, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/newpost";
        }
        post.setData(LocalDate.now());
        postService.save(post);
        return "redirect:/posts";
	}
	
	
//	//Requisições para teste no Postman 
//	@GetMapping(value = "/apiposts")
//	public ResponseEntity<List<Post>> findAll(){
//		List<Post> list = postService.findAll();
//		return ResponseEntity.ok().body(list);
//	}
//
//	@GetMapping(value = "/apiposts/{id}")
//	public ResponseEntity<Post> findById(@PathVariable("id") Long id){
//		Post post = postService.findById(id);
//		return ResponseEntity.ok().body(post);
//	}
	
	
}
