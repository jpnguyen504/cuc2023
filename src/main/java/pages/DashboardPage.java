package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class DashboardPage {
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// WebElement List
    @FindBy(how = How.XPATH, using = "//h2[text() = ' Dashboard ']")
    WebElement DASHBOARD_HEADER_ELEMENT;
    @FindBy(how = How.XPATH, using = "//span[contains(text(), 'Customers')]")
    WebElement CUSTOMER_MENU_ELEMENT;
    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Add Customer')]")
    WebElement ADD_CUSTOMER_MENU_ELEMENT;
	
//	Corresponding methods
    public void validateDashboardPage(String expectedText) {
    	Assert.assertEquals(DASHBOARD_HEADER_ELEMENT.getText(), expectedText);
    }
    
    
    
}
