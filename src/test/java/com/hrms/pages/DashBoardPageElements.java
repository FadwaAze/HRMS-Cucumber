package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class DashBoardPageElements extends CommonMethods {

	@FindBy(xpath = "//a[contains(text(),'Welcome')]")// good to use contain because it's dynamic -> change with each user name
	public WebElement welcome;

	@FindBy(xpath = "//div[@id='branding']/a[1]/img")
	public WebElement logo;

	@FindBy(xpath = "//a[@id='menu_pim_addEmployee']")
	public WebElement addEmp;

	@FindBy(xpath = "//a[@id='menu_pim_viewPimModule']")
	public WebElement PIM;

	@FindBy(id = "menu_pim_viewEmployeeList")
	public WebElement empListPage;

	public DashBoardPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}

	public void navigateToAddEmployee() {
		jsClick(PIM);// best option to click when click button is not working
		jsClick(addEmp);
	}
}