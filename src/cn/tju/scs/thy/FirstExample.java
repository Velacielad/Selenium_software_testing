package cn.tju.scs.thy;

import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;  
import org.openqa.selenium.firefox.FirefoxDriver;  
import org.openqa.selenium.support.ui.ExpectedCondition;  
import org.openqa.selenium.support.ui.WebDriverWait;  
  
  
public class FirstExample {  
	
    public static void main(String[] args) {  
    	System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        WebDriver driver = new FirefoxDriver();  
  
        driver.get("http://www.ncfxy.com/");  
		WebElement usernameEle = driver.findElement(By.id("name"));
		WebElement passwordEle = driver.findElement(By.id("pwd"));
		usernameEle.sendKeys("3013218145");
		passwordEle.sendKeys("218145");
        usernameEle.submit();  
        try {  
            Thread.sleep(3000);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        WebElement emailEle = 
        		driver.findElement(By.xpath("//tbody[@id='table-main']/tr[1]/td[2]"));
        String email = emailEle.getText();
        System.out.println("Page title is: " + email);  
       
        driver.quit();  
    }  
  
    
}  