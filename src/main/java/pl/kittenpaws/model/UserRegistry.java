package pl.kittenpaws.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
public class UserRegistry {

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;

}
