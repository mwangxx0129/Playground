package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
        System.out.println(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        System.out.println(AppTest.class);
        System.out.println(AppTest.class);
        TestSuite t = new TestSuite( AppTest.class );
        System.out.println(t);
        return t;
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
