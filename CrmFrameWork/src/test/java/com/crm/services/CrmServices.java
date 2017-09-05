package com.crm.services;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.crm.config.BaseConfiguration;
import com.crm.config.CrmPageConstants;
import com.crm.objectrepo.PageObjects;
import com.crm.utils.Common;

public class CrmServices extends BaseConfiguration {
	public PageObjects pageObj;
	private static Logger Log = Logger.getLogger(CrmServices.class.getName());
   
	public CrmServices openCrmHomePage( ) {
		pageObj = new PageObjects();
		invokeBrowser();
		return this;
		
	}
	
	public CrmServices loginToCrm (String uname, String pword ) throws IOException {
		Common.insertText("id", pageObj.getPageObjects().getProperty("crmhomepage_username_txtfieldid"), uname, wd);
		Common.insertText("id", pageObj.getPageObjects().getProperty("crmhomepage_password_txtfieldid"), pword, wd);
		Common.clickButton("id", pageObj.getPageObjects().getProperty("crmhomepage_login_buttonid"),  wd);
		//Common.validatePage(CrmPageConstants.CRM_LOGIN_PAGE_TITLE.title(), wd);
		Log.info("user logged in succesfully");
		return this;
	}
	
	public CrmServices navigateToAccounts() throws IOException, InterruptedException {
		Common.clickLink("link", pageObj.getPageObjects().getProperty("crm_dashboard_accountslink"),  wd);
		Common.wait(2);
		//Common.validatePage(CrmPageConstants.CRM_ACCOUNTS_PAGE_TITLE.title(), wd);
		Log.info("account page open succesfully");
		return this;
	}
	
	public CrmServices clickOnCreateAccount() throws IOException {
		Common.clickLink("link", pageObj.getPageObjects().getProperty("crm_accounts_creataccountlink"),  wd);
		Log.info("create account page open sucessfully");
		return this;
	}
	
	public CrmServices insertTextOnName(String name ) throws IOException {
		Common.insertText("name", pageObj.getPageObjects().getProperty("crm_accounts_name"), name, wd);
		return this;
	}
	
	public CrmServices insertTextOnEmail(String email ) throws IOException {
		Common.insertText("css", pageObj.getPageObjects().getProperty("crm_accounts_emailcss"), email, wd);
		return this;
	}
	
	public CrmServices selectDropDownPhone(String phone_item ,String phone_dropdown) throws IOException {
		Common.SelectDropDownItem("css",  pageObj.getPageObjects().getProperty("crm_accounts_phonecss"), phone_item, phone_dropdown, wd);
		return this;
	}
	
	public CrmServices insertTextOnMobile() throws IOException {
		//String str;
		//str = Integer.toString(mobileno);
		Common.insertText("css", pageObj.getPageObjects().getProperty("Crm_accounts_mobilecss"), "8093360402", wd);
		return this;
	} 
	
	public CrmServices insertTextOnWebsite(String website) throws IOException {
		Common.insertText("name", pageObj.getPageObjects().getProperty("crm_accounts_websitename"), website, wd);
		return this;
	}
	
	public CrmServices insertTextOnBillingStreet(String addresss) throws IOException {
		Common.insertText("name", pageObj.getPageObjects().getProperty("crm_accounts_BillingAddress_streetname"),addresss , wd);
		return this;
	}
	public CrmServices insertTextOnBillingCity(String city) throws IOException {
		Common.insertText("name", pageObj.getPageObjects().getProperty("crm_accounts_BillingAddress_citytname"), city, wd);
		return this;
	}
	public CrmServices insertTextOnBillingState(String state) throws IOException {
		Common.insertText("name", pageObj.getPageObjects().getProperty("crm_accounts_BillingAddress_statetname"), state, wd);
		return this;
	}
	public CrmServices insertTextOnBillingPostalCode() throws IOException {
		Common.insertText("name", pageObj.getPageObjects().getProperty("crm_accounts_BillingAddress_postalcodename"), "504030", wd);
		return this;
	}
	public CrmServices insertTextOnBillingCountry(String country) throws IOException {
		Common.insertText("name", pageObj.getPageObjects().getProperty("crm_accounts_BillingAddress_countryname"), country, wd);
		return this;
	}
	
