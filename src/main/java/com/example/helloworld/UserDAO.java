package com.example.helloworld;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.helloworld.model.User;
import com.example.helloworld.repositories.UserRepository;

@Service
public class UserDAO {
	private static final Map<Integer, User> userMap = new HashMap<Integer, User>();

	@Autowired
	private UserRepository repository;

	public List<User> findAlluser() {
		return repository.findAll();
	}
	public User updateUser(User user) {
		userMap.put(user.getId(), user);
		return user;
	}

	public User getUserById(int id) {
		return repository.findById(id);

	}

	public User createUser(User user) {
		long countById = 0;
		countById = repository.count();
		int count = (int) (long) countById;
		if (count == 0) {
			user.setId(0);
		} else {
			user.setId(count++);
		}
		return repository.save(user);
	}

	public void deleteUser(int id) {
		repository.delete(repository.findById(id));

	}

	public User saveUser(User user) {
		return repository.save(user);
	}

}
