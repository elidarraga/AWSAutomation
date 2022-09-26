package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import share.Utils;

public class ProductAmazonPage {
  private WebDriver driver;
  public Utils utils =new Utils();
  @FindBy(how = How.XPATH,using = "//*[contains(text(),' About this item ')]")
  WebElement txtAboutItem;


  public ProductAmazonPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public boolean isDisplayedTxtAboutItem(){
    utils.waitForElementVisible(txtAboutItem,driver);
    System.out.println("This value: " + txtAboutItem.getText());
    return txtAboutItem.isDisplayed();
  }
}
