package aaa.group.geekstore.service;

import aaa.group.geekstore.model.UserAddress;
import aaa.group.geekstore.repository.UserAddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserAddressService {

    private final UserAddressRepository userAddressRepository;

    public List<UserAddress> getAll() {
        return userAddressRepository.findAll();
    }

    public Optional<UserAddress> getById(UUID id) {
        return userAddressRepository.findById(id);
    }

    public UserAddress create(UserAddress userAddress) {
        return userAddressRepository.save(userAddress);
    }

    public UserAddress update(UUID id, UserAddress userAddress) {
        userAddress.setId(id);
        return userAddressRepository.save(userAddress);
    }

    public void deleteById(UUID id) {
        userAddressRepository.deleteById(id);
    }
}
