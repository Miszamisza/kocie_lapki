package pl.kocie_stopki.kocie.config;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import pl.kocie_stopki.kocie.KocieApplication;

public class ServletInicializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(KocieApplication.class);
    }

}