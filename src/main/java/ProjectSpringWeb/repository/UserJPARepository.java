package ProjectSpringWeb.repository;

import ProjectSpringWeb.model.Product;
import ProjectSpringWeb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserJPARepository extends JpaRepository<User, Long> {

    Optional<User> findByName(String name);

    @Query(nativeQuery = true, value = "SELECT * FROM Users")
    List<Product> getUserByMySpecialQuery();

}
