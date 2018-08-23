package com.example.helloworld.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.helloworld.model.Users;

public interface UsersRepository extends MongoRepository<Users, String> {
	Users findByUsername(String username);
}
