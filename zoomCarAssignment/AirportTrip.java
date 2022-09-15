package zoomCarAssignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.beust.jcommander.JCommander.Builder;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AirportTrip {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch=new ChromeOptions();
		ch.addArguments("--disable-notifications");
	    ChromeDriver driver=new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.get("https://www.zoomcar.com/");
		driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	    //02) Select the country, city and confirm
	    WebElement country = driver.findElement(By.xpath("(//div[@class='multiselect__select'])[1]"));
	    country.click();
	    driver.findElement(By.xpath("//span[text()='India']")).click();
	    Thread.sleep(5000);
	    WebElement city = driver.findElement(By.xpath("(//div[@class='multiselect'])[2]"));
	    city.click();
	    WebElement Chennaicity = driver.findElement(By.xpath("//span[text()='Chennai']"));
	    Chennaicity.click();
	    Thread.sleep(2000);
	    driver.executeScript("arguments[0].click();", Chennaicity);
	    driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
	  //03) Click Airport round trip is selected
	    driver.findElement(By.xpath("//span[text()='Airport Round Trip']")).click();
	//04) Click pick up city
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//div[@class='field field-address']")).click();
		/*
		 * //05) Click current location (make sure notification is disabled)
		 * 
		 * Thread.sleep(10000); WebElement clocation =
		 * driver.findElement(By.xpath("//div[@class='my-location pointer']"));
		 * //driver.executeScript("arguments[0].click();", clocation);
		 * Thread.sleep(10000); //06) Confirm Location unavailable message exists.
		 * WebElement message
		 * =driver.findElement(By.xpath("//h2[text()='Location Unavailable']")); String
		 * msg = message.getText(); if(msg.contains("Unavailable")) {
		 * System.out.println(msg+"unavailable message exists"); } else {
		 * System.out.println("Message Nt exists"); }
		 */
	    
	    //07) Click Ok
	   //driver.findElement(By.xpath("//button[contains(text(),'ok')]")).click();
	//08) Select location on Map
	   driver.findElement(By.xpath("//a[@class='map pointer']")).click();
	//09) Move the location by 100 pixels x axis
	   Actions builder=new Actions(driver);
	   
	   WebElement mapMarker = driver.findElement(By.xpath("//img[@src='/img/icons/ic_pin.png']"));
	   Thread.sleep(3000);
	   builder.moveToElement(mapMarker).sendKeys(mapMarker, Keys.HOME).release().dragAndDropBy(mapMarker,567, 255).perform();
	   //builder.moveToElement(mapMarker).clickAndHold().keyDown(Keys.END).release().dragAndDropBy(mapMarker, 550, 108).perform();
	   //builder.moveToElement(mapMarker).clickAndHold().keyDown(Keys.PAGE_DOWN).release().dragAndDropBy(mapMarker, 600,100).perform();
	   //10) Click Continue
	   driver.findElement(By.xpath("//div[@class='button-primary']")).click();
	//11) Find Cars
	   driver.findElement(By.xpath("//button[@class='button-primary']")).click();
	//12) Confirm Minimum lead time message appears
	   String text = driver.findElement(By.xpath("//div[@class='heading']")).getText();
	   if(text.contains("lead time")) {
		   System.out.println("lead time message appears");
	   }
	//13) Click Become a Host
	   driver.findElement(By.xpath("//span[text()='Become a Host']//parent::a")).click();
	   String parentWindow = driver.getTitle();
	//14) Confirm another window opens
	   Set<String> windowHandles = driver.getWindowHandles();
	   List<String>lstWindow=new ArrayList<String>(windowHandles);
	   driver.switchTo().window(lstWindow.get(1));
	   String childWindow = driver.getTitle();
	   if(parentWindow.equals(childWindow)) {
		   System.out.println("Window not open");
	   }
	   else {
		   System.out.println("window open");
	   }
	//15) Close both windows
      driver.quit();

	}

}
