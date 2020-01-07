package com.blueocean.mall.provider.payload.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginDto {
    @NotBlank
    private String usernameOrEmail;

    @NotBlank
    private String password;

}
