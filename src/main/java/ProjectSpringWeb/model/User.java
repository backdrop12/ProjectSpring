package ProjectSpringWeb.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.mapping.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String role="user";
    private String email;


    public User toReturnUser() {
        User user =new User();
        user.setId(this.id);
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setRole(this.role);
        user.setEmail(this.email);
        return user;
    }

}
