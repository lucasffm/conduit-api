package com.lucasffm.conduitapi.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasffm.conduitapi.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, UUID> {

}
