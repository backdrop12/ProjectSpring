package ProjectSpringWeb.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Table(name="orders")
@Data
@RequiredArgsConstructor

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean delivered;
    @OneToMany
    private List<Product> products;

    public OrderReturnDto toDto(Order order){
        OrderReturnDto orderReturnDto = new OrderReturnDto();
        orderReturnDto.setId(order.getId());
        orderReturnDto.setDelivered(order.isDelivered());
        orderReturnDto.setProducts(order.getProducts()
                .stream()
                .map(Product::toReturnDto)
                .toList());
        return orderReturnDto;
    }

}
