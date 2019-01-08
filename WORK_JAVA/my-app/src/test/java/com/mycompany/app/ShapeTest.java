package com.mycompany.app;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ShapeTest {
//    @Mock
    Shape shape;

    @Mock
    CalculatorService calculatorService = new CalculatorService();

    @Before
    public void setup() {
         shape = new Shape();
    }

    @Test
    public void myShapeTest() {
        Shape spy = spy(shape);
        when(spy.getLength(anyInt())).thenReturn(3);


        when(shape.getNameService()).thenReturn("name service");

        assertEquals(shape.getNameService(), "name service");

        when(calculatorService.getCalculatorService()).thenReturn("cal");
        System.out.println(shape.getShapeAndCal("base"));


    }


}
