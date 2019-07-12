package co.qa.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasicGridGatePage {
	WebDriver driver;
	
	@FindBy(xpath="//div[@class=\"greenbox\"]")
	WebElement green_box;
    
	public BasicGridGatePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnGreenBox()
	{
		green_box.click();
		
	}
	
}
