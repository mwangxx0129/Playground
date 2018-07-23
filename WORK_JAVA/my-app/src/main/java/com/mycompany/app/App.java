package com.mycompany.app;

import com.mycompany.app.Model.Car;
import com.mycompany.app.Model.DataExample;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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
        String[] input = {"1","2","3","4","5", "6"};
        List<String> list = new ArrayList<String>(Arrays.asList(input));
        int count = 0;
//        list.remove(1);
        list.remove(count);

        System.out.println(Arrays.toString(list.toArray()));
    }
}
