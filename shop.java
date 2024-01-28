package mobileCart;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class shop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("Webdriver.chorme.driver", "\"C:\\Users\\win11\\Downloads\\chromedriver_win32\\chromedriver.exe\"");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String[] phones= {"Iphone X","Samsung Note 8"};
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.id("usertype")).click();
		WebElement dropdown = driver.findElement(By.cssSelector("select.form-control"));
		Select drop= new Select (dropdown);
		drop.selectByVisibleText("Consultant");
		driver.findElement(By.id("terms")).click();
		//Thread.sleep(2000);
		driver.findElement(By.id("signInBtn")).click();
		Thread.sleep(3000);
		addCart(driver,phones);
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Thread.sleep(3000);
		//driver.findElement(By.id("country")).sendKeys("India");
		driver.findElement(By.xpath("//input[@value='Purchase']")).click();
		
		
		
	}
	public static void addCart(WebDriver driver,String[] phones) {
		
		int count=0;
		List<WebElement> products = driver.findElements(By.cssSelector("div.card-body"));
		for(int i=0;i<products.size();i++) {
			for(int j=0;j<phones.length;j++) {
				if(products.get(i).getText().contains(phones[j].toString())) {
					count++;
					driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
					if(count==phones.length)
						break;
				}
			}
		}
		
		
		
		
		
	}

}
