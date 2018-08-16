package com.example.helloworld;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

	public User findById(int id);
	public User countById(int id);
	//public void updateUser(User user);	
	//public User findByFirstName(String firstName);
	//public User findByLastName(String lastName);

}
