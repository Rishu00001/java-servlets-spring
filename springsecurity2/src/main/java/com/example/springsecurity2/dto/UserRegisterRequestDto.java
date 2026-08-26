package com.example.springsecurity2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@NoArgsConstructor
public class UserRegisterRequestDto {
    @NotBlank
    private String username;

    @NotBlank
    @Size(min = 6, max = 100)
    private String password;
}
