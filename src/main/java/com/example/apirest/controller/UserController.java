package com.example.apirest.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.apirest.model.StudentTable;
import com.example.apirest.model.StudentTable;
import com.example.apirest.responseWrapper.ResponseWrapper;
import com.example.apirest.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
//@RequestMapping accepts all type of requests
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	ResponseWrapper responseWrapper;

	@GetMapping("")
	public ResponseEntity<StudentTable> getAllUsers() {
		responseWrapper.setMsg("All Users");
		responseWrapper.setData(this.userService.getAll());
		return new ResponseEntity(responseWrapper, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<StudentTable> getUserById(@PathVariable Integer id) {

		responseWrapper.setMsg("user with id " + id);
		responseWrapper.setData(this.userService.getById(id));
		return new ResponseEntity(responseWrapper, HttpStatus.OK);

	}

	@PostMapping("")
	public ResponseEntity<StudentTable> createUser(@RequestBody @Valid StudentTable user) {
		responseWrapper.setMsg("user created succesfully");
		responseWrapper.setData(this.userService.create(user));
		return new ResponseEntity(responseWrapper, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<StudentTable> updateUser(@PathVariable Integer id, @RequestBody @Valid StudentTable user) {
		responseWrapper.setMsg("user updated succesfully");
		responseWrapper.setData(this.userService.update(id, user));
		return new ResponseEntity(responseWrapper, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<StudentTable> deleteUser(@PathVariable Integer id) {
		responseWrapper.setMsg("user with id " + id + " deleted nsuccesfully");
		responseWrapper.setData(this.userService.delete(id));
		return new ResponseEntity(responseWrapper, HttpStatus.OK);

	}

	@GetMapping("/find")
	public ResponseEntity<StudentTable> findUserByName(@RequestParam("name") String name) {
		responseWrapper.setMsg("User with name " + name);
		responseWrapper.setData(this.userService.findByName(name));
		return new ResponseEntity(responseWrapper, HttpStatus.OK);

	}

	@GetMapping("/find-by-email/{email}")
	public ResponseEntity<StudentTable> findUserByEmail(@PathVariable String email) {
		responseWrapper.setMsg("User with email " + email);
		responseWrapper.setData(this.userService.findByEmail(email));
		return new ResponseEntity(responseWrapper, HttpStatus.OK);
	}
}
