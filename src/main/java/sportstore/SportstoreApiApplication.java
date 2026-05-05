package sportstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "sportstore")
public class SportstoreApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportstoreApiApplication.class, args);
    }
}