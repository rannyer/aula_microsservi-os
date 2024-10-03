package com.aula.micreoservice01.MicroService01.services;

import com.aula.micreoservice01.MicroService01.models.UserModel;
import com.aula.micreoservice01.MicroService01.producers.UserProducer;
import com.aula.micreoservice01.MicroService01.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    final UserRepository userRepository;
    final UserProducer userProducer;

    public  UserService(UserRepository userRepository, UserProducer userProducer){
        this.userRepository = userRepository;
        this.userProducer = userProducer;
    }


    @Transactional
    public UserModel save(UserModel userModel){
        userModel = userRepository.save(userModel);
        userProducer.publishMessageEmail(userModel);
        return userModel;
    }
}
