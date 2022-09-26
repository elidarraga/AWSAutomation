package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import share.Utils;

public class TelevisionAmazonPage {
  private WebDriver driver;
  public Utils utils =new Utils();

  @FindBy(how = How.XPATH,using = "(//span[contains(text(),'Brands')])[3]")
  WebElement txtCategoryBrands;
  @FindBy(how = How.XPATH,using = "(//span[contains(text(),'Samsung')])[2]")
  WebElement optionSamsung;
  @FindBy(how = How.XPATH,using = "//span[@id='a-autoid-0']")
  WebElement selectSort;
  @FindBy(how = How.XPATH,using = "//a[contains(text(),'Price: High to Low')]")
  WebElement optionPrice;
  @FindBy(how = How.XPATH,using = "//*[@data-index='2']")
  WebElement cardProduct;


  public TelevisionAmazonPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }
  public void scrollDownToTxtCategoryBrands(){
    utils.scrollDownToElement(txtCategoryBrands,driver);
    utils.waitForElementClickable(optionSamsung,driver);
    optionSamsung.click();
  }

  public void  selectOptionSort(){
    utils.waitForElementClickable(selectSort,driver);
    selectSort.click();
    utils.waitForElementClickable(optionPrice,driver);
    optionPrice.click();
    utils.waitForElementClickable(cardProduct,driver);
    cardProduct.click();
    utils.sleep(20);
  }

}
