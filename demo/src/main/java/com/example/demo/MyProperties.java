package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "my", ignoreInvalidFields = true, ignoreUnknownFields = true)
@Scope(value = "prototype")
public class MyProperties {
    private String resourceUrl;

    public MyProperties() {
        System.out.println("MyProperties created ...");
    }

    @Override
    public String toString() {
        return "MyProperties{" +
                "resourceUrl='" + resourceUrl + '\'' +
                ", resourcePort=" + resourcePort +
                '}';
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public List<Integer> getResourcePort() {
        return resourcePort;
    }

    public void setResourcePort(List<Integer> resourcePort) {
        this.resourcePort = resourcePort;
    }

    private List<Integer> resourcePort;
}
