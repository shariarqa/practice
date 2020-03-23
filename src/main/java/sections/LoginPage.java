package sections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ConfigReader;


public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//a[contains(text(),'Login into the Curation Platform')]")
    WebElement signin;

    @FindBy(xpath = "//input[@id='okta-signin-username']")
    WebElement username;

    @FindBy(xpath = "//input[@id='okta-signin-password']")
    WebElement password;

    @FindBy(xpath = "//input[@id='okta-signin-submit']")
    WebElement submit;

    @FindBy(xpath = "//div[@class='app-title']")
    WebElement cpVersion;

    @FindBy(xpath = "//body//mat-card[1]")
    WebElement defaultProject;

    @FindBy(xpath = "//img[@class='auth-org-logo']")
    WebElement partnerLogo;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
         // driver.manage().window().maximize();
    }

    //---- This Will Log In To CP ---//

    public boolean loginApp() {
        try {

            Thread.sleep(5000);
            if (partnerLogo.isDisplayed()) {
                // System.out.println("I'm on step 3");
                //  jh.highLightElement(signin);
                //  signin.click();
                // log.info("Clicking SignIn");
                System.out.println("Step 2");
                ConfigReader cr = new ConfigReader();
                String[] credentials = cr.cpCredentials();
                String uname = credentials[0];
                String pword = credentials[1];

                username.sendKeys(uname);
                password.sendKeys(pword);

                submit.click();
                Thread.sleep(10000);
                defaultProject.click();
                Thread.sleep(10000);
            } else {
                System.out.println("Step 1");

                System.out.println("No Project Found");
            }
            System.out.println("Step 3");
            return true;

        } catch (Exception e) {
            System.out.println("Step 4");
            System.out.println(e);
            //log.warn(e);
            return false;
        }

    }

//    public void testLogingApp() throws InterruptedException {
//
//        this.driver.get("https://qa-pod-as2.dfci.harvard.edu");
//        Thread.sleep(5000);
//        loginApp();
//        Thread.sleep(5000);
//        Projects pj = new Projects(driver);
//        pj.selectDefaultProject();
//        Thread.sleep(5000);
//        WorkFlow wf = new WorkFlow(driver);
//        wf.newPatient_continueCuration_Btn();
//
//
//    }
}
