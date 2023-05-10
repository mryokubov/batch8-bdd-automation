package com.academy.techcenture.junit_example;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class BaseTest {

    @BeforeClass
    public static void beforeClassConfiguration(){
        System.out.println("Doing some configuration in before class method");
    }

    @AfterClass
    public static void afterClassConfiguration(){
        System.out.println("Doing some configuratoin in after class method");
    }

    @Before
    public void setUp(){
        System.out.println("before method running..");
    }

    @After
    public void tearDown(){
        System.out.println("after method running...");
    }
}
