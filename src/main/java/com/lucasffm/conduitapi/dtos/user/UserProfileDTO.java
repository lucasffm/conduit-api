package com.lucasffm.conduitapi.dtos.user;

import java.time.LocalDateTime;

public class UserProfileDTO {
  String id;
  String email;
  String username;
  String bio;
  String image;
  LocalDateTime createdAt;
  LocalDateTime updatedAt;

  public UserProfileDTO() {
  }

  public UserProfileDTO(String id, String email, String username, String bio, String image, LocalDateTime createdAt,
      LocalDateTime updatedAt) {
    this.id = id;
    this.email = email;
    this.username = username;
    this.bio = bio;
    this.image = image;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }
}
