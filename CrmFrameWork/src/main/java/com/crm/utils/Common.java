package com.crm.utils;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;

import com.crm.config.BaseConfiguration;





public class Common extends BaseConfiguration {
	
//	public static void validatePage(String title, WebDriver wd) {
//		Assert.assertEquals(title, wd.getTitle());
//	}
	
	//method for click the link
	public static void clickLink(String identifiedBy, String locator, WebDriver wd) {
		if(identifiedBy.equalsIgnoreCase("id")) {
			wd.findElement(By.id(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("name")) {
			wd.findElement(By.name(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("xpath")) {
			wd.findElement(By.xpath(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("css")) {
			wd.findElement(By.cssSelector(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("link")) {
			wd.findElement(By.linkText(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("plink") ) {
			wd.findElement(By.partialLinkText(locator)).click();
		}
		
	}
	//method for click Button
	public static void clickButton(String identifiedBy, String locator, WebDriver wd) {
		if(identifiedBy.equalsIgnoreCase("id")) {
			wd.findElement(By.id(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("name")) {
			wd.findElement(By.name(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("xpath")) {
			wd.findElement(By.xpath(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("css")) {
			wd.findElement(By.cssSelector(locator)).click();
		}
	}
	//method for click RadioButton
	public static void clickRadiButton(String identifiedBy, String locator, WebDriver wd) {
		if(identifiedBy.equalsIgnoreCase("id")) {
			wd.findElement(By.id(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("name")) {
			wd.findElement(By.name(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("xpath")) {
			wd.findElement(By.xpath(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("css")) {
			wd.findElement(By.cssSelector(locator)).click();
		}
		
	}
	
	//method for click CheckBox
	public static void clickCheckBox(String identifiedBy, String locator, WebDriver wd) {
		if(identifiedBy.equalsIgnoreCase("id")) {
			wd.findElement(By.id(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("name")) {
			wd.findElement(By.name(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("xpath")) {
			wd.findElement(By.xpath(locator)).click();
		}
		else if(identifiedBy.equalsIgnoreCase("css")) {
			wd.findElement(By.cssSelector(locator)).click();
		}
		
	}
	
	//Insert the text using SendKeys method
	public static void insertText(String identifiedBy, String locator, String text,  WebDriver wd) {
	
		if(identifiedBy.equalsIgnoreCase("id")) {
			wd.findElement(By.id(locator)).sendKeys(text);
		}
		else if(identifiedBy.equalsIgnoreCase("name")) {
			wd.findElement(By.name(locator)).sendKeys(text);
		}
		else if(identifiedBy.equalsIgnoreCase("xpath")) {
			wd.findElement(By.xpath(locator)).sendKeys(text);
		}
		else if(identifiedBy.equalsIgnoreCase("css")) {
			wd.findElement(By.cssSelector(locator)).sendKeys(text);
		}
		
		
	}
	
	//handle PopUp
	public static void accetAlert(WebDriver wd) {
		Alert alert = wd.switchTo().alert();
		alert.accept();
		
	}
	
	//select DropDownButton
	public static void SelectDropDownItem(String identifiedBy, String locator, String itemType, String value, WebDriver wd) {
		WebElement element = null;
		if(identifiedBy.equalsIgnoreCase("id")) {
		    element = wd.findElement(By.id(locator));
		}
		else if(identifiedBy.equalsIgnoreCase("name")) {
			element = wd.findElement(By.name(locator));
		}
		else if(identifiedBy.equalsIgnoreCase("xpath")) {
			element = wd.findElement(By.xpath(locator));
		}
		else if(identifiedBy.equalsIgnoreCase("css")) {
			element = wd.findElement(By.cssSelector(locator));
		}
		
	
		Select selectobj = new Select(element);
		if(itemType.equalsIgnoreCase("value")) {
		selectobj.selectByValue(value);
		}
		else if(itemType.equalsIgnoreCase("index")) {
		selectobj.selectByIndex(Integer.parseInt(value));

		}
		else if(itemType.equalsIgnoreCase("Text")) {
		selectobj.selectByVisibleText(value);
		
		}
	
	}
	//refresh the page
	public static void pageRefresh(WebDriver wd) {
		wd.navigate().refresh();
	}
	//back to the previous page
	public static void pageNavigateBack(WebDriver wd) {
		wd.navigate().back();
	}
	//forward to the page
	public static void pageNavigateForward(WebDriver wd) {
		wd.navigate().forward();
	}
	
	//get the text
	public static String getText(String identifiedBy, String locator, WebDriver wd) {
		String txt = null;
	
		if(identifiedBy.equalsIgnoreCase("id")) {
			txt = wd.findElement(By.id(locator)).getText();
		}
		else if(identifiedBy.equalsIgnoreCase("name")) {
			txt = wd.findElement(By.name(locator)).getText();
		}
		else if(identifiedBy.equalsIgnoreCase("xpath")) {
			txt = wd.findElement(By.xpath(locator)).getText();
		}
		else if(identifiedBy.equalsIgnoreCase("css")) {
			txt = wd.findElement(By.cssSelector(locator)).getText();
		}
		else if(identifiedBy.equalsIgnoreCase("link")) {
			txt = wd.findElement(By.linkText(locator)).getText();
		}
		return txt;
	
		
	}
	
	// Method for get the value from text Box
	public static String getValue(String identifiedBy, String locator, WebDriver wd) {
		String v= null; 
		
		if(identifiedBy.equalsIgnoreCase("id")) {
			v =wd.findElement(By.id(locator)).getAttribute("Value");
		}
		else if(identifiedBy.equalsIgnoreCase("name")) {
			v =wd.findElement(By.name(locator)).getAttribute("Value");
		}
		else if(identifiedBy.equalsIgnoreCase("xpath")) {
			v =wd.findElement(By.xpath(locator)).getAttribute("Value");
		}
		else if(identifiedBy.equalsIgnoreCase("css")) {
			v =wd.findElement(By.cssSelector(locator)).getAttribute("Value");
		}
		
		return v;
	}
	
	//method for displaying or not 
	public static Boolean  pageDisplay(String identifiedBy, String locator, WebDriver wd) {
		Boolean result = null;
		if(identifiedBy.equalsIgnoreCase("id")) {
			result = wd.findElement(By.id(locator)).isDisplayed();
		}
		else if(identifiedBy.equalsIgnoreCase("name")) {
			result = wd.findElement(By.name(locator)).isDisplayed();
		}
		else if(identifiedBy.equalsIgnoreCase("xpath")) {
			result = wd.findElement(By.xpath(locator)).isDisplayed();
		}
		else if(identifiedBy.equalsIgnoreCase("css")) {
			result = wd.findElement(By.cssSelector(locator)).isDisplayed();
		}
		return result;
		
	}
	
	public static void wait(int timeout) throws InterruptedException {
		int timeoutVal = timeout * 1;
		for(int second = 0; second <timeoutVal; second++) {
			Thread.sleep(2000);
		}
		
	}
		public static void takeScreenShot(WebDriver wd) {
			try {
				int count = 0;
				String NewFileNamePath;
			//	File directory = new File(",");
				DateFormat dateformat = new SimpleDateFormat("dd_MMM_yyyy_hh_mm_ssss");
				Date date = new Date();
				
				NewFileNamePath = "C:\\Users\\nini\\Desktop\\ScreenShot\\" + dateformat.format(date)+"-" + ".png";
				BufferedImage screenCapture = new Robot().createScreenCapture(new Rectangle(968,1009));
				
				File file = new File(NewFileNamePath);
				ImageIO.write(screenCapture, "png", file);
				count++;
				
				
				File screenshot = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot, new File(NewFileNamePath));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void editText(String identifiedBy, String locator,String text,WebDriver wd) {
			WebElement un = null;
			
			if(identifiedBy.equalsIgnoreCase("id")) {
				un = wd.findElement(By.id(locator));
				un.clear();
				un.sendKeys(text);
			}
			else if(identifiedBy.equalsIgnoreCase("name")) {
				un = wd.findElement(By.name(locator));
				un.clear();
				un.sendKeys(text);
			}
			else if(identifiedBy.equalsIgnoreCase("xpath")) {
				un = wd.findElement(By.xpath(locator));
				un.clear();
				un.sendKeys(text);
			}
			else if(identifiedBy.equalsIgnoreCase("css")) {
				un = wd.findElement(By.cssSelector(locator));
				un.clear();
				un.sendKeys(text);
			}
		}
			
		
	}

	
	
		


