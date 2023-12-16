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


public class TC_07_Customer_Master_Release extends BaseClass
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
		
			WMPS_Login_Release("441122","ApproverPassword");			
			w.Second_Level();				
			w.ReviewApprovalCategory("Customer_Release");
			w.Search_Button();	
			//w.SearchBox();//Thread.sleep(2000);
			//w.SearchBox(" Created");Thread.sleep(2000);
			w.Edit_Action_Button();			
			w.Comments("Customer_Release");//Thread.sleep(2000);				
			w.ActionLevel("Release");
			w.Submit();w.Yes();w.Password_Fill(ApproverPassword);
			w.SubmitType_1();w.Ok();driver.close();
}}}
