package aaa.group.geekstore.service;

import aaa.group.geekstore.model.Brand;
import aaa.group.geekstore.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;

    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    public Optional<Brand> getById(UUID id) {
        return brandRepository.findById(id);
    }

    public Brand create(Brand brand) {
        return brandRepository.save(brand);
    }

    public Brand update(UUID id, Brand brand) {
        brand.setId(id);
        return brandRepository.save(brand);
    }

    public void deleteById(UUID id) {
        brandRepository.deleteById(id);
    }
}
