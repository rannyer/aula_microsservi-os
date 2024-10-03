package com.aula.micreoservice01.MicroService01.repositories;

import com.aula.micreoservice01.MicroService01.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
}
