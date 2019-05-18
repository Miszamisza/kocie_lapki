package pl.kittenpaws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pl.kittenpaws.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)

public class KittenPawsApplication {

    public static void main(String[] args) {
        SpringApplication.run(KittenPawsApplication.class, args);
    }

}
