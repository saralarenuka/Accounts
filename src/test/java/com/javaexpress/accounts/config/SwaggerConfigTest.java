package com.javaexpress.accounts.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SwaggerConfigTest {

    @Test
    void testCustomOpenAPIBeanCreation() {
        SwaggerConfig config = new SwaggerConfig();
        OpenAPI openAPI = config.customOpenAPI();

        assertNotNull(openAPI);
        Info info = openAPI.getInfo();
        assertNotNull(info);
        assertEquals("JavaExpress Accounts Microservice API", info.getTitle());
        assertEquals("0.0.1", info.getVersion());
        assertEquals("API documentation for the Accounts Microservice", info.getDescription());
        assertNotNull(info.getContact());
        assertEquals("JavaExpress Support", info.getContact().getName());
        assertEquals("support@javaexpress.com", info.getContact().getEmail());
        assertEquals("https://javaexpress.com", info.getContact().getUrl());
        assertNotNull(info.getLicense());
        assertEquals("Apache 2.0", info.getLicense().getName());
        assertEquals("http://springdoc.org", info.getLicense().getUrl());
    }
}
