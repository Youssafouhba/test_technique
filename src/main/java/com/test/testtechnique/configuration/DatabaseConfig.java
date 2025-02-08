package com.test.testtechnique.configuration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource(value = "file:.env", ignoreResourceNotFound = true),
        @PropertySource(value = "file:.env.${spring.profiles.active}", ignoreResourceNotFound = true)
})
public class DatabaseConfig {
}
