package com.lucasffm.conduitapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasffm.conduitapi.configs.SecurityConfiguration;
import com.lucasffm.conduitapi.models.UserModel;
import com.lucasffm.conduitapi.repositories.UserRepository;

@Service
public class UserService {
  @Autowired
  UserRepository userRepository;

  @Autowired
  SecurityConfiguration webSecurityConfig;

  public UserModel createUser(UserModel userModel) {
    userModel.setPassword(webSecurityConfig.passwordEncoder().encode(userModel.getPassword()));
    return userRepository.save(userModel);
  }
}
