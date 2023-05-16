package in.ineuron.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
class ConfigClientController {

    @Value("${datasource.url}")
    private String databaseUrl;

    @Value("${database.username}")
    private String databaseUsername;

    @GetMapping("/datasource.url")
    public String getDatabaseUrl() {
        return databaseUrl;
    }

    @GetMapping("/datasource.username")
    public String getDatabaseUsername() {
        return databaseUsername;
    }
}