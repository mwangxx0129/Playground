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

    public void test1() {
        App app = new App();
        String[] input = {"1","2","3","4","5", "6"};
        List<String> list = new ArrayList<String>(Arrays.asList(input));
        int count = 0;
//        list.remove(1);
        list.remove(count);

        System.out.println(Arrays.toString(list.toArray()));
    }

    public static void main( String[] args )  {
        System.out.println( "Hello World!" );
        App app = new App();

        int res = app.controller();
        System.out.println(res);
    }



    public int controller() {
//        if(true) {
//            return 7;
//        }

        int res = 0;
        try {
//            logic();
            throw new MyException("from logic try");
        }  catch (MyException e) {
            System.out.println("---------------");
            System.out.println(e.toString());
            res = 1;
         }catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("catch");
            res = 2;
        }
        finally {
            System.out.println("finally");
            res = 3;
        }
        return res;
    }

    public void logic() throws Exception {
        boolean found = true;
        if (found) {
            throw new Exception("logic exception");
        }
        System.out.println("hello");
    }

    public void logic1() throws Exception {
//        throw new Exception("logic exception");
    }
}
