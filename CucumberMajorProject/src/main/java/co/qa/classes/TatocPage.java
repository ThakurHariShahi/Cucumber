package co.qa.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TatocPage {
	
	WebDriver driver;
	
	@FindBy(linkText="Basic Course")
	WebElement basic_Course;

	@FindBy(linkText="Advanced Course")
	WebElement advanced_Course;
	
	public TatocPage(WebDriver driver){
		 this.driver = driver;
		
		 //This initElements method will create all WebElements

	     PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnBasicCourse() {
		basic_Course.click();
	}
	public void clickOnAdvancedCourse() {
		advanced_Course.click();
	}
}