package com.emond.mall.business.user.payload.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class LoginDto {
    @NotBlank
    private String usernameOrEmail;

    @NotBlank
    private String password;

}
