package com.test.testtechnique.configuration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * Configuration de la base de données
 * Utilisation de la propriété d'environnement .env
 * Pour activer un profil spécifique, ajouter le suffixe à la variable d'environnement SPRING_PROFILES_ACTIVE
 */
@Configuration
@PropertySources({
        @PropertySource(value = "file:.env", ignoreResourceNotFound = true),
        @PropertySource(value = "file:.env.${spring.profiles.active}", ignoreResourceNotFound = true)
})
public class DatabaseConfig {
}
