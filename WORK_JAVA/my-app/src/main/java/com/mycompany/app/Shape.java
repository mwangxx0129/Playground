package com.mycompany.app;

import java.util.List;

public class Shape {
    private String name;
    private String version;
    private List<Integer> list;

    private CalculatorService calculatorService;

    public Shape() {
        calculatorService = new CalculatorService();
    }

    public String getNameService(){
        return "name service";
    }

    public String getShapeAndCal(String base) {
        return base + "\t" + calculatorService.getCalculatorService() + getNameService() + "\t" + getLength(4);
    }

    public int getLength(int len) {
        return len;
    }
}
