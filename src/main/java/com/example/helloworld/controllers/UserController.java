package com.example.helloworld.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloworld.User;
import com.example.helloworld.UserDAO;
import com.example.helloworld.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {

	public static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserRepository repository;

	@Autowired
	private UserDAO userDao;

	// Get All Users
	@GetMapping("/users")
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users = repository.findAll();
		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(users, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	// Get single user
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable("id") int id) {
		return userDao.getUserById(id);
//		return repository.findById(id);

	}

	// Add user
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		userDao.createUser(user);
		logger.warn("show" + user);
		return userDao.saveUser(user);
	}

	// Delete user
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		if (userDao.getUserById(id) == null) {
			logger.warn("User with id " + id + " not found");
		} else {
			userDao.deleteUser(id);
		}
	}

	// Update user
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user) {
		User currentUser = userDao.getUserById(id);
		if (currentUser == null) {
			logger.warn("User with id " + id + " not found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		currentUser.setFirstName(user.getFirstName());
		currentUser.setLastName(user.getLastName());
		userDao.updateUser(currentUser);
		userDao.saveUser(currentUser);
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);

	}

	/*
	 * public String welcome(@ModelAttribute User user, Model model) {
	 * 
	 * List<User> users = repository.findAll(); model.addAttribute("users", users);
	 * 
	 * return "userform"; }
	 */

	/*
	 * @PostMapping("/save") public String save(@ModelAttribute User user, Model
	 * model) { model.addAttribute("user", user); repository.save(user);
	 * 
	 * return "result"; }
	 */

}