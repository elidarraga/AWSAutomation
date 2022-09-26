package share;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

  public  static  final  long WAIT_TIME=60;
  public Utils() {
  }

  public void scrollDownToElement(WebElement element, WebDriver driver ){
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
  }
  public void waitForElementClickable(WebElement element, WebDriver driver){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000*WAIT_TIME));
    wait.until(ExpectedConditions.visibilityOf(element));
    wait.until(ExpectedConditions.elementToBeClickable(element));
  }
  public void waitForElementVisible(WebElement element, WebDriver driver){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000*WAIT_TIME));
    wait.until(ExpectedConditions.visibilityOf(element));
  }

  public void sleep(int i){
    try {
       Thread.sleep(1000*i);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
