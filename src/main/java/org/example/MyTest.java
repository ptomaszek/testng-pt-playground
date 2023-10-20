package org.example;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyTest {

    @BeforeClass
    public void beforeClass() {
        throw new RuntimeException("Oops!");
    }

    @BeforeMethod
    public void beforeMethod() {
    }

    @Test
    public void test() {
    }
}
