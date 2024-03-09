package com.example.apirest.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.apirest.model.StudentTable;
@Repository
public interface UserRepo extends CrudRepository<StudentTable, Integer>{
List<StudentTable>findByName(String name);
List<StudentTable>findByNameLike(String name);
List<StudentTable>findByNameContaining(String name);
Optional<StudentTable>findByEmail(String email);
List<StudentTable>findByEmailContaining(String email);
List<StudentTable>findByNameOrEmail(String name,String email);

}
