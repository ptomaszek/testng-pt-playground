package com.example; // 1. to make the test PASS change to `org.example`

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class MyTest extends MyBaseTest {

    @BeforeClass
    public void beforeClass() {
        assertNotNull(dependency); // fails here
    }

    @Test
    public void test() {
    }
}

abstract class MyBaseTest implements MyInterface { // 2. alternatively, to make the test PASS remove `implements MyInterface`
    protected Object dependency;

    public void setDependency(Object dependency) {
    }

    @BeforeClass
    public void setupDependency() {
        dependency = new Object();
    }

    @BeforeClass(dependsOnMethods = "setupDependency")
    public void setupAdditionalDependency_() {  // 3. alternatively, to make the test PASS remove `_` from the method name
    }
}

interface MyInterface {

    void setDependency(Object dependency);

    default Object getDependency() {
        return null;
    }
}
