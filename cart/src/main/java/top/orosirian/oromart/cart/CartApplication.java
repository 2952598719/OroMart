package top.orosirian.oromart.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CartApplication {
    static void main(String[] args) {
        SpringApplication.run(CartApplication.class, args);
    }
}
