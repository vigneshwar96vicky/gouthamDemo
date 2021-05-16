package org.swag.stepdefinition;

import org.swag.commonactions.CommonAction;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends CommonAction {

	CommonAction ca = new CommonAction();

	@Before()
	public void before() throws InterruptedException {

		System.out.println("User launches application");
		ca.startchrome();
	}

	@After()
	public void after(Scenario scenario) {

		ca.closeBrowser();
	}

}
