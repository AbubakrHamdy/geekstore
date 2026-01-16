package aaa.group.geekstore.service;

import aaa.group.geekstore.model.ShoppingCart;
import aaa.group.geekstore.repository.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    public List<ShoppingCart> getAll() {
        return shoppingCartRepository.findAll();
    }

    public Optional<ShoppingCart> getById(UUID id) {
        return shoppingCartRepository.findById(id);
    }

    public ShoppingCart create(ShoppingCart shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    public ShoppingCart update(UUID id, ShoppingCart shoppingCart) {
        shoppingCart.setId(id);
        return shoppingCartRepository.save(shoppingCart);
    }

    public void deleteById(UUID id) {
        shoppingCartRepository.deleteById(id);
    }
}
