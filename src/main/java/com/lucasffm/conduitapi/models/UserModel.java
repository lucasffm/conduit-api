package com.lucasffm.conduitapi.models;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "`User`")
public class UserModel {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  String id;

  @Column(nullable = false, unique = true)
  String email;

  @Column(nullable = false, unique = true)
  String username;

  @Column(nullable = true)
  String bio;

  @Column(nullable = true)
  String image;

  @Column(nullable = false)
  String password;

  @CreatedDate()
  LocalDateTime createdAt;

  @LastModifiedDate()
  LocalDateTime updatedAt;

  @PrePersist
  private void prePersistFunction() {
    this.createdAt = LocalDateTime.now(ZoneId.of("UTC"));
    this.updatedAt = LocalDateTime.now(ZoneId.of("UTC"));
  }

  @PreUpdate
  public void preUpdateFunction() {
    this.updatedAt = LocalDateTime.now(ZoneId.of("UTC"));
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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
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
