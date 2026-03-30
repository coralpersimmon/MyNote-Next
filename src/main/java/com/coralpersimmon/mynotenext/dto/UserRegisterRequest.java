package com.coralpersimmon.mynotenext.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterRequest {
    @NotBlank
    private String account;

    @NotBlank
    private String password;
}
