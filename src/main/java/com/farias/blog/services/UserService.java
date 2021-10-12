package com.farias.blog.services;

import com.farias.blog.dao.UserRepository;
import com.farias.blog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PostLoad;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    //repo with JPARepository queries
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /*
    Methods that return User information
     */
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User findUserByEmail(String email) {
        for(User u : getUsers()) {
            if(u.getEmail().equals(email)) {
                System.out.printf("User with email: %s does exist\n", email);
                return u;
            }
        }

        System.out.printf("User with email: %s does not exist\n", email);
        return null;
    }

    /*
    Create, Update, and Delete Methods
     */
    public void addNewUser(User user) {
        System.out.println(user);
        userRepository.save(user);
    }

    public void deleteUserById(long id){

        userRepository.deleteById(id);
    }

    /*
    Validation methods
     */
    public boolean checkEmailPassword(String email, String password){
        //finds a User with this email, else returns null
        User u = findUserByEmail(email);

        if(u == null) {
            System.out.println("Email is incorrect:" + email);
            return false;
        } else if (u.getPassword().equals(password)) {
            System.out.println("Password is correct");
            return true;
        }

        //if somehow the boolean statements don't trap every possibility this will be changed
        return false;

    }




}
