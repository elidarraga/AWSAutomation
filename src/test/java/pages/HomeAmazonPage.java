package pages;

import static java.lang.Thread.sleep;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import share.Utils;

public class HomeAmazonPage {
  private WebDriver driver;
  public Utils utils =new Utils();
  @FindBy(how = How.XPATH,using = "//i[@class='hm-icon nav-sprite']")
  WebElement navMenuCategories;

  @FindBy(how = How.XPATH,using = "//*[contains(text(),'TV, Appliances, Electronics')]")
  WebElement navOptionTV;

  @FindBy(how = How.XPATH,using = "//*[contains(text(),'shop by category')]")
  WebElement txtCategory;

  @FindBy(how = How.XPATH,using = "//a[contains(text(),'Televisions')]")
  WebElement OptionTV;


  public HomeAmazonPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void clickNavMenuCategories(){
    navMenuCategories.click();
  }

  public void scrollDownToTxtCategory(){
    utils.scrollDownToElement(txtCategory,driver);
    utils.waitForElementClickable(navOptionTV,driver);
    navOptionTV.click();
  }
  public void clickOptionTV(){
    OptionTV.click();
    utils.sleep(4);
  }
}
