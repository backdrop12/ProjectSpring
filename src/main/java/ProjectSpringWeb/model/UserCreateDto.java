package ProjectSpringWeb.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class UserCreateDto {
    @NotNull
    @NotBlank

    private String password;
    private String email;
    private String role;
    private String getName;

    public static User toUser() {
        User user = new User();
        user.setUsername(getName);
        user.setPassword(getPassword());
        user.setEmail(getEmail());
        user.setRole(getRole());

        return user;
    }
}
