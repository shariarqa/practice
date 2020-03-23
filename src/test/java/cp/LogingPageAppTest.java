package cp;

import base.BaseTest;
import org.testng.annotations.Test;
import sections.LoginPage;

public class LogingPageAppTest extends BaseTest {

    //this test is canceld
    @Test
    public void login() throws Exception{
        LoginPage lp = new LoginPage(driver);
        boolean reply = lp.loginApp();
        System.out.println(reply);
    }

}
