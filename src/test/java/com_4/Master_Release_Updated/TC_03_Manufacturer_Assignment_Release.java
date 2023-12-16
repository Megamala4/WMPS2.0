package com_4.Master_Release_Updated;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.Master_Xpaths;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_03_Manufacturer_Assignment_Release extends BaseClass
{

	@org.testng.annotations.Test
	public static void Ordertypr() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);
		HomePage hp=new HomePage(driver);
		Common_Xpath cxp=new Common_Xpath(driver);
		PWO_Xpath p=new PWO_Xpath(driver);
		DataFields df=new DataFields(driver);
		Master_Xpaths mp =new Master_Xpaths(driver);

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)		
		{ 
			String ApproverPassword=xls.getCellData("Changable_Data", "ApproverPassword", i);			

			String Material_Description =xls.getCellData("Excel_Data", "Material_Description", i);
			String Password=xls.getCellData("Changable_Data", "Password", i);
			String Material_Description_RawMaterial =xls.getCellData("Excel_Data", "MaterialDescription_RM", i);

			WMPS_Login_Release("441122","ApproverPassword");			
			w.Second_Level();	
			w.ReviewApprovalCategory("Manufacture Assignment Release");
			w.Search_Button();	
			//w.SearchBox(Material_Description);Thread.sleep(2000);Thread.sleep(2000);
			w.Edit_Action_Button();	
			w.Comments("Manufacture Assignment Released Sucessfully");Thread.sleep(2000);			
			w.ActionLevel("Release");
			w.Submit();w.Yes();w.Password_Fill(ApproverPassword);
			w.SubmitType_2();w.Ok();driver.close();
		}}}