	public CrmServices clickOnCopyBilling() throws IOException {
		Common.clickButton("css", pageObj.getPageObjects().getProperty("crm_accounts_copyBillingcss"), wd);
		return this;
		
	}
	
	public CrmServices selectDropDownType(String type_item, String type_dropdown) throws IOException {
		Common.SelectDropDownItem("css",  pageObj.getPageObjects().getProperty("crm_accounts_Details_Typecss"), type_item, type_dropdown, wd);
		return this;
	}
	
	public CrmServices insertTextOnDetailsSiccode() throws IOException {
		Common.insertText("name", pageObj.getPageObjects().getProperty("crm_accounts_Details_Siccodename"),"12345", wd);
	    return this;
}
	
	public CrmServices selectDropDownIndustry(String industry_item,String industry_dropdown) throws IOException {
		Common.SelectDropDownItem("css",  pageObj.getPageObjects().getProperty("crm_accounts_Details_industrycss"), industry_item, industry_dropdown, wd);
		return this;
	}
	
	public CrmServices insertTextOnDescription(String description) throws IOException {
		Common.insertText("css", pageObj.getPageObjects().getProperty("crm_accounts_Details_Descriptioncss"), description, wd);
		return this;
	}
	
	public CrmServices clickOnSaveButton() throws IOException {
		Common.clickButton("css", pageObj.getPageObjects().getProperty("Crm_accounts_savebuttoncss"),  wd);
		Log.info("Account created successfully");
		return this;	
	}
	
	//validation methods starts
	public String getCreateAccountNameFromAccountPage() throws IOException, InterruptedException {
		Common.wait(2);
		String name = Common.getText("css",pageObj.getPageObjects().getProperty("crm_createaccountpage_css"), wd);
		System.out.println(name);
		return name;
	}
	
	public String getCreateAccountEmailFromAccountPage() throws IOException {
		String email = Common.getText("link", pageObj.getPageObjects().getProperty("crm_createaccountpage_emaillink"), wd);
		System.out.println(email);
		return email;
	}
	
	public String getCreateAccountPhoneFromAccountPage() throws IOException {
		String phone = Common.getText("link", pageObj.getPageObjects().getProperty("crm_createaccountpage_phonelink"), wd);
		System.out.println(phone);
		return phone;
	} 
	
	public String getCreateAccountWebsiteFromAccountPage() throws IOException {
		String website = Common.getText("link", pageObj.getPageObjects().getProperty("crm_createaccountpage_websitelink"), wd);
		System.out.println(website);
		return website;
	} 
	
	public String getCreateAccountBillingAddressFromAccountPage() throws IOException {
		String billingaddress = Common.getText("css", pageObj.getPageObjects().getProperty("crm_createaccountpage_billingAddresscss"), wd);
		System.out.println(billingaddress);
		return billingaddress;
	} 
	
	public String getCreateAccountDetailsTypeFromAccountPage() throws IOException {
		String type = Common.getText("css", pageObj.getPageObjects().getProperty("crm_createaccountpage_DetailsTypecss"), wd);
		System.out.println(type);
		return type;
	}
	
	public String getCreateAccountDetailsSiccodeFromAccountPage() throws IOException {
		String siccode = Common.getText("css", pageObj.getPageObjects().getProperty("crm_createaccountpage_DetailsSiccodecss"), wd);
		System.out.println(siccode);
		return siccode;
	}
	
	public String getCreateAccountDetailsIndustryFromAccountPage() throws IOException {
		String industry = Common.getText("css", pageObj.getPageObjects().getProperty("crm_createaccountpage_DetailsIndustrycss"), wd);
		System.out.println(industry);
		return industry;
	}
	
