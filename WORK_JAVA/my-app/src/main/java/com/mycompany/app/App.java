package com.mycompany.app;

import com.mycompany.app.Model.Car;
import com.mycompany.app.Model.DataExample;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;


public class App 
{
    public void test() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("sweet", "lrig", null, new DataExample());

        String jsonString = objectMapper.writeValueAsString(car);

        System.out.println(jsonString);

        Car newCar = objectMapper.readValue(jsonString, Car.class);

        System.out.println(newCar.toString());

    }

    public static void main( String[] args ) throws IOException {
        System.out.println( "Hello World!" );
        App app = new App();
        app.test();
    }
}
