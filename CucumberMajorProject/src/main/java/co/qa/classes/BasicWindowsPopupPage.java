package co.qa.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasicWindowsPopupPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[contains(@id,\"name\")]")
	WebElement name_field;
	
	@FindBy(xpath = "//input[@id=\"name\"]//following::input")
	WebElement submit;
	
	public BasicWindowsPopupPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void clickOnSubmitButton(String s)
	{
		name_field.sendKeys(s);
		submit.click();
	}
	
}
