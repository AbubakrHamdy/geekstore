package aaa.group.geekstore.service;

import aaa.group.geekstore.model.Admin;
import aaa.group.geekstore.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;

    public List<Admin> getAll() {
        return adminRepository.findAll();
    }

    public Optional<Admin> getById(UUID id) {
        return adminRepository.findById(id);
    }

    public Admin create(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin update(UUID id, Admin admin) {
        admin.setId(id);
        return adminRepository.save(admin);
    }

    public void deleteById(UUID id) {
        adminRepository.deleteById(id);
    }
}
