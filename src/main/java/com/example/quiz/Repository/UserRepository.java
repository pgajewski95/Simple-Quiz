package com.example.quiz.Repository;

import com.example.quiz.Model.Person;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Person, Integer> {
}
