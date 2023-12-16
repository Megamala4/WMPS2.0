package com_3.Master_ReInitiate_Updated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.pageobjects.Master_Xpaths;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_01_Material_Master_ReInitiate extends BaseClass
{

	@org.testng.annotations.Test
	public static void Ordertypr() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);
		Master_Xpaths mp =new Master_Xpaths(driver);
		Actions actions = new Actions(driver);

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)
		{ 
			
			String MaterialCodeSFP 	=xls.getCellData("Excel_Data", "MaterialCodeSFP", i);//Change
			String InitiatorPassword =xls.getCellData("Changable_Data", "InitiatorPassword", i);
			String WrongPassword =xls.getCellData("Changable_Data", "WrongPassword", i);
			
			String MaterialMasterSFP_LongDescription 	=xls.getCellData("Excel_Data", "MaterialMasterSFP_LongDescription", i);

			WMPS_Login("441111","Password");Thread.sleep(2000);
			WebElement MoveCursor = driver.findElement(By.xpath("//*[text()='Masters ']"));Thread.sleep(2000);
			actions.moveToElement(MoveCursor).perform();Thread.sleep(1000);	
			mp.Master_Click();
			mp.Material_Master();			
			//w.SearchBox(Material_Description);
			w.Edit_Action_Button();
			//mp.Material_Code_SK(MaterialCodeSFP);			
//			mp.Material_Description_SK(Material_Description_Edit);
//			mp.Material_Long_Description_SK(Material_Long_Description_Edit);
			mp.Material_Long_Description_SK("Edit");

			w.Remarks("ReInitiate the record");
			w.Submit();w.Yes();w.Password_Fill(InitiatorPassword);
	//	w.SubmitType_1();w.Ok();
		}}}
