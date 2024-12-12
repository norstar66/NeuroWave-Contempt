package com.norstarphoenix.neurowaveconcept.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DotenvConfig {

    private static final Dotenv dotenv = Dotenv.configure()
            .directory("./") // Points to the root directory
            .load();

    public static String getEnv(String key) {
        return dotenv.get(key);
    }
}
