package ProjectSpringWeb.service.impl;

import ProjectSpringWeb.model.CartItem;
import ProjectSpringWeb.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartItemRepository cartItemRepository;

    public void addToCart(Long userId, Long productId, int quantity) {
        Optional<CartItem> existingItem = cartItemRepository.findByUserIdAndProductId(userId, productId);

        if (existingItem.isPresent()) {
            CartItem item = existingItem.get();
            item.setQuantity(item.getQuantity() + quantity);
            cartItemRepository.save(item);
        } else {
            CartItem newItem = new CartItem();
            newItem.setUserId(userId);
            newItem.setProductId(productId);
            newItem.setQuantity(quantity);
            newItem.setCreatedDate(LocalDateTime.now());
            cartItemRepository.save(newItem);
        }
    }

    public List<CartItem> getCartItems(Long userId) {
        return cartItemRepository.findByUserId(userId);
    }

    public void removeFromCart(Long userId, Long productId){
        cartItemRepository.deleteByUserIdAndProductId(userId, productId);
    }
}
