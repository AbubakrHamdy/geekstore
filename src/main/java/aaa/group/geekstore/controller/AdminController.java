package aaa.group.geekstore.controller;

import aaa.group.geekstore.model.Admin;
import aaa.group.geekstore.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/admins")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping
    public List<Admin> getAll() {
        return adminService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getById(@PathVariable UUID id) {
        return adminService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Admin create(@RequestBody Admin admin) {
        return adminService.create(admin);
    }

    @PutMapping("/{id}")
    public Admin update(@PathVariable UUID id, @RequestBody Admin admin) {
        return adminService.update(id, admin);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        adminService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
