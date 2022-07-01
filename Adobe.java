package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Adobe {
public ChromeDriver driver;
	@Test
	public  void adobepage() throws IOException {
		
		driver.findElement(By.xpath("//a[text()='Continue to United States']")).click();
		System.out.println(driver.getCurrentUrl());
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./Adobe.png");
		FileUtils.copyFile(source, destination);
				 
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'dexter-FlexContainer')]")));
		Long StartTime=System.currentTimeMillis();
		long endTime=System.currentTimeMillis();
		long totalTime=endTime-StartTime;
		System.out.println(StartTime.floatValue());
		
		System.out.println(StartTime);
		System.out.println("Loading Time:"+totalTime+"ms");
		String page = driver.getTitle();
		if(page.contains("Adobe: Creative")) {
			System.out.println("Target page loaded correctly");
			
		}
		
		

	}

}
