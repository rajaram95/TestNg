package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	public static WebDriver d;
	//Launch Browser
	public static void launchBrowser(String Browser) {
	switch (Browser) {
	case "Chrome":
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\eclipseworkspace\\MavenP\\Driver\\chromedriver.exe");
	d=new ChromeDriver();
	break;
				
	case "Firefox":
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\USER\\eclipseworkspace\\MavenP\\Driver\\geckodriver.exe");
	d=new FirefoxDriver();
	break;
	default:
	System.err.println("Invalid switch");
			}
	}
	//Launch Url
	public static void launchUrl(String url) {
			d.get(url);
			d.manage().window().maximize();
			d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			}

	//By ID
		public static WebElement byid(String id) {
		    return d.findElement(By.id(id));
		}
	//By Xpath
		public static WebElement xpath(String locator) {
			return d.findElement(By.xpath(locator));
		}
	//SendKeys
		public static void sendKeys(WebElement e,String value) {
		e.sendKeys(value);
		}
	//Sendkeys with Enter
		public static void enter(WebElement e,String value) {
			e.sendKeys(value,Keys.ENTER);
		}
	//SendKeys with CLear
		public static void clear(WebElement e) {
			e.clear();
		}
	//click
		public static void click(WebElement e) {
			e.click();
	}

	
		//Action
		// Move to Elements
		public static void moveToElements(String path) {
		Actions a=new Actions(d);
		WebElement target = d.findElement(By.xpath(path));
		a.moveToElement(target).perform();
			}
		//Drag And Drop
		public static void dragDrop(String drag,String drop) {
		Actions a=new Actions(d);
		WebElement src = d.findElement(By.xpath(drag));
		WebElement des = d.findElement(By.xpath(drop));
		a.dragAndDrop(src, des).perform();
		}
		//Scroll up
		public static void scrollup(String path) {
		JavascriptExecutor js=(JavascriptExecutor)d;
		WebElement up = d.findElement(By.xpath(path));
		js.executeScript("arguments[0].scrollIntoView(false)", up);	
			}
		//Scroll Down
		public static void scrolldown(String path) {
		JavascriptExecutor js=(JavascriptExecutor)d;
		WebElement down = d.findElement(By.xpath(path));
		js.executeScript("arguments[0].scrollIntoView(true)", down);    }
		//Screenshot
		public static void screenshot(WebDriver d,String path) throws IOException {
		TakesScreenshot t=(TakesScreenshot)d;
		File ss = t.getScreenshotAs(OutputType.FILE);
		  File f=new File(path);
		 FileUtils.copyFile(ss, f);
			}
		//getAttribute
		public static void getvalue(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)d;
		js.executeScript("arguments[0].getAttribute('value')", e);
		}
		//get Attribute
		public static String getAttribute(WebElement e) {
		return e.getAttribute("value");
		}
		//Window handling by index
		public static void Window(int index) {
		Set<String> allid = d.getWindowHandles();
		List<String> l=new LinkedList<>();
		l.addAll(allid);
		d.switchTo().window(l.get(index));
		}	

		//Get all option 
		public static void getalloption(String path) {
		WebElement op = d.findElement(By.xpath(path));
		Select s=new Select(op);
		List<WebElement> allop = s.getAllSelectedOptions();
		for (WebElement allvalue : allop) {
		allvalue.getText();
		}
		}
		//Alert Accept
		public static void Alertacc() {
		Alert a=d.switchTo().alert();
		a.accept();
		}
		//Alert Dismiss
		public static void Alertdis() {
		Alert a=d.switchTo().alert();
		a.dismiss();
		}
			
			
	
	
	
	
	
}