	public String getCreateAccountDetailsDescriptionFromAccountPage() throws IOException, InterruptedException {
		String description = Common.getText("css", pageObj.getPageObjects().getProperty("crm_createaccountpage_DetailsDescriptioncss"), wd);
		System.out.println(description);
		Common.wait(2);
		Log.info("Account validate successfully");
		return description;
	//upto this validation method	
	}
	
	//editing the create account page
   public CrmServices clickOnEditButton() throws IOException {
	   Common.clickButton("css",pageObj.getPageObjects().getProperty("crm_creataccountpage_editcss"), wd);
	   return this;
   }
   
   public CrmServices editOnEmail() throws IOException {
	   Common.editText("css", pageObj.getPageObjects().getProperty("crm_createaccountpage_edit_emailcss"), "sandeep.ideal22@gmail.com", wd);
	   return this;
	   
   }
   
   public CrmServices clickOnSaveButtonAfterEdit() throws IOException, InterruptedException {
	   Common.clickButton("css", pageObj.getPageObjects().getProperty("crm_createaccountpage_edit_savecss"), wd);
	   Common.wait(2);
	   Log.info("Account edited succesfully");
	   return this;
   }
   
   //remove the created account
   public CrmServices clickOnRemoveButton() throws IOException {
	   Common.clickButton("css", pageObj.getPageObjects().getProperty("crm_remove_createaccount_dropdowncss"),  wd);
	   Common.clickLink("link",pageObj.getPageObjects().getProperty("crm_removelink"), wd);
	   Common.clickButton("css", pageObj.getPageObjects().getProperty("crm_remove_confirm_button"), wd);
	   return this;
   }
   
   //create contacts
   public CrmServices navigateToContacts() throws IOException {
	   Common.clickLink("link",pageObj.getPageObjects().getProperty("crm_dashboard_contactlink"), wd);
	return this;
   }
   
   public CrmServices clickOncreateContacts() throws IOException {
	   Common.clickLink("link", pageObj.getPageObjects().getProperty("crm_contacts_creatcontactlink"), wd);
	   return this;
   }
   
   public CrmServices selectdropdownname(String name_item, String name_dropdown) throws IOException {
	   Common.SelectDropDownItem("css", pageObj.getPageObjects().getProperty("crm_contacts_name_dropdowncss"), name_item, name_dropdown, wd);
	   return this;
   }
   
   public CrmServices insertTextOnFirstName(String firstname) throws IOException {
	   Common.insertText("name", pageObj.getPageObjects().getProperty("crm_contacts_firstnamename"), firstname, wd);
	   return this;
   }
   
   public CrmServices insertTextOnLastName(String lastname) throws IOException {
	   Common.insertText("name", pageObj.getPageObjects().getProperty("crm_contacts_lastname"), lastname, wd);
	   return this;
   }
   
   public CrmServices clickOnAccountUpArrow() throws IOException {
	  Common.clickButton("css", pageObj.getPageObjects().getProperty("crm_contacts_accounts_uparrowcss"), wd);
	  Common.clickCheckBox("css", pageObj.getPageObjects().getProperty("crm_contacts_accounts_chechboxcss"), wd);
	//  Common.clickButton("css", pageObj.getPageObjects().getProperty("crm_contacts_accounts_dropdownbuttoncss"), wd);
	//  Common.clickLink("link", pageObj.getPageObjects().getProperty("crm_contacts_accounts_recentlycreatedlink"), wd);
	  Common.clickButton("css", pageObj.getPageObjects().getProperty("crm_contacts_accounts_savebuttoncss"), wd);
	  return this;
   }
   
   public CrmServices insertTextOnContactsEmail(String email) throws IOException {
	   Common.insertText("css", pageObj.getPageObjects().getProperty("crm_contacts_emailcss"), email, wd);
	   return this;
   }
   
   public CrmServices selectDropDownContactsphone(String ph_item, String ph_dropdown) throws IOException {
	  Common.SelectDropDownItem("css", pageObj.getPageObjects().getProperty("crm_contacts_phone_dropdowncss"), ph_item, ph_dropdown, wd);
	   return this;   
	}
   
