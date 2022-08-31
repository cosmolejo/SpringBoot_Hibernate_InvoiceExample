package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    private UserRepository userRepository;
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return this.userRepository.findAll();
    }

    public User getUser(Long id){
        Optional<User> user = this.userRepository.findById(id);
        return user.orElse(null);
    }
    public User createUser(User user){
        return this.userRepository.save(user);
    }

    public User updateUser(Long id, User user){
        Optional<User> dbData = this.userRepository.findById(id);

        if(dbData.isPresent()){
            User e = dbData.get();
            e.setName(user.getName());
            e.setPhone(user.getPhone());
            e.setDocument(user.getDocument());
            this.userRepository.save(e);
            return e;
        }

        return null;
    }

    public Boolean deleteUser(Long id){
        try{
            this.userRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

}
