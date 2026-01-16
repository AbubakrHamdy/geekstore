package aaa.group.geekstore.controller;

import aaa.group.geekstore.model.UserAddress;
import aaa.group.geekstore.service.UserAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user-addresses")
@RequiredArgsConstructor
public class UserAddressController {

    private final UserAddressService userAddressService;

    @GetMapping
    public List<UserAddress> getAll() {
        return userAddressService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAddress> getById(@PathVariable UUID id) {
        return userAddressService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UserAddress create(@RequestBody UserAddress userAddress) {
        return userAddressService.create(userAddress);
    }

    @PutMapping("/{id}")
    public UserAddress update(@PathVariable UUID id, @RequestBody UserAddress userAddress) {
        return userAddressService.update(id, userAddress);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        userAddressService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
