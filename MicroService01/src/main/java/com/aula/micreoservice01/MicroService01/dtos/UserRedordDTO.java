package com.aula.micreoservice01.MicroService01.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRedordDTO(@NotBlank String name,
                            @NotBlank @Email String email) {
}
