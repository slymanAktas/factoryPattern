package tests;

import driverfactory.DriverManager;
import driverfactory.DriverManagerFactory;
import driverfactory.DriverType;
import org.junit.*;
import org.openqa.selenium.WebDriver;

public class FactoryTest {
    DriverManager driverManager;
    WebDriver driver;

    @BeforeClass
    public void beforeTest() {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
    }

    @Before
    public void beforeMethod() {
        driver = driverManager.getDriver();
    }

    @AfterClass
    public void afterMethod() {
        driverManager.quitDriver();
    }

    @Test
    public void launchTestAutomationGuruTest() {
        driver.get("http://testautomationguru.com");
        Assert.assertEquals("TestAutomationGuru – A technical blog on test automation", driver.getTitle());
    }
}
