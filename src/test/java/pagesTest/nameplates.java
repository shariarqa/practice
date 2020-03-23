package pagesTest;

import base.BaseTest;

import org.testng.annotations.Test;
import pages.HomePage;

public class nameplates extends BaseTest {

    @Test
    public void loginBankTest() throws Exception {

        HomePage hp = new HomePage(driver);
        String bname = hp.logingToBank();
        System.out.println(bname);

    }

}
