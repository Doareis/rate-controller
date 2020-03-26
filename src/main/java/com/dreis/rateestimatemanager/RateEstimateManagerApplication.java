package com.dreis.rateestimatemanager;

import com.dreis.rateestimatemanager.dto.RateDTO;
import com.dreis.rateestimatemanager.entity.Rate;
import com.dreis.rateestimatemanager.service.RateService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.faces.config.ConfigureListener;
import java.io.InputStream;
import java.util.List;
import javax.faces.webapp.FacesServlet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration
public class RateEstimateManagerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(RateEstimateManagerApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean facesServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean<>(new FacesServlet(), "*.xhtml");
        registration.setLoadOnStartup(1);
        return registration;
    }

    @Bean
    public ServletContextInitializer servletContextInitializer() {
        return servletContext -> {
            servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
            servletContext.setInitParameter("primefaces.THEME", "nova-light");
        };
    }

    @Bean
    public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
        return new ServletListenerRegistrationBean<>(new ConfigureListener());
    }

    @Bean
    public CommandLineRunner runner(RateService rateService) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<RateDTO>> typeReference = new TypeReference<List<RateDTO>>() {
            };

            InputStream inputStream = TypeReference.class.getResourceAsStream("/ESTIMATIVA_SELIC.JSON");
            List<RateDTO> rates = mapper.readValue(inputStream, typeReference);
            rateService.saveAll(rates);

        };
    }
}
