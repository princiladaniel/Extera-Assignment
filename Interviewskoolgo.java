package week4.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Interviewskoolgo {
	public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get(" https://skoolgo.pixelmindit.com:8000/#/");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//a[text()= 'Sign Up']")).click();
	driver.findElement(By.id("fullName")).sendKeys("kiruthiga");
	driver.findElement(By.id("email")).sendKeys("kiruthidhanapal@gmail.com");
	//driver.findElement(By.xpath("//select[text()= 'Phone number country']")).click();
	
	//phone input country select
	
	driver.findElement(By.className("PhoneInputCountrySelect")).click();
	List<WebElement> countryselect = driver.findElements(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/div[2]/form/div/div[1]/div/div[5]/div/div/span/div/div/select/option"));
	for(WebElement select :  countryselect) {
		if(select.getText().equals("India")) {
			select.click();
		}
	}

	
	//mobile number sent
	driver.findElement(By.id("mobile")).sendKeys("7708096218");
	
	//passport number sent
	driver.findElement(By.id("personalId")).sendKeys("R7");
	//dob select
	
//driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div[1]")).click();
	

//nationality
	//driver.findElement(By.id("nationality")).click();
List<WebElement> nationalityList = driver.findElements(By.xpath("//*[@id=\"nationality\"]/option"));
for(WebElement List :  nationalityList) {
	if(List.getText().equals("India")) {
		List.click();
	}
}



//gender select 
List<WebElement> optionList = driver.findElements(By.xpath("//*[@id=\"gender\"]/option"));
for(WebElement webElement : optionList) {
	if(webElement.getText().equals("Female")) {
		webElement.click();
	}
}

driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiInput-input']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//p[text()='4']")).click();

//upload photo

//String path = System.getProperty();

//System.out.println(path);

WebElement scroll = driver.findElement(By.xpath("(//label[text()='Upload Photo'])[2]"));

driver.executeScript("arguments[0].scrollIntoView();", scroll);
scroll.click();
driver.findElement(By.id("uploadPhoto")).sendKeys("C:\\Users\\dell\\Pictures\\ques.jpg");


//password sent
driver.findElement(By.id("password")).sendKeys("kiruthiga251191");
driver.findElement(By.id("confirmPassword")).sendKeys("kiruthiga251191");
//check box selctv
WebElement box = driver.findElement(By.id("Accept"));
driver.executeScript("arguments[0].click();", box);
driver.findElement(By.id("create-account")).click();

// click create account
//WebElement check = driver.findElement(By.xpath("//*[@id="create-account"]"));
//check.click();

	

	
	
	
}}