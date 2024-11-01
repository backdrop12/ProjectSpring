package ProjectSpringWeb.service.impl;

import ProjectSpringWeb.model.OrderReturnDto;
import ProjectSpringWeb.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<OrderReturnDto> getOrders() {
        return orderRepository.findAll()
                .stream()
                .map(order -> order.toDto(order))
                .toList();
    }

}
