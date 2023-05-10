package com.academy.techcenture.junit_example;

import org.junit.*;

public class DummyTest extends BaseTest {

    @Test
    public void test1(){
        System.out.println("Starting test 1");
        Assert.assertEquals("Numbers are not equal", 25, 25);
        System.out.println("End of test 1");
    }

    @Test
    public void test2(){
        System.out.println("Starting test 2");
        Assert.assertTrue("Something went wrong", 6>3);
        System.out.println("End of test 2");
    }

    @Test
    public void test3(){
        System.out.println("Starting test 3");
        Assert.assertArrayEquals("arrays were not equal", new int[]{1,2,3}, new int[]{2,3,4});
        System.out.println("End of test 3");
    }
}
