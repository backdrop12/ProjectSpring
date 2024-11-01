package ProjectSpringWeb.repository;

import ProjectSpringWeb.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM orders")
    List<Order> findAllOrders(Pageable pageable);
}
