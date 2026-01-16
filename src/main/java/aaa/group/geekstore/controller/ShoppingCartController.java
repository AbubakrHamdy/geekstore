package aaa.group.geekstore.controller;

import aaa.group.geekstore.model.ShoppingCart;
import aaa.group.geekstore.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/shopping-carts")
@RequiredArgsConstructor
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @GetMapping
    public List<ShoppingCart> getAll() {
        return shoppingCartService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingCart> getById(@PathVariable UUID id) {
        return shoppingCartService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ShoppingCart create(@RequestBody ShoppingCart shoppingCart) {
        return shoppingCartService.create(shoppingCart);
    }

    @PutMapping("/{id}")
    public ShoppingCart update(@PathVariable UUID id, @RequestBody ShoppingCart shoppingCart) {
        return shoppingCartService.update(id, shoppingCart);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        shoppingCartService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
