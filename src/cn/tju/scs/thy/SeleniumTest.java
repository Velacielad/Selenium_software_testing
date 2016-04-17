package cn.tju.scs.thy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {
	private WebDriver driver;
	private String baseUrl;
      
//	public void setUp(){
//		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
//        WebDriver driver = new FirefoxDriver();  
//        baseUrl = "http://www.ncfxy.com/";
//	}
	
	public String getEmailAddress(String user, String pwd){
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        WebDriver driver = new FirefoxDriver();  
         
        driver.get("http://www.ncfxy.com/");  
        
		WebElement usernameEle = driver.findElement(By.id("name"));
		WebElement passwordEle = driver.findElement(By.id("pwd"));
		usernameEle.sendKeys(user);
		passwordEle.sendKeys(pwd);
        usernameEle.submit();  
        
        WebElement emailEle = 
        		driver.findElement(By.xpath("//tbody[@id='table-main']/tr[1]/td[2]"));
        
		String address = emailEle.getText();
		
        driver.quit();  

		return address;
	}
}
