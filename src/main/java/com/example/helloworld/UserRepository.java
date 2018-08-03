package com.example.helloworld;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
	//public User findByfirstName(String firstName);
	//public User findBylastName(String lastName);
	//public List<User> findBylastName(String lastName);
}
