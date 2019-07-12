package co.qa.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasicFrameDungeonPage
{
    WebDriver driver;
    String box1_class,box2_class;
    //@FindBy(linkText="Box 1")
    @FindBy(id="answer")
    WebElement box1;
    
    //@FindBy(linkText="Box 2")
    @FindBy(id="answer")
    WebElement box2;
    
    @FindBy(xpath = "//a[text() = \"Repaint Box 2\"]")
    WebElement repaint_box_2;
    
    @FindBy(xpath = "//a[text()=\"Proceed\"]")
    WebElement proceed;
    public BasicFrameDungeonPage(WebDriver driver)
    {
       	this.driver = driver;
       	PageFactory.initElements(driver,this);
    }
    
    public void clickOnRepaintBox2()
    {
    	driver.switchTo().frame("main");
    	box1_class = box1.getAttribute("class");
    	do
    	{
    		repaint_box_2.click();
    		driver.switchTo().frame("child");
    		box2_class = box2.getAttribute("class");
    		driver.switchTo().parentFrame();
    	}while(!box1_class.equalsIgnoreCase(box2_class));
    	
    	proceed.click();
    }
    
    
}
