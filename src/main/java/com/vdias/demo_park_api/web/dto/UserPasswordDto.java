package com.vdias.demo_park_api.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class UserPasswordDto {

    @NotBlank
    @Size(min = 6, max = 10)
    private String currentPassword;

    @NotBlank
    @Size(min = 6, max = 10)
    private String newPassword;
    
    @NotBlank
    @Size(min = 6, max = 10)
    private String confirmPassword;
}
