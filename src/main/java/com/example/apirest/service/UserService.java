package com.example.apirest.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.apirest.model.StudentTable;
import com.example.apirest.repo.UserRepo;

@Service

public class UserService {
	HashMap<Integer, StudentTable> data = new HashMap<>();
	AtomicInteger atomicInteger = new AtomicInteger();
//Here we are chnaging return type void to User in create,update, delete method
//	because we want to display created user data

	@Autowired
	UserRepo userRepo;

	public StudentTable create(StudentTable user) {
		return userRepo.save(user);
	}

//	Return type for the method is Iterable
	public Iterable<StudentTable> getAll() {
		return this.userRepo.findAll();
	}

	public StudentTable getById(Integer id) {
		return this.userRepo.findById(id).orElseThrow(() -> {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id" + id + " does not exist");
		});
	}

	public StudentTable update(Integer id, StudentTable user) {
		getById(id);
		user.setId(id);
		return this.userRepo.save(user);
	}

	public StudentTable delete(Integer id) {
		StudentTable user = getById(id);
		this.userRepo.deleteById(id);
		return user;
	}

	public List<StudentTable> findByName(String name) {
//		return this.userRepo.findByName(name);
//		return this.userRepo.findByNameLike(name);
		return this.userRepo.findByNameContaining(name);

	}

	public StudentTable findByEmail(String email) {
		return this.userRepo.findByEmail(email).orElseThrow(() -> {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with email" + email + "not found");
			
		});
	}
}
