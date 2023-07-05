package com.lucasffm.conduitapi.dtos.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class UserSignUpDTO {
  @NotBlank
  @Email
  private String email;
  @NotBlank
  @Min(10)
  @Max(50)
  private String password;
  @NotBlank
  @Min(8)
  @Max(100)
  private String username;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
