package com.peaksoft.gadgetaruimm6.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class ResetPasswordRequest {

    private String email;
    private String otp;

    @NotBlank(message = "Enter your password")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}",
            message = "пароль некорректный")
    @Length(min = 8, max = 20, message = " пароль должен содержать не менее от 8 до 20 символов, в том числе цифры и спецсимволов")
    private String newPassword;

}
