package learnRetry;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.DynamicData;

import util.ReadExcel;
public class CreateLead extends BaseClass{
	
List<DynamicData> data=new ArrayList<DynamicData>();

	
@BeforeTest
public void generateData() {
	//excelFileName="Sheet1";
	Faker faker=new Faker();
	for(int i=0; i< 10; i++) {
		
		DynamicData dynamicData = new DynamicData();
		dynamicData.setcompanyName(faker.company().name());
		dynamicData.setFirstName(faker.name().firstName());
		dynamicData.setLastName(faker.name().lastName());
		dynamicData.setPhoneNumber(faker.phoneNumber().cellPhone());
		
		data.add(dynamicData);
		
	}
}
	
@Test//(retryAnalyzer =RetryListener.class )
	public void createLead() {
	
		int randomNum = new Random().nextInt(100);
		DynamicData dynamicData = data.get(randomNum);
		
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(dynamicData.getCompanyName());
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(dynamicData.getFirstName());
		driver.findElement(By.id("createeadForm_lastName")).sendKeys(dynamicData.getLastName());
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(dynamicData.getPhoneNumber());
		driver.findElement(By.name("submitButton")).click();
	
		
}
	
		

}
