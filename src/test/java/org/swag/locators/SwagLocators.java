package org.swag.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.swag.commonactions.CommonAction;


public class SwagLocators extends CommonAction {

    public SwagLocators() {
        PageFactory.initElements(CommonAction.driver, this);
    }

    @FindBy(id = "user-name")
    private WebElement uname;
    
    @FindBy(id = "password")
    private WebElement pwd;
    
    @FindBy(id = "login-button")
    private WebElement loginbtn;
    
    @FindBy(xpath = "(//button[text()='Add to cart'])[1]")
    private WebElement addcart;
    
    @FindBy(className = "shopping_cart_link")
    private WebElement cartlink;
    
    @FindBy(xpath ="//div[text()='QTY']//parent::div//following-sibling::div/a/div")
    private WebElement getcartproductvalue;
    
    @FindBy(xpath ="(//a/div)[1]")
    private WebElement productvalue;

    @FindBy(id="back-to-products")
    private WebElement backtopdct;

    @FindBy(tagName = "h3")
    private WebElement erromsg;
    
	public WebElement getUname() {
		return uname;
	}

	public WebElement getPwd() {
		return pwd;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	public WebElement getAddcart() {
		return addcart;
	}

	public WebElement getCartlink() {
		return cartlink;
	}

	public WebElement getGetcartproductvalue() {
		return getcartproductvalue;
	}

	public WebElement getProductvalue() {
		return productvalue;
	}

	public WebElement getBacktopdct() {
		return backtopdct;
	}

	public WebElement getErromsg() {
		return erromsg;
	}
    

}
