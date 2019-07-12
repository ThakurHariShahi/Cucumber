package co.qa.objects;

import org.openqa.selenium.WebDriver;

import co.qa.classes.BasicCookiePage;
import co.qa.classes.BasicDragPage;
import co.qa.classes.BasicFrameDungeonPage;
import co.qa.classes.BasicGridGatePage;
import co.qa.classes.BasicWindowsPage;
import co.qa.classes.BasicWindowsPopupPage;
import co.qa.classes.TatocPage;

public class PageObjects {
	public TatocPage TatocPage_object;
	public BasicGridGatePage BasicGridGatePage_object;
	public BasicFrameDungeonPage BasicFrameDungeonPage_object;
	public BasicDragPage BasicDragPage_object;
	public BasicWindowsPage BasicWindowsPage_object;
	public BasicWindowsPopupPage BasicWindowsPopupPage_object;
	public BasicCookiePage BasicCookiePage_object;
	
	public PageObjects(WebDriver driver)
	{
		TatocPage_object  = new TatocPage(driver);
		BasicGridGatePage_object = new BasicGridGatePage(driver);
		BasicFrameDungeonPage_object = new BasicFrameDungeonPage(driver);
		BasicDragPage_object = new BasicDragPage(driver);
		BasicWindowsPage_object = new BasicWindowsPage(driver);
		BasicWindowsPopupPage_object = new BasicWindowsPopupPage(driver);
		BasicCookiePage_object = new BasicCookiePage(driver);
	}
}
