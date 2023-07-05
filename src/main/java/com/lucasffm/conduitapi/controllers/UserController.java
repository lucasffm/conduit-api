package com.lucasffm.conduitapi.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasffm.conduitapi.dtos.user.UserProfileDTO;
import com.lucasffm.conduitapi.dtos.user.UserSignUpDTO;
import com.lucasffm.conduitapi.dtos.user.UserWrapperDTO;
import com.lucasffm.conduitapi.models.UserModel;
import com.lucasffm.conduitapi.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  UserService userService;

  @PostMapping
  public ResponseEntity<UserWrapperDTO<UserProfileDTO>> signUp(@RequestBody UserWrapperDTO<UserSignUpDTO> body) {
    UserModel user = new UserModel();
    BeanUtils.copyProperties(body.getUser(), user);

    var newUser = userService.createUser(user);

    UserProfileDTO userProfileDTO = new UserProfileDTO(newUser.getId(), newUser.getEmail(), newUser.getUsername(),
        newUser.getBio(), newUser.getImage(), newUser.getCreatedAt(), newUser.getUpdatedAt());

    UserWrapperDTO<UserProfileDTO> result = new UserWrapperDTO<UserProfileDTO>();
    result.setUser(userProfileDTO);

    return ResponseEntity.ok(result);
  }

}
