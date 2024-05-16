package SuiteCases;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener_Demo.ListenerTest.class)

public class TestCases {
    @Test(testName = "TestCase1")
    public void aTest1(){
        System.out.println("aTest1");
    }

    @Test(testName = "TestCase2")
    public void aTest2(){
        System.out.println("aTest2");
    }

    @Test(testName = "TestCase3")
    public void bTest2(){
        System.out.println("bTest2");
        Assert.assertEquals(true, false);
    }

    @Test(testName = "TestCase4")
    public void bTest3(){
        System.out.println("bTest3");
    }
}
