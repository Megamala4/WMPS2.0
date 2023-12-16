package com_1.Master_Creation_Updated;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.Master_Xpaths;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_07_Customer_Master extends BaseClass
{

	@org.testng.annotations.Test
	public static void Customer() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);
		HomePage hp=new HomePage(driver);
		Common_Xpath cxp=new Common_Xpath(driver);
		PWO_Xpath p=new PWO_Xpath(driver);
		DataFields df=new DataFields(driver);
		Master_Xpaths mp =new Master_Xpaths(driver);

		WMPS_Login("441111","Password");
		mp.Master_Click();
		mp.Customer_Master();
			
		int rowcount = xls.getRowCount("Customer");
		System.out.println(rowcount);
		for(int i=2; i<=rowcount;i++)
		{ 
			String InitiatorPassword =xls.getCellData("Changable_Data", "InitiatorPassword", i);
			String Customer_Name =xls.getCellData("Customer", "Customer_Name", i);
			String Street =xls.getCellData("Customer", "Street", i);
			String Street1 =xls.getCellData("Customer", "Street1", i);
			String Street2 =xls.getCellData("Customer", "Street2", i);
			String Country =xls.getCellData("Customer", "Country", i);
			String State =xls.getCellData("Customer", "State", i);
			String City =xls.getCellData("Customer", "City", i);
			String PostalCode =xls.getCellData("Customer", "PostalCode", i);	
			String Remarks =xls.getCellData("Customer", "Remarks", i);	
			
			
//			String Street =xls.getCellData("Vendor_Supplier", "Street", i);
//			String Street1 =xls.getCellData("Vendor_Supplier", "Street1", i);
//			String Street2 =xls.getCellData("Vendor_Supplier", "Street2", i);
//			String City =xls.getCellData("Vendor_Supplier", "City", i);	
//			String Postal_Code =xls.getCellData("Vendor_Supplier", "Postal_Code", i);	
//			String Country =xls.getCellData("Vendor_Supplier", "Country", i);	
//			String State =xls.getCellData("Vendor_Supplier", "State", i);
			
			
		w.Create();
		w.CustomerName(Customer_Name);
		w.Street(Street);
		w.Street1(Street1);
		w.Street2(Street2);
		w.Country(Country);
		w.State(State);
		w.CityId(City);	
		mp.postalSend(PostalCode);Thread.sleep(2000);
		w.Remarks(Remarks);
		w.Save();w.Yes();w.Password_Fill(InitiatorPassword);
		//w.SubmitType_1();w.Ok();driver.close();
	}}}



