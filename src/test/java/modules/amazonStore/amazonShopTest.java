package modules.amazonStore;


import java.util.ArrayList;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import pages.HomeAmazonPage;
import pages.ProductAmazonPage;
import pages.TelevisionAmazonPage;

public class amazonShopTest {

  private String PATHDRIVER = "src/test/resources/driver/";
  private String baseURL = "https://www.amazon.in/";
  WebDriver driver;

  @BeforeTest
  public void start() {
    try{
    System.setProperty("webdriver.chrome.driver", PATHDRIVER + "chromedriver.exe");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");
    options.addArguments("--incognito");
    driver = new ChromeDriver();
    driver.get(baseURL);
    } catch (Exception ex){
      System.out.println("Something went wrong.");
    }
  }

  @Test
  public void signUp() {;
    HomeAmazonPage homeAmazonPage = new HomeAmazonPage(driver);
    homeAmazonPage.clickNavMenuCategories();
    homeAmazonPage.scrollDownToTxtCategory();
    homeAmazonPage.clickOptionTV();

    TelevisionAmazonPage televisionAmazonPage = new TelevisionAmazonPage(driver);
    televisionAmazonPage.scrollDownToTxtCategoryBrands();
    televisionAmazonPage.selectOptionSort();

    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
    driver.switchTo().window(tabs2.get(0));
    driver.close();
    driver.switchTo().window(tabs2.get(1));
    ProductAmazonPage productAmazonPage = new ProductAmazonPage(driver);
    Assert.assertTrue(productAmazonPage.isDisplayedTxtAboutItem());

  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    if (driver != null) {
      driver.quit();
    }
  }
}
