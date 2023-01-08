package com.revs.webservice.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.revs.webservice.dao.PostJpaDao;
import com.revs.webservice.entity.Post;
import com.revs.webservice.entity.User;
import com.revs.webservice.resource.exception.UserNotFoundException;
import com.revs.webservice.service.PostJpaService;
import com.revs.webservice.service.UserJpaService;
import com.revs.webservice.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {
	private UserJpaService service;
	private PostJpaService postService;

	public UserJpaResource(UserJpaService service, PostJpaService postService) {
		this.service = service;
		this.postService = postService;
	}

	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers() {
		return service.getUsers();
	}
	
	@GetMapping("/jpa/users/{id}")
	public EntityModel<Optional<User>> retrieveUser(@PathVariable int id) {

		Optional<User> user = service.getUserById(id);
		
		if (user.isEmpty()) {
			throw new UserNotFoundException("User with ID "+ id + " is not found!");
		}
		
		EntityModel<Optional<User>> userEntityModel = EntityModel.of(user);
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		userEntityModel.add(link.withRel("all-users"));
 		
		return userEntityModel;
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		service.saveUser(user);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(user.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteUserById(id);
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> getUserPosts(@PathVariable int id) {
		Optional<User> user = service.getUserById(id);
		
		if (user.isEmpty()) {
			throw new UserNotFoundException("User with ID "+ id + " is not found!");
		}
		
		return user.get().getPosts();
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Post> savePost(@PathVariable int id, @Valid @RequestBody Post post) {
		Optional<User> user = service.getUserById(id);
		post.setUser(user.get());
		Post savedPost = postService.save(post);
		
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedPost.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
}
