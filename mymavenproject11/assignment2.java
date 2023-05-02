package mymavenproject11;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class assignment2 {
	
ChromeDriver driver;
	

	
	@DataProvider(name = "loginData")
	public Object[][] datasetTwo(){
		return new Object[][] {
			{"standard_user","secret_sauce"},
			{"locked_out_user","secret_sauce"},
			{"problem_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"}
			
		};
	}
	
	
	
	
	//1) verify the login user
//	@Test(dataProvider ="loginData")
//	
//		
//	public void login (String username, String password) throws InterruptedException {
//		
//		System.setProperty("WebDriver.Chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
//	driver = new ChromeDriver ();
//	  
//	driver.get("https://www.saucedemo.com/");
//	driver.manage().window().maximize();
//	driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
//	Thread.sleep(5000);
//	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
//	driver.findElement(By.xpath("//input[@type='submit']")).submit();
//
//  List<WebElement> Number = driver.findElements(By.xpath("//div[@class='inventory_item']"));
//  System.out.println(Number.size());
//  Assert.assertEquals(Number.size(), 6);
//    driver.quit();
//}
	@Test(enabled = false)
	public void getsize() throws InterruptedException {
	
	System.setProperty("WebDriver.Chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
driver = new ChromeDriver ();
  
driver.get("https://www.saucedemo.com/");
driver.manage().window().maximize();
driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
Thread.sleep(5000);
driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
driver.findElement(By.xpath("//input[@type='submit']")).submit();

List<WebElement> Number = driver.findElements(By.xpath("//div[@class='inventory_item']"));
System.out.println(Number.size());
Assert.assertEquals(Number.size(), 6);
driver.quit();
}
	
//2) verify dashboard logo	
	@Test(enabled = false)
	public void getlogo() throws InterruptedException {
	
	System.setProperty("WebDriver.Chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
driver = new ChromeDriver ();
  
driver.get("https://www.saucedemo.com/");
driver.manage().window().maximize();
driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
Thread.sleep(5000);
driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
driver.findElement(By.xpath("//input[@type='submit']")).submit();
	
	driver.findElement(By.cssSelector("div[class=\"app_logo\"]")).click();
//	if(driver.findElement(By.cssSelector("div[class=\"app_logo\"]")).getText().equals("Swag Labs")) {
//		System.out.println("pass");
//	}
	Assert.assertEquals(driver.findElement(By.cssSelector("div[class=\"app_logo\"]")).getText(), "Swag Labs");
	}
	
//3)verify number od items in navigation bar	
	@Test(enabled = true)
	public void getitems() throws InterruptedException {
	
	System.setProperty("WebDriver.Chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
driver = new ChromeDriver ();
  
driver.get("https://www.saucedemo.com/");
driver.manage().window().maximize();
driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
Thread.sleep(5000);
driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
driver.findElement(By.xpath("//input[@type='submit']")).submit();	
	driver.findElement(By.id("react-burger-menu-btn")).click();
	List<WebElement> items = driver.findElements(By.cssSelector(".bm-item.menu-item"));
	Assert.assertEquals(items.size(), 4);
	driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
	String Number = driver.findElement(By.cssSelector("span[class='shopping_cart_badge']")).getText();
	Assert.assertEquals(Number, "1");

	}
	
	//4)verify the add to cart functionality
	@Test(enabled = false)
	public void getcart() throws InterruptedException {
	
	System.setProperty("WebDriver.Chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
driver = new ChromeDriver ();
  
driver.get("https://www.saucedemo.com/");
driver.manage().window().maximize();
driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
Thread.sleep(5000);
driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
driver.findElement(By.xpath("//input[@type='submit']")).submit();	
driver.findElement(By.cssSelector("button[id='add-to-cart-sauce-labs-backpack']")).click();
driver.findElement(By.cssSelector("span[class='shopping_cart_badge']")).click();

Assert.assertEquals(driver.findElement(By.cssSelector("div[class='inventory_item_name']")).getText(), "Sauce Labs Backpack");

}
	
	//5) verify the filter
	

//filter by A to z
@Test(enabled = false)
public void getfilter1() throws InterruptedException {

System.setProperty("WebDriver.Chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
driver = new ChromeDriver ();

driver.get("https://www.saucedemo.com/");
driver.manage().window().maximize();
driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
Thread.sleep(5000);
driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
driver.findElement(By.xpath("//input[@type='submit']")).submit();

List<WebElement> AtoZ   = driver.findElements(By.cssSelector("div[class='inventory_item_name']"));
List<String> expectedAtoZ =new ArrayList<String> ();

for(int i = 0; i< AtoZ.size(); i++) {
	String names = AtoZ.get(i).getText();
//ystem.out.println(names);
	expectedAtoZ.add(names);
}
//sorting the list alphabetically
Collections.sort(expectedAtoZ);
System.out.println(expectedAtoZ);
List<WebElement> AtoZ1 = driver.findElements(By.cssSelector("div[class='inventory_item_name']"));
List<String> ActualAtoZ  = new ArrayList <String> (); //create a list to store the sorted product names
for(int i = 0; i< AtoZ1.size(); i++) {
	String names1 = AtoZ1.get(i).getText();
	ActualAtoZ.add(names1);
//ystem.out.println(names1);
	}
Assert.assertEquals(ActualAtoZ, expectedAtoZ);


}
//filter by Z to A
@Test(enabled=false)
public void getfilter2() throws InterruptedException {

System.setProperty("WebDriver.Chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
driver = new ChromeDriver ();

driver.get("https://www.saucedemo.com/");
driver.manage().window().maximize();
driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
Thread.sleep(5000);
driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
driver.findElement(By.xpath("//input[@type='submit']")).submit();

WebElement select1 = driver.findElement(By.cssSelector("select[class='product_sort_container']"));
Select dropdownZtoA = new Select(select1);
dropdownZtoA.selectByIndex(1);

List<WebElement> ZtoA   = driver.findElements(By.cssSelector("div[class='inventory_item_name']"));
List<String> expectedZtoA =new ArrayList<String>();

for(int i = 0; i< ZtoA.size(); i++) {
	String name = ZtoA.get(i).getText();
expectedZtoA.add(name);
	}
Collections.sort(expectedZtoA, Collections.reverseOrder()); 
System.out.println(expectedZtoA);
//sorting list by descending order
List<WebElement> ZtoA1   = driver.findElements(By.cssSelector("div[class='inventory_item_name']"));
List<String> ActualZtoA =new ArrayList<String>();

for(int i = 0; i< ZtoA1.size(); i++) {
	String name1 = ZtoA1.get(i).getText();
	ActualZtoA.add(name1);
//ystem.out.println(ActualZtoA);
}
	Assert.assertEquals(ActualZtoA, expectedZtoA);
}
@Test(enabled = false)
public void getlowtohigh() throws InterruptedException {

System.setProperty("WebDriver.Chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
driver = new ChromeDriver ();

driver.get("https://www.saucedemo.com/");
driver.manage().window().maximize();
driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
Thread.sleep(5000);
driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
driver.findElement(By.xpath("//input[@type='submit']")).submit();
List <WebElement> list = driver.findElements(By.cssSelector("div[class='inventory_item_price']"));
List<Double> price = new ArrayList<Double>();
for(int i = 0; i< list.size(); i++) {
	Double prices = Double.valueOf(list.get(i).getText().replace("$", ""));
	price.add(prices);
	//sorting low to high
	Collections.sort(price);
	System.out.println(price);
	}

WebElement list2= driver.findElement(By.cssSelector("select[class='product_sort_container']"));
Select dropdown2 = new Select(list2);
dropdown2.selectByIndex(2);

List <WebElement> list1 = driver.findElements(By.cssSelector("div[class='inventory_item_price']"));
List<Double> actual1 = new ArrayList<Double>();
for(int i = 0; i< list1.size(); i++) {
	Double prices2 = Double.valueOf(list1.get(i).getText().replace("$", ""));
	actual1.add(prices2);
	
}
Assert.assertEquals(actual1,price);
}
//high to low with for each
@Test(enabled=false)
public void getlowtohigh1() throws InterruptedException {

System.setProperty("WebDriver.Chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
driver = new ChromeDriver ();

driver.get("https://www.saucedemo.com/");
driver.manage().window().maximize();
driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
Thread.sleep(5000);
driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
driver.findElement(By.xpath("//input[@type='submit']")).submit();
List <WebElement> list = driver.findElements(By.cssSelector("div[class='inventory_item_price']"));
List<Double> price = new ArrayList<Double>();
for(WebElement a1: list) {
	price.add(Double.valueOf(a1.getText().replace("$", "")));
	
}
WebElement list2= driver.findElement(By.cssSelector("select[class='product_sort_container']"));
Select dropdown2 = new Select(list2);
dropdown2.selectByIndex(2);
List <WebElement> actualhighlow = driver.findElements(By.cssSelector("div[class='inventory_item_price']"));
List <Double> actualhigh = new ArrayList <Double> ();
for(WebElement bb:actualhighlow) {
	actualhigh.add(Double.valueOf(bb.getText().replace("$", "")));
	Collections.sort(price);
	Collections.reverse(price);
	System.out.println(price);
}
Assert.assertEquals(price, actualhigh);


}
@Test(enabled=false)
public void gethightolow() throws InterruptedException {

System.setProperty("WebDriver.Chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
driver = new ChromeDriver ();

driver.get("https://www.saucedemo.com/");
driver.manage().window().maximize();
driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
Thread.sleep(5000);
driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
driver.findElement(By.xpath("//input[@type='submit']")).submit();
List <WebElement>list2 = driver.findElements(By.cssSelector("div[class='inventory_item_price']"));
List<Double> expectedhigh = new ArrayList <Double> ();
for(int i = 0; i< list2.size(); i++) {
	Double expectedprice = Double.valueOf(list2.get(i).getText().replace("$", ""));
expectedhigh.add(expectedprice);
}
	Collections.sort(expectedhigh, Collections.reverseOrder());
	System.out.println(expectedhigh);

WebElement list3= driver.findElement(By.cssSelector("select[class='product_sort_container']"));
Select dropdownhigh = new Select(list3);
dropdownhigh.selectByIndex(3);

List <WebElement> actualhighlow = driver.findElements(By.cssSelector("div[class='inventory_item_price']"));
List <Double> actualhigh = new ArrayList <Double> ();
for(int i = 0; i < actualhighlow.size(); i++) {
	Double actualprice = Double.valueOf(actualhighlow.get(i).getText().replace("$", ""));
	actualhigh.add(actualprice);
}
Assert.assertEquals(actualhigh, expectedhigh);
}

	//6)verify the complete order flow
	@Test(enabled = false)
	public void getorder() throws InterruptedException {
	
	System.setProperty("WebDriver.Chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
driver = new ChromeDriver ();
  
driver.get("https://www.saucedemo.com/");
driver.manage().window().maximize();
driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
Thread.sleep(5000);
driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
driver.findElement(By.xpath("//input[@type='submit']")).submit();	
driver.findElement(By.cssSelector("button[id='add-to-cart-sauce-labs-backpack']")).click();
driver.findElement(By.cssSelector("span[class='shopping_cart_badge']")).click();
driver.findElement(By.cssSelector("button[id='checkout']")).click();
driver.findElement(By.cssSelector("input[placeholder='First Name']")).sendKeys("Anjila");
driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys("Katuwal");
driver.findElement(By.cssSelector("input[placeholder='Zip/Postal Code']")).sendKeys("73159");
driver.findElement(By.cssSelector("input[type='submit']")).submit();
driver.findElement(By.cssSelector("button[class='btn btn_action btn_medium cart_button']")).click();
Assert.assertEquals(driver.findElement(By.cssSelector("h2[class='complete-header']")).getText(), "Thank you for your order!");
	}

	//7) verify the calculation of price on checkout page

	@Test(enabled=false)
	public void getcalculation() throws InterruptedException {

	System.setProperty("WebDriver.Chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
	driver = new ChromeDriver ();

	driver.get("https://www.saucedemo.com/");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
	Thread.sleep(5000);
	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
	driver.findElement(By.xpath("//input[@type='submit']")).submit();
	driver.findElement(By.cssSelector("button[id='add-to-cart-sauce-labs-backpack']")).click();
	driver.findElement(By.cssSelector("span[class='shopping_cart_badge']")).click();
	driver.findElement(By.cssSelector("button[id='checkout']")).click();
	driver.findElement(By.cssSelector("input[placeholder='First Name']")).sendKeys("Anjila");
	driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys("Katuwal");
	driver.findElement(By.cssSelector("input[placeholder='Zip/Postal Code']")).sendKeys("73159");
	driver.findElement(By.cssSelector("input[type='submit']")).submit();
	
	  List<WebElement>  priceTotal =driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
	    
	    double sumofTotal =0;
	      for(int i=0; i<priceTotal.size(); i++ ) {
	      //  System.out.println(priceTotal.get(i).getText().replace("$", ""));
	        sumofTotal= sumofTotal+Double.valueOf(priceTotal.get(i).getText().replace("$", ""));  
	      }
  
	      Double calculatedTax = sumofTotal * 0.08; 
	      
	 
	      //Double TaxAmount=Double.valueOf(calculatedTaxAmount.replace("$", ""));
	      DecimalFormat df = new DecimalFormat("#.##"); // to round off the values to 2 decimal places
	      String totalExpected= df.format(sumofTotal+calculatedTax);
	      System.out.println(totalExpected);
	    
	   String Actual=  driver.findElement(By.xpath("//div[@class='summary_info_label summary_total_label']")).getText().replace("Total: $","" );
	  
	      System.out.println(Actual);

	//System.out.println(ActualpriceTotal);
	 
	  Assert.assertEquals(totalExpected,Actual, "Sum of prices ");
	}
	    
	    
	    
	  
	
}