package com.example.helloworld.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.helloworld.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	public User findById(int id);
	public User countById(int id);

}
