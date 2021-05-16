package org.swag.stepdefinition;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.swag.commonactions.CommonAction;
import org.swag.locators.SwagLocators;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SwagTest extends CommonAction {

	CommonAction ca = new CommonAction();
	SwagLocators sl = new SwagLocators();
	String actual;
	String expected;

	@Given("Launches application and Login")
	public void launches_application_and_Login() throws FileNotFoundException, IOException, InterruptedException {
		ca.insertText(sl.getUname(), ca.getproperty("username"));
		ca.insertText(sl.getPwd(), ca.getproperty("password"));
		ca.click(sl.getLoginbtn());
		ca.eletobewait();

	}

	@Given("Add the product to the cart")
	public void add_the_product_to_the_cart() throws InterruptedException {
		actual = sl.getProductvalue().getText();
		ca.click(sl.getAddcart());
		ca.eletobewait();


	}

	@Then("Checkout and validate the product details whether you are ordered the correct product")
	public void checkout_and_validate_the_product_details_whether_you_are_ordered_the_correct_product() throws InterruptedException {
		ca.click(sl.getCartlink());
		ca.eletobewait();
		expected = sl.getGetcartproductvalue().getText();
		Assert.assertEquals(expected, actual);
		System.out.println(expected+" value is found same in add to page page");
	}


	@Then("Get all the product lists and check the particular product {string} is available.")
	public void get_all_the_product_lists_and_check_the_particular_product_is_available(String actualvalue) {

		List<WebElement> allproductvalues = driver.findElements(By.xpath("//a/div"));
		for (WebElement eachvalue : allproductvalues) {
			String expectedvalue = eachvalue.getText();
			if(expectedvalue.equals(actualvalue))
			{
				System.out.println("Sceanrio 2 - checked the particular product " +expectedvalue +" is available.");
			}

		}
	}

	@And("Get the price of all products and remove the dollar symbol")
	public void get_the_price_of_all_products_and_remove_the_dollar_symbol() {

		List<WebElement> prices = driver.findElements(By.xpath("//a/div//parent::div//following::div[@class='inventory_item_price']"));
		for (WebElement eachprice : prices) {
			String text = eachprice.getText();
			String rtext = text.replace("$", "");
			System.out.println(rtext);
		}	

	}

	@Then("Validate the price with product listing with product individual page")
	public void validate_the_price_with_product_listing_with_product_individual_page() throws InterruptedException {

		List<WebElement> allproductvalues = driver.findElements(By.xpath("//a/div"));
		int size = allproductvalues.size();	
		for (int i=1;i<size;i++)
		{
			WebElement eachvalue = driver.findElement(By.xpath("(//a/div)["+i+"]"));
			String productvalue = eachvalue.getText();
			String productprice = driver.findElement(By.xpath("(//a/div//parent::div//following::div[@class='inventory_item_price'])["+i+"]")).getText();	
			ca.click(eachvalue);
			ca.eletobewait();
			WebElement selectedpdctvalue = driver.findElement(By.xpath("//div[@class='inventory_details_price']"));
			String selectedprice = selectedpdctvalue.getText();
			System.out.println("productvalue" +productvalue +"productprice" +productprice);
			if(productprice.equalsIgnoreCase(selectedprice))
			{
				System.out.println(productprice +" After selecting product price is same- validated " +selectedprice);
			}
			ca.eletobewait();
			ca.click(sl.getBacktopdct());
			ca.eletobewait();

		}

	}
	
	@Given("Launches application and Login via invalid username")
	public void launches_application_and_Login_via_invalid_username() throws FileNotFoundException, IOException, InterruptedException {
		ca.insertText(sl.getUname(), ca.getproperty("invalidname"));
		ca.insertText(sl.getPwd(), ca.getproperty("password"));
		ca.click(sl.getLoginbtn());
		ca.eletobewait();

	}

	@Then("Validate the error message")
	public void validate_the_error_message() {
	   String text = sl.getErromsg().getText();
	   String actual="Epic sadface: Username and password do not match any user in this service";
	   if(actual.contains(text))
	   {
		   System.out.println("Error message validated:   " +text);
	   }
	}
}
