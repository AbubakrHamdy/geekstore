package aaa.group.geekstore.controller;

import aaa.group.geekstore.model.OrderedItem;
import aaa.group.geekstore.service.OrderedItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ordered-items")
@RequiredArgsConstructor
public class OrderedItemController {

    private final OrderedItemService orderedItemService;

    @GetMapping
    public List<OrderedItem> getAll() {
        return orderedItemService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderedItem> getById(@PathVariable UUID id) {
        return orderedItemService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public OrderedItem create(@RequestBody OrderedItem orderedItem) {
        return orderedItemService.create(orderedItem);
    }

    @PutMapping("/{id}")
    public OrderedItem update(@PathVariable UUID id, @RequestBody OrderedItem orderedItem) {
        return orderedItemService.update(id, orderedItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        orderedItemService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
