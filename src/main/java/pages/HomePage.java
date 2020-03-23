package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ConfigReader;


public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(name= "uid")
    WebElement uid;

    @FindBy(name = "password")
    WebElement pass;

    @FindBy(name = "btnLogin")
    WebElement login;

    @FindBy(className = "barone")
    WebElement barone;

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver,this);


    }

    public String logingToBank()throws Exception{
        this.driver.get("https://demo.guru99.com/V4/");
        ConfigReader cr = new ConfigReader();
        String[] credential = cr.getCredential();
        String username = credential[0];
        String password = credential[1];

        Thread.sleep(5000);
        uid.sendKeys(username);
        Thread.sleep(2000);
        pass.sendKeys(password);
        Thread.sleep(5000);
        login.click();
        Thread.sleep(5000);
        String bankname = barone.getText();
        return bankname;
    }

}
