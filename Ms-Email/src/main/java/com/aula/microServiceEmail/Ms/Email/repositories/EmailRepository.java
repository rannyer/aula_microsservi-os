package com.aula.microServiceEmail.Ms.Email.repositories;

import com.aula.microServiceEmail.Ms.Email.models.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmailRepository extends JpaRepository<EmailModel, UUID> {
}


