package ProjectSpringWeb.model;

import lombok.Data;

import java.util.List;

@Data
public class UserReturnDto {
    private Long id;
    private List<User> users;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String password;
    private String confirmPassword;
}
