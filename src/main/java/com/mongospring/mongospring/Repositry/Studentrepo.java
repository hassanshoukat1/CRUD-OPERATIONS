package com.mongospring.mongospring.Repositry;

import com.mongospring.mongospring.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Studentrepo extends MongoRepository<Student,Integer> {
}
