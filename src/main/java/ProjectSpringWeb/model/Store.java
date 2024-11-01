package ProjectSpringWeb.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "stores")
@Data
@RequiredArgsConstructor
@Component
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String storeName;
    private String address;

    public Store(String storeName, String address) {
        this.id = id;
        this.storeName = storeName;
        this.address = address;
    }

    public Store toReturnStore() {
        Store store = new Store();
        store.setStoreName(storeName);
        store.setAddress(address);

        return store;
    }

}
