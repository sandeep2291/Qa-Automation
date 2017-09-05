package com.crm.testscripts;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.data.CrmData;
import com.crm.services.CrmServices;
import com.crm.validators.AdminValidators;


public class AdminTests {
	
	 public CrmServices crmservice = null;
	 public CrmData crmdata = null;
	 public AdminValidators adminvalidator = null;

	
	@BeforeClass
	public void init( ) throws IOException, InterruptedException {
		crmservice = new CrmServices();
		crmdata = new CrmData();
		adminvalidator = new AdminValidators();
		crmservice.openCrmHomePage().loginToCrm(crmdata.getCrmData().getRow(1).getCell(0).getStringCellValue(), crmdata.getCrmData().getRow(1).getCell(1).getStringCellValue() );
		}
	
	@Test(description = "create account with valid data", priority = 0)
	public void createAccountsWithValidData() throws IOException, InterruptedException {
		crmservice.navigateToAccounts().clickOnCreateAccount();
		crmservice.insertTextOnName(crmdata.getCrmData().getRow(1).getCell(2).getStringCellValue());
		crmservice.insertTextOnEmail(crmdata.getCrmData().getRow(1).getCell(3).getStringCellValue());
		crmservice.selectDropDownPhone(crmdata.getCrmData().getRow(1).getCell(4).getStringCellValue(), crmdata.getCrmData().getRow(1).getCell(5).getStringCellValue());
		crmservice.insertTextOnMobile();//(crmdata.getCrmData().getRow(1).getCell(6).getStringCellValue());
		crmservice.insertTextOnWebsite(crmdata.getCrmData().getRow(1).getCell(7).getStringCellValue());
		crmservice.insertTextOnBillingStreet(crmdata.getCrmData().getRow(1).getCell(8).getStringCellValue());
		crmservice.insertTextOnBillingCity(crmdata.getCrmData().getRow(1).getCell(9).getStringCellValue());
		crmservice.insertTextOnBillingState(crmdata.getCrmData().getRow(1).getCell(10).getStringCellValue());
		crmservice.insertTextOnBillingPostalCode();//(crmdata.getCrmData().getRow(1).getCell(11).getStringCellValue());
		crmservice.insertTextOnBillingCountry(crmdata.getCrmData().getRow(1).getCell(12).getStringCellValue());
		crmservice.clickOnCopyBilling();
		crmservice.selectDropDownType(crmdata.getCrmData().getRow(1).getCell(13).getStringCellValue(), crmdata.getCrmData().getRow(1).getCell(14).getStringCellValue());
		crmservice.insertTextOnDetailsSiccode();//(crmdata.getCrmData().getRow(1).getCell(15).getStringCellValue());
		crmservice.selectDropDownIndustry(crmdata.getCrmData().getRow(1).getCell(16).getStringCellValue(), crmdata.getCrmData().getRow(1).getCell(17).getStringCellValue());
		crmservice.insertTextOnDescription(crmdata.getCrmData().getRow(1).getCell(18).getStringCellValue());
		crmservice.clickOnSaveButton().getCreateAccountNameFromAccountPage();
		crmservice.getCreateAccountEmailFromAccountPage();
		crmservice .getCreateAccountPhoneFromAccountPage();
		crmservice.getCreateAccountWebsiteFromAccountPage();
		crmservice.getCreateAccountDetailsTypeFromAccountPage();
		crmservice.getCreateAccountDetailsSiccodeFromAccountPage();
		crmservice.getCreateAccountDetailsIndustryFromAccountPage();
		crmservice.getCreateAccountDetailsDescriptionFromAccountPage();
	//	crmservice.getCreateAccountBillingAddressFromAccountPage();
		adminvalidator.validateCreateAccount(crmservice);
		
		}
	
	//	@Test(description = "edit created account with valid data", priority = 1)
		public void editAccountWithValidData() throws IOException, InterruptedException {
			crmservice.clickOnEditButton();
			crmservice.editOnEmail().clickOnSaveButtonAfterEdit();
			
		}
		
	//	@Test(description = "Remove the created account", priority = 2)
		public void removeCreateAccount() throws IOException {
			crmservice.clickOnRemoveButton();
		}
		
		@Test(description = "Create Contact with valid data", priority = 3)
		public void createContactsWithValidData() throws IOException  {
			crmservice.navigateToContacts().clickOncreateContacts();
			crmservice.selectdropdownname(crmdata.getCrmData().getRow(4).getCell(0).getStringCellValue(), crmdata.getCrmData().getRow(4).getCell(1).getStringCellValue());
			crmservice.insertTextOnFirstName(crmdata.getCrmData().getRow(4).getCell(2).getStringCellValue());
			crmservice.insertTextOnLastName(crmdata.getCrmData().getRow(4).getCell(3).getStringCellValue());
			crmservice.clickOnAccountUpArrow();
			crmservice.insertTextOnContactsEmail(crmdata.getCrmData().getRow(4).getCell(4).getStringCellValue());
			crmservice.selectDropDownContactsphone(crmdata.getCrmData().getRow(4).getCell(5).getStringCellValue(), crmdata.getCrmData().getRow(4).getCell(6).getStringCellValue());
			crmservice.insertTextOnContactsMobile();
			crmservice.insertTextOnAddressStreet(crmdata.getCrmData().getRow(4).getCell(8).getStringCellValue());
			crmservice.insertTextOnAddressCity(crmdata.getCrmData().getRow(4).getCell(9).getStringCellValue());
			crmservice.insertTextOnAddressState(crmdata.getCrmData().getRow(4).getCell(10).getStringCellValue());
			crmservice.insertTextOnAddressPostalCode();
			crmservice.insertTextOnAddressCountry(crmdata.getCrmData().getRow(4).getCell(12).getStringCellValue());
			crmservice.insertTextOnAddressDescription(crmdata.getCrmData().getRow(4).getCell(13).getStringCellValue());
			crmservice.clickOnContactsSaveButton();
			crmservice.getCreateContactsNamefromContactPage();
			crmservice.getCreateContactsEmailfromContactPage();
			crmservice.getCreateContactsphonefromContactPage();
			adminvalidator.validateCreateContact(crmservice);
		}
		
		@Test(description="edit created contact with valid data", priority = 4)
		public void editContactsWithValidateData() throws IOException, InterruptedException {
			crmservice.clickOnContactsEditButton().editContactsEmail().clickOnContactsSaveButtonAfterEdit();
		}
		
		@Test(description="remove the created contact", priority = 5)
		public void removeCreateContact() throws IOException {
			crmservice.clickOnContactRemoveButton();
		}
		
	     
		
	//@Test 
	//public void verifyCrmLogin() throws IOException {
	//	crmservice.openCrmHomePage().loginToCrm();
	//}

}
