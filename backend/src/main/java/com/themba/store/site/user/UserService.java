package com.themba.store.site.user;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findUserByNameOrSurnameOrEmail(String search) {
        Optional<List<User>> optionalUsers = userRepository.findByFirstNameContainingIgnoreCase(search);
        return optionalUsers.get();
    }


    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Page<User> findAllPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public User update(String currentUserName , String firstName, String lastName, MultipartFile avator, String phoneNumber) {
        User newUserDetails = userRepository.findByEmail(currentUserName).get();
        if(!firstName.isEmpty()){
            newUserDetails.setFirstName(firstName);
        }
        if(!lastName.isEmpty()){
            newUserDetails.setLastName(lastName);
        }
        boolean status = changeUserAvator(newUserDetails , avator );


        return newUserDetails;
    }

    private boolean changeUserAvator(User newUserDetails, MultipartFile avator) {
        // Delete Existing Avator for the user and upload knew one.
        return false;
    }
}
