package co.qa.StepDefinition;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	WebDriver d;
	WebElement we, we2;
	String BaseUrl, s1, s2,mw,cw,token;
	Cookie name;
	
	
	@Given("^Open the chrome and launch the browser$")
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		d = new ChromeDriver();
		BaseUrl = "http://10.0.1.86/tatoc";
		d.get(BaseUrl);
	}

	@When("^Click on Basic Course Link$")
	public void click_on_Basic_Course_Link() throws InterruptedException {
		we = d.findElement(By.cssSelector("a[href=\"/tatoc/basic\"]"));
		we.click();
	}

	@Then("^Open Basic Grid Gate page$")
	public void open_Basic_Grid_Gate_page() {
		s1 = "Grid Gate - Basic Course - T.A.T.O.C";
		s2 = d.getTitle();
		System.out.println("Tittle is " + s2);
		Assert.assertEquals(s1,s2,"Wrong Page Dummy");

	}

	@When("^I click on greenbox$")
	public void i_click_on_greenbox() throws Throwable {
//		we = d.findElement(By.cssSelector("tbody div.greenbox"));
		we = d.findElement(By.cssSelector("div.greenbox[onclick=\"passthru();\"]"));

		we.click();
	}

	@Then("^I am on Frame Dungeon page$")
	public void i_am_on_frame_dungeon_page() throws Throwable {
		s1 = "Frame Dungeon - Basic Course - T.A.T.O.C";
		s2 = d.getTitle();
		System.out.println("Tittle is " + s2);
		Assert.assertEquals(s1, s2,"Galat Hai Page");
	}

	@When("^I click on Repaint Box 2 and Proceed button$")
	public void i_click_on_repaint_box_2_and_proceed_button() throws Throwable {
		d.switchTo().frame("main");
		we = d.findElement(By.cssSelector("div#answer"));
		s1 = we.getAttribute("class");

		do {
			we = d.findElement(By.cssSelector("a[onclick=\"reloadChildFrame();\"]"));
			we.click();
			d.switchTo().frame("child");
			we2 = d.findElement(By.cssSelector("div#answer"));
			s2 = we2.getAttribute("class");
			d.switchTo().parentFrame();
		} while (!(s1.equals(s2)));
		we = d.findElement(By.cssSelector("a[onclick=\"gonext();\"]"));
		we.click();
	}

	@Then("^I am on Drag Around Page$")
	public void i_am_on_drag_around_page() throws Throwable {
		s1 = "Drag - Basic Course - T.A.T.O.C";
		s2 = d.getTitle();
		System.out.println("Tittle is " + s2);
		Assert.assertEquals(s1, s2,"Galat Hai Page");
	}

	@When("^I drag the dagrme to dragbox$")
	public void i_drag_the_dagrme_to_dragbox() throws Throwable {
		we = d.findElement(By.cssSelector("div.ui-draggable"));
		we2 = d.findElement(By.cssSelector("div#dropbox"));
		Actions builder = new Actions(d);
		builder.dragAndDrop(we, we2).build().perform();
		Thread.sleep(2000);
		d.findElement(By.linkText("Proceed")).click();

	}

	@Then("^I am on PopupWindows$")
	public void i_am_on_popupwindows() throws Throwable {
		s1 = "Windows - Basic Course - T.A.T.O.C";
		s2 = d.getTitle();
		System.out.println("Tittle is " + s2);
		Assert.assertEquals(s1, s2,"Galat Hai Page");
	}

	@When("^I click on Launch Popup Window$")
	public void i_click_on_launch_popup_window() throws Throwable {
		d.findElement(By.linkText("Launch Popup Window")).click();
		mw = d.getWindowHandle();

		System.out.println("MainWindow :- " + mw);
		Set<String> s1 = d.getWindowHandles();
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			cw = i1.next();
			if (!mw.equalsIgnoreCase(cw)) {
				d.switchTo().window(cw);

			}
		}
	}

	@Then("^I am on Popup Window$")
	public void i_am_on_popup_window() throws Throwable {
		s1 = "Popup - Basic Course - T.A.T.O.C";
		s2 = d.getTitle();
		System.out.println("Tittle is " + s2);
		Assert.assertEquals(s1, s2,"Galat Hai Page");
	}

	@And("^I submit My name$")
	public void i_submit_my_name() throws Throwable {
		d.findElement(By.id("name")).sendKeys("rohit");
	}

	@And("^I click on submit button$")
	public void i_click_on_submit_button() throws Throwable {
		d.findElement(By.id("submit")).click();
		d.switchTo().window(mw);
	}

	@Then("^I am back to Launch Popup Window$")
	public void i_am_back_to_launch_popup_window() throws Throwable {
		s1 = "Windows - Basic Course - T.A.T.O.C";
		s2 = d.getTitle();
		System.out.println("Tittle is " + s2);
		Assert.assertEquals(s1, s2,"Galat Hai Page");
	}

	@And("^I click on Proceed Button$")
	public void i_click_on_proceed_button() throws Throwable {
		d.findElement(By.linkText("Proceed")).click();
	}

	@Then("^I am on Cookie Handling Page$")
	public void i_am_on_cookie_handling_page() throws Throwable {
		s1 = "Cookie Handling - Basic Course - T.A.T.O.C";
		s2 = d.getTitle();
		System.out.println("Tittle is " + s2);
		Assert.assertEquals(s1, s2,"Galat Hai Page");
	}

	@When("^I click on Generate Token$")
	public void i_click_on_generate_token() throws Throwable {
		d.findElement(By.linkText("Generate Token")).click();
		token = d.findElement(By.xpath("//*[@id=\"token\"]")).getText();
		token = token.substring(7);
		System.out.println("Token is :-" + token);
		name = new Cookie("Token", token);
		d.manage().addCookie(name);
	}

	@Then("^I am on End Tatos Page$")
	public void i_am_on_end_tatos_page() throws Throwable {
		s1 = "End - T.A.T.O.C";
		s2 = d.getTitle();
		System.out.println("Tittle is " + s2);
		Assert.assertEquals(s1, s2,"Galat Hai Page");
	}
}
