package ProjectSpringWeb.controller;

import ProjectSpringWeb.config.AppConfig;
import ProjectSpringWeb.model.Store;
import ProjectSpringWeb.service.impl.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stores")
@RequiredArgsConstructor

public class StoreController {
    private final AppConfig appConfig;
    private final StoreService storeService;
    @GetMapping("/{name}")
    public ResponseEntity<Store> findStoreByName(@PathVariable String name) {
        Store store = storeService.findStoreByName(name);
        if (store != null) {
            return ResponseEntity.ok(store);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}