   public CrmServices insertTextOnContactsMobile() throws IOException {
	   Common.insertText("css", pageObj.getPageObjects().getProperty("crm_contacts_mobilecss"), "7019997037", wd);
	return this;
   }
   
   public CrmServices insertTextOnAddressStreet(String street) throws IOException {
	   Common.insertText("name", pageObj.getPageObjects().getProperty("crm_contacts_addresss_streetname"), street, wd);   
	return this;
   }
   
   public CrmServices insertTextOnAddressCity(String city) throws IOException {
	   Common.insertText("name", pageObj.getPageObjects().getProperty("crm_contacts_addresss_cityname"), city, wd);   
	return this;
   }
   
   public CrmServices insertTextOnAddressState(String state) throws IOException {
	   Common.insertText("name", pageObj.getPageObjects().getProperty("crm_contacts_addresss_statename"), state, wd);   
	return this;
   }
   
   public CrmServices insertTextOnAddressPostalCode() throws IOException {
	   Common.insertText("name", pageObj.getPageObjects().getProperty("crm_contacts_addresss_postalcodename"), "22222", wd);   
	return this;
   }
   
   public CrmServices insertTextOnAddressCountry(String country) throws IOException {
	   Common.insertText("name", pageObj.getPageObjects().getProperty("crm_contacts_addresss_countryname"), country, wd);   
	return this;
   }
   
   public CrmServices insertTextOnAddressDescription(String description) throws IOException {
	   Common.insertText("css", pageObj.getPageObjects().getProperty("crm_contacts_descriptionname"), description, wd);   
	return this;
   }
   
   public CrmServices clickOnContactsSaveButton() throws IOException {
	   Common.clickButton("css", pageObj.getPageObjects().getProperty("crm_contacts_savebuttoncss"), wd);
	return this;
   }
   
   //contacts validation
   public String getCreateContactsNamefromContactPage() throws IOException {
	   String name = Common.getText("css", pageObj.getPageObjects().getProperty("crm_createcontactpage_namecss"), wd);
	   System.out.println(name);
	return name;
   }
   
   public String getCreateContactsEmailfromContactPage() throws IOException {
	   String email = Common.getText("link", pageObj.getPageObjects().getProperty("crm_createcontactpage_emaillink"), wd);
	   System.out.println(email);
	return email;
   }
   
   public String getCreateContactsphonefromContactPage() throws IOException {
	   String phone = Common.getText("link", pageObj.getPageObjects().getProperty("crm_createcontactpage_phonelink"), wd);
	   System.out.println(phone);
	return phone;
   }
   
   //edit create contact page
   public CrmServices clickOnContactsEditButton() throws IOException {
	   Common.clickButton("css", pageObj.getPageObjects().getProperty("crm_createcontactpage_editcss"), wd);
	return this;
   }
   
   public CrmServices editContactsEmail() throws IOException {
	   Common.editText("css", pageObj.getPageObjects().getProperty("crm_createcontactpage_edit_emailcss"), "sandeep.ideal22@gmail.com", wd);
	return this;
   }
   
   public CrmServices clickOnContactsSaveButtonAfterEdit() throws IOException, InterruptedException {
	   Common.clickButton("css", pageObj.getPageObjects().getProperty("crm_createcontactpage_edit_savebuttoncss"), wd);
	   Common.wait(2);
	return this;
   }
   
   //remove the created contact
   public CrmServices clickOnContactRemoveButton() throws IOException {
	   Common.clickButton("css", pageObj.getPageObjects().getProperty("crm_createcontact_remove_dropdowncss"), wd);
	   Common.clickLink("link", pageObj.getPageObjects().getProperty("crm_createcontact_removelink"), wd);
	   Common.clickButton("css", pageObj.getPageObjects().getProperty("crm_createcontact_remove_confirm_buttoncss"), wd);
	return this;
	   
   }
}

