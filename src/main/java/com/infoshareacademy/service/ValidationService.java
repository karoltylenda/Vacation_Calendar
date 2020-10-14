package com.infoshareacademy.service;

import com.infoshareacademy.repository.UserRepository;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import java.util.logging.Logger;

@LocalBean
public class ValidationService {

    @Inject
    private UserRepository userRepository;

    private static final Logger LOGGER = Logger.getLogger(ValidationService.class.getName());

    public boolean isAuthenticated(String email, String password){
        boolean isAuthenticated = false;
        try {
            if (userRepository.findByEmail(email).getPassword().equals(password)){
                isAuthenticated = true;
            }
        } catch (Exception e){
            LOGGER.warning(e.getMessage());
        }
        return isAuthenticated;
    }

}
