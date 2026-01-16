package aaa.group.geekstore.service;

import aaa.group.geekstore.model.OrderedItem;
import aaa.group.geekstore.repository.OrderedItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderedItemService {

    private final OrderedItemRepository orderedItemRepository;

    public List<OrderedItem> getAll() {
        return orderedItemRepository.findAll();
    }

    public Optional<OrderedItem> getById(UUID id) {
        return orderedItemRepository.findById(id);
    }

    public OrderedItem create(OrderedItem orderedItem) {
        return orderedItemRepository.save(orderedItem);
    }

    public OrderedItem update(UUID id, OrderedItem orderedItem) {
        orderedItem.setId(id);
        return orderedItemRepository.save(orderedItem);
    }

    public void deleteById(UUID id) {
        orderedItemRepository.deleteById(id);
    }
}
