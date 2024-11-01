package ProjectSpringWeb.repository;

import ProjectSpringWeb.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProductJPARepository extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String name);

    @Query(nativeQuery = true, value = "SELECT * FROM PRODUCTS")
    List<Product> getProductsByMySpecialQuery();

    @Query(nativeQuery = false, value = "SELECT p FROM Product p")
    List<Product> getProductsByMySpecialQueryHql();
}
