package aaa.group.geekstore.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "ordered_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderedItem {

    @Id
    @GeneratedValue
    private UUID id;

    private int quantity;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCart;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
