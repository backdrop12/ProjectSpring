package ProjectSpringWeb.model;

import lombok.Data;

import java.util.List;

@Data
public class OrderReturnDto {
    private Long id;
    private boolean delivered;
    private List<ProductReturnDto> products;


}
