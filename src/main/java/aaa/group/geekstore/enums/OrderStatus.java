package aaa.group.geekstore.enums;

public enum OrderStatus {
    PENDING,        // Order created but not processed yet
    PROCESSING,     // Order is being prepared
    SHIPPED,        // Order has been shipped
    DELIVERED,      // Order delivered to customer
    CANCELLED,      // Order cancelled by customer or admin
    RETURNED        // Order returned by customer
}
