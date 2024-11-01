package ProjectSpringWeb.controller;

import ProjectSpringWeb.model.OrderReturnDto;
import ProjectSpringWeb.service.impl.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<OrderReturnDto> getOrders(){
        return orderService.getOrders();
    }


}
