package aaa.group.geekstore.repository;

import aaa.group.geekstore.model.OrderedItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderedItemRepository extends JpaRepository<OrderedItem, UUID> {
}
