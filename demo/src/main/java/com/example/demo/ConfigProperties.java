package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Configuration
@PropertySource("classpath:application_dev.properties")
public class ConfigProperties {

    @Override
    public String toString() {
        return "ConfigProperties{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Value("${dev.name}")
    private String name;

    @Value("${dev.age}")
    private String age;

    @Value("${dev.price}")
    private String price;

}
