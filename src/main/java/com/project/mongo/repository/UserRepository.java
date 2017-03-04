package com.project.mongo.repository;

import com.project.mongo.entity.User;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {


}