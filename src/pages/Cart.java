package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class Cart {
	WebDriver driver;
	SoftAssert sAssert= new SoftAssert();
	public Cart(WebDriver driver) {
		this.driver=driver;
	}

	//Locator for the total no of rows in the product table
	By totalRows=By.xpath("//table[@id='productCartTables']//tbody//tr");

	//Locator for the quantity in the product table
	By quantity=By.xpath("//table[@id='productCartTables']//tbody//tr[1]//td[3]");

	//Locator for the cost in the product table
	By cost=By.xpath("//table[@id='productCartTables']//tbody//tr[1]//td[4]");

	//Locator for the Total in the product table
	By total=By.xpath("//table[@id='productCartTables']//tbody//tr[1]//td[5]");

	//Locator for Total Amount
	By totalamount=By.xpath("//span[@class='totAmt']");

	//Locator for Place Order button
	By placeOrder=By.xpath("//button[contains(text(),'Place Order')]");



	//Method for validating the total= Quantity * Price 
	public void validate_TotalPrice_inEachRow()
	{

		List<WebElement> list=driver.findElements(totalRows);
		int count=list.size();
		for(int i=1;i<=count;i++)
		{
			int quantity=Integer.parseInt(driver.findElement(By.xpath("//table[@id='productCartTables']//tbody//tr["+i+"]//td[3]")).getText());
			int price=Integer.parseInt(driver.findElement(By.xpath("//table[@id='productCartTables']//tbody//tr["+i+"]//td[4]")).getText());
			int total=quantity * price;

			int TotalCost=Integer.parseInt(driver.findElement(By.xpath("//table[@id='productCartTables']//tbody//tr["+i+"]//td[5]")).getText());
			sAssert.assertEquals(total,TotalCost);
		}
	}

	//Method for validating the totalAmout= Sum of total 
	public void validate_SumOfTotal()
	{
		int sumTotal=0;
		List<WebElement> list=driver.findElements(totalRows);
		int count=list.size();
		for(int i=1;i<=count;i++)
		{
			int total=Integer.parseInt(driver.findElement(By.xpath("//table[@id='productCartTables']//tbody//tr["+i+"]//td[5]")).getText());
			sumTotal=sumTotal+total;

		}

		int totalAmount=Integer.parseInt(driver.findElement(totalamount).getText());
		sAssert.assertEquals(totalAmount,sumTotal);
	}

	public void ClickPlaceOrderButton()
	{
		driver.findElement(placeOrder).click();
	}
}
