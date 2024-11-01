package ProjectSpringWeb.service.impl;

import ProjectSpringWeb.model.Store;
import ProjectSpringWeb.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoreService{

    private final StoreRepository storeRepository;

    @Autowired
    public StoreService(StoreRepository storeRepository){
        this.storeRepository = storeRepository;
    }

   public Store findStoreByName(String name) {
        Optional<Store> storeOptional = storeRepository.findByStoreName(name);
        return storeOptional.orElse(null); // Return null if not found
    }

}
