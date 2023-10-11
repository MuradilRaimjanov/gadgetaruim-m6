package com.peaksoft.gadgetaruimm6.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterRequest {

    @NotBlank(message = "First Name должен быть заполнен")
    @Pattern(regexp = "^[a-zA-Z0-9a-яA-Я. _-]{4,15}$", message = "некорректный first Name")
    String firstName;

    @NotBlank(message = "Last name должен быть заполнен")
    String lastName;

    @NotBlank(message = "Email должен быть заполнен")
    @Email(message = "Enter a valid email address")
    String email;

    @NotBlank(message = "Enter your password")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}",
            message = "пароль некорректный")
    @Length(min = 8, max = 20, message = " пароль должен содержать не менее от 8 до 20 символов, в том числе цифры и спецсимволов")
    String password;

    String repeatPassword;

    @NotBlank(message = "Phone number должен быть заполнен")
    String phoneNumber;


}
