package testNG;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

//    @DataProvider(name = "NameTest")
//    public Object[][] getData() {
//
//        //logic if needed for any return we desire
//
//        return new Object[][]{
//                {"David", "Hunt", "David Hunt"},
//                {"Priyanka", "Garla", "Priyanka Garla"},
//                {"Sameer", "Jain", "Sameer Jain"},
//                {"Kushal", "Puri", "Kushal Puri"},
//                {"Ajeesh", "Damo", "Ajeesh Damo"}
//
//
//        };
//  }


    //new Object [][]= new Object [2][3]; --->Garla -[1][1]
    @Test(dataProvider = "NameTest", dataProviderClass = Data.class)
    public void test(String name, String lastName, String expected) {
        String fname = name;
        String lname = lastName;
        String fullName = fname + " " + lname;

        Assert.assertEquals(fullName, expected);

    }

}
