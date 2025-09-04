package com.vois.Utils;
import org.testng.Assert;

public class Validation {
    private Validation()
    {
    }
    public static void validateEqual(int actual , int expected , String txt)
    {
        Assert.assertEquals( actual,expected,txt);
    }

}
