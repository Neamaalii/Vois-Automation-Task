package com.swaglabs.Utils;
import org.testng.asserts.SoftAssert;

public class SoftAssertion extends SoftAssert
{
    public static SoftAssertion soft=new SoftAssertion();

    public static void assert_All()
    {
        try {
            soft.assertAll();
        }
        catch (AssertionError error)
        {
            System.out.println("soft assert failed");
            throw error;
        }

    }

}
