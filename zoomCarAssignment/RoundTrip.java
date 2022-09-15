package zoomCarAssignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RoundTrip {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
    ChromeDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.zoomcar.com/");
	driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
    //02) Select the country, city and confirm
    WebElement country = driver.findElement(By.xpath("(//div[@class='multiselect__select'])[1]"));
    country.click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//span[text()='India']")).click();
    WebElement city = driver.findElement(By.xpath("(//div[@class='multiselect'])[2]"));
    city.click();
    WebElement Chennaicity = driver.findElement(By.xpath("//span[text()='Chennai']"));
    Chennaicity.click();
    Thread.sleep(2000);
    driver.executeScript("arguments[0].click();", Chennaicity);
    driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
 //03) Confirm Round trip is selected (by green color text)
    String roundTripColour = driver.findElement(By.xpath("//span[text()='Round Trip']")).getCssValue("color");
    System.out.println(roundTripColour);
  //04) Click pick up city
    driver.findElement(By.xpath("//div[contains(text(),'Pick Up City')]")).click();
    //05) Select the first suggested pick up locations
    driver.findElement(By.className("ellipsis")).click();
    //07) Select the start date as upcoming saturday
    Actions builder=new Actions(driver);
    //driver.findElement(By.xpath("//button[contains(text(),'CLEAR')]")).click();
    driver.findElement(By.xpath("//span[@class='field-date start-time']")).click();
    Thread.sleep(5000);
    WebElement date = driver.findElement(By.xpath("//table[@class='table']//tr[3]/td[7]"));
    builder.doubleClick(date).perform();
    //08) Select the end date as 5 days from start date
   //driver.findElement(By.xpath("//i[@class='icon icon-arrow-left']")).click();
   //driver.findElement(By.xpath("//a[@class='field-wrap']")).click();
    Thread.sleep(5000);
    driver.findElement(By.xpath("//table[@class='table']//tr[4]/td[5]")).click();
    WebElement slide = driver.findElement(By.xpath("(//input[@name='timerange'])[1]"));
    Point location = slide.getLocation();
    int x = location.getX();
    int y = location.getY();
    Dimension size = slide.getSize();
    int width=size.width;
    
    builder.moveToElement(slide).click().perform();
    //09) Click Continue
    driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
    //10) Click Find Cars
    driver.findElement(By.xpath("//button[contains(text(),'Find cars')]")).click();
   //11) Print the lowest priced car
    List<WebElement> lowestCarPrice = driver.findElements(By.xpath("//div[@class='price-bar d-f ai-c ta-c']/div[1]"));
    List<String>carList=new ArrayList<String>(); 
    String price = "";
    for (int i = 0; i < lowestCarPrice.size(); i++) {
    	 price = lowestCarPrice.get(i).getText();
      carList.add(price); 
    }
    Collections.sort(carList);
    System.out.println(price);
    System.out.println(carList.size());
   
    System.out.println(carList.get(0));
    //get all the price name save least count click 
//12) Mouse over on the Book now of the car, confirm the color changes.
    WebElement mouseHover = driver.findElement(By.xpath("//button[contains(text(),'Book Now')]"));
builder.moveToElement(mouseHover).perform();
String cssValue = mouseHover.getCssValue("color");
System.out.println(cssValue);
    //13) Close the browser

	
}
}
