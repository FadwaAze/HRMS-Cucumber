package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class PersonalDetailsPageElement {
	
	@FindBy(id="personal_cmbNation")//specify the locator 
	public WebElement nationalityDD;
	
	@FindBy(css="input[id='personal_txtLicExpDate']")
	public WebElement licenseExpiryDate;
	
	@FindBy(css="input[id='personal_txtNICNo']")
	public WebElement ssnNum;
	
	@FindBy(css="input[id='personal_txtSINNo']")
	public WebElement sinNum;
	
	@FindBy(xpath="//select[@id='personal_cmbMarital']")
	public WebElement maritalStatus;
	
	@FindBy(xpath="//input[@id='personal_DOB']")
	public WebElement DOB;
	
	@FindBy(name="personal[optGender]")
	public List<WebElement> genderRadioGroup;
	
	@FindBy(xpath = "//div[@id='pdMainContainer']/div[1]/h1")
	public WebElement lblPersonalDetails;

	@FindBy(id = "personal_txtEmployeeId")
	public WebElement employeeId;
	
	@FindBy(xpath="//div[@id='profile-pic']//h1")
	public WebElement profilePic;
	
	@FindBy(xpath="//input[@id='btnSave']")
	public WebElement editBtn;
	
	@FindBy(xpath="//input[@id='btnSave']")
	public WebElement saveBtn;
	
	@FindBy(xpath="//input[@id='personal_txtEmpNickName']")
	public WebElement nickName;
	
	@FindBy(xpath="//input[@id='personal_txtMilitarySer']")
	public WebElement militarySer;
	
	public PersonalDetailsPageElement () {//---> constructor to initialize ALL instant variables at once
		PageFactory.initElements(BaseClass.driver, this);
	}

}
