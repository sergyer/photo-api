package com.project.mongo.services;

import com.project.mongo.entity.User;
import com.project.mongo.repository.UserRepository;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    
    public void save(User user){

        repository.save(user);
    }
    
    public List<User> findAll(){
        return repository.findAll();
    }


    public void delete(Long id) {
        repository.delete(id);
    }

    public User update(User user,Long id) {
        User existingUser = repository.findOne(id);
        BeanUtils.copyProperties(user,existingUser);
        return repository.save(existingUser);
    }

}
