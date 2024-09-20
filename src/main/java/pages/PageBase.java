package pages;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	protected static WebDriver driver;
	public JavascriptExecutor js;
	public WebDriverWait wait;
	public Select select;
    protected Actions actions;


	public PageBase(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.actions = new Actions(driver);
		PageFactory.initElements(driver, this);
	}

	protected static void clickButton(WebElement button) {
		button.click();
	}

	protected static void setTextElementText(WebElement textElement, String value) {
		textElement.sendKeys(value);
	}
	
	protected void selectFromDropdownByIndex(WebElement dropdown, int index) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(dropdown));
            Select select = new Select(dropdown);
            select.selectByIndex(index);
        } catch (NoSuchElementException e) {
            System.out.println("Dropdown option not found: " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds for dropdown: " + e.getMessage());
        }
    
    }
	 
	 // Wait for element to be visible
	    protected WebElement waitForVisibility(WebElement element) {
	        return wait.until(ExpectedConditions.visibilityOf(element));
	    }

	    // Wait for element to be clickable
	    protected WebElement waitForClickability(WebElement element) {
	        return wait.until(ExpectedConditions.elementToBeClickable(element));
	    }
	    
	    protected void sendKeySequence(WebElement element, Keys... keys) {
	        waitForVisibility(element);
	        actions.moveToElement(element).click(); // Move and click on the element
	        actions.sendKeys(keys).perform(); // Send the sequence of keys
	    }
	    public void scrollTo() {
			js.executeScript("scrollBy(0,3000)");
		}

}
