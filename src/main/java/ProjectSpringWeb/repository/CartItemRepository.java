package ProjectSpringWeb.repository;

import ProjectSpringWeb.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
    List<CartItem> findByUserId(Long userId);
    Optional<CartItem> findByUserIdAndProductId(Long userId, Long productId);


    void deleteByUserIdAndProductId(@Param("userId") Long userId, @Param("productId") Long productId);

}
