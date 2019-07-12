package co.qa.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasicDragPage {
  
   WebDriver driver;
   
   @FindBy(xpath = "//div[text()=\"DRAG ME\"]")
   WebElement drag_me;
   
   @FindBy(xpath="//div[contains(@id,\"dropbox\")]")
   WebElement drop_box;
   
   @FindBy(xpath = "//a[@onclick=\"gonext();\"]")
   WebElement proceed;
   
   Actions actions_object;
   public BasicDragPage(WebDriver driver)
   {
	   this.driver=driver;
	   PageFactory.initElements(driver,this);
   }
   
   public void performDragAndDrop()
   {
	   actions_object = new Actions(driver);
	   actions_object.dragAndDrop(drag_me,drop_box).build().perform();
	   proceed.click();
   }
}