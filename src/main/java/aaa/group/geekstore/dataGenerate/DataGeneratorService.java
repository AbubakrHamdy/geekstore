package aaa.group.geekstore.dataGenerate;

import aaa.group.geekstore.enums.Gender;
import aaa.group.geekstore.enums.OrderStatus;
import aaa.group.geekstore.model.*;
import aaa.group.geekstore.repository.*;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.*;

@Service
@RequiredArgsConstructor
public class DataGeneratorService {

    private final CustomerRepository customerRepository;
    private final AdminRepository adminRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    private final OrderRepository orderRepository;
    private final  ShoppingCartRepository shoppingCartRepository;
    private final OrderedItemRepository orderedItemRepository;
    private final ProductRepository productRepository;
    private static final Faker faker = new Faker();
    public void clean() {

        orderedItemRepository.deleteAll();
        shoppingCartRepository.deleteAll();
        orderRepository.deleteAll();

        productRepository.deleteAll();

        brandRepository.deleteAll();
        categoryRepository.deleteAll();

        customerRepository.deleteAll();
    }

    public void generateCustomers(int count) {

        for (int i = 0; i < count; i++) {
            Gender gender = faker.bool().bool() ? Gender.MALE : Gender.FEMALE;
            Customer customer = Customer.builder()
                    .name(faker.name().fullName())
                    .gender(gender)
                    .email(faker.internet().emailAddress())
                    .mobile(faker.phoneNumber().cellPhone())
                    .build();

            List<UserAddress> addresses = new ArrayList<>();

            int addressCount = faker.number().numberBetween(1, 3);

            for (int j = 0; j < addressCount; j++) {
                UserAddress address = UserAddress.builder()
                        .street(faker.address().streetAddress())
                        .city(faker.address().city())
                        .country(faker.address().country())
                        .postalCode(faker.address().zipCode())
                        .customer(customer)
                        .build();

                addresses.add(address);
            }

            customer.setAddresses(addresses);

            customerRepository.save(customer); // saves customer + addresses
        }
    }

    private <T> List<T> pickRandom(List<T> source, int min, int max) {
        Collections.shuffle(source);
        int size = faker.number().numberBetween(min, Math.min(max, source.size()) + 1);
        return new ArrayList<>(source.subList(0, size));
    }

    public void seed(int productCount, int orderCount) {
        seedProducts(productCount);
        seedOrders(orderCount);
    }

    private void seedProducts(int count) {

        List<Category> categories = seedCategories(10);
        List<Brand> brands = seedBrands(8);

        for (int i = 0; i < count; i++) {
            Product product = new Product();
            product.setName(faker.commerce().productName());
            product.setPrice(BigDecimal.valueOf(
                    faker.number().randomDouble(2, 10, 500)
            ));
            product.setStock(faker.number().numberBetween(1, 100));

            product.setCategories(pickRandom(categories, 1, 3));
            product.setBrands(pickRandom(brands, 1, 2));

            productRepository.save(product); // 🔥 DIRECT INSERT
        }
    }

    private List<Category> seedCategories(int count) {
        List<Category> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Category c = new Category();
            c.setName(faker.commerce().department());
            list.add(categoryRepository.save(c));
        }
        return list;
    }

    private List<Brand> seedBrands(int count) {
        List<Brand> list = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Brand b = new Brand();
            b.setName(faker.company().name());
            list.add(brandRepository.save(b));
        }
        return list;
    }

    private void seedOrders(int count) {

        List<Product> products = productRepository.findAll();
        List<Customer> customers = customerRepository.findAll();

        for (int i = 0; i < count; i++) {

            Customer customer = faker.options().nextElement(customers);

            Order order = new Order();
            order.setStatus(faker.options().option(OrderStatus.class));
            order.setCreatedAt(Instant.now());
            order.setCustomer(customer);

            List<OrderedItem> items = new ArrayList<>();

            int itemCount = faker.number().numberBetween(1, 5);
            for (int j = 0; j < itemCount; j++) {

                Product product = faker.options().nextElement(products);

                OrderedItem item = new OrderedItem();
                item.setProduct(product);
                item.setQuantity(faker.number().numberBetween(1, 5));
                item.setPrice(
                        product.getPrice()
                                .multiply(BigDecimal.valueOf(item.getQuantity()))
                );
                item.setOrder(order); // 🔗 relation

                items.add(item);
            }

            order.setItems(items);

            orderRepository.save(order); // 🔥 CASCADE saves OrderedItems
        }
    }

}
