package aaa.group.geekstore.dataGenerate;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final DataGeneratorService dataGeneratorService;

    @Override
    public void run(String... args) {
        dataGeneratorService.clean();
        dataGeneratorService.generateCustomers(20);
        dataGeneratorService.seed(50, 30); // 50 products, 30 orders
    }
}
