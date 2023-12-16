package com_1.Master_Creation_Updated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.Master_Xpaths;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_06_Product_Requirement2 extends BaseClass
{

	@org.testng.annotations.Test
	public static void Material_Master() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);
		Master_Xpaths mp =new Master_Xpaths(driver);
		Actions actions = new Actions(driver);

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)
		{ 		
			String MaterialMasterRM =xls.getCellData("Excel_Data", "MaterialMasterRM", i);	
			String InitiatorPassword =xls.getCellData("Changable_Data", "InitiatorPassword", i);

			String Material_Description_RawMaterial =xls.getCellData("Excel_Data", "Material_Description", i);	
			
			String Material_Description =xls.getCellData("Excel_Data", "Material_Description", i);//**************
			String MaterialMasterFP =xls.getCellData("Excel_Data", "MaterialMasterFP", i);
		
			String Password =xls.getCellData("Changable_Data", "Password", i);
			String WrongPassword =xls.getCellData("Changable_Data", "WrongPassword", i);
			String Stage =xls.getCellData("Material_Master", "Stage", i);

//DataMapping
			String Vendor_Name_Manufacturer =xls.getCellData("Excel_Data", "Vendor_Name_Manufacturer", i);//*************

			WMPS_Login("441111","Password");Thread.sleep(2000);
			
			WebElement MoveCursor = driver.findElement(By.xpath("//*[text()='Masters ']"));Thread.sleep(2000);
			actions.moveToElement(MoveCursor).perform();Thread.sleep(1000);	

			mp.Master_Click();
			
			mp.Product_Requirement();
			
			w.Create();
			
			w.TT_1(MaterialMasterFP);
			Thread.sleep(2000);
						
			Select Review_Approval_Category=new Select(driver.findElement(By.xpath("//*[@formcontrolname='stage']")));
			Review_Approval_Category.selectByVisibleText("2");
						
			
			
			w.TT_2(MaterialMasterRM);
			
//			Select manufactureName=new Select(driver.findElement(By.xpath("//*[@formcontrolname='manufactureName']")));
//			manufactureName.selectByVisibleText(Vendor_Name_Manufacturer);Thread.sleep(2000);	
//						
//			Thread.sleep(2000);Thread.sleep(2000);
			
			
//			Select marketName=new Select(driver.findElement(By.xpath("//*[@formcontrolname='marketName']")));
//			marketName.selectByVisibleText(" INDIA");Thread.sleep(2000);//Excel data
			
			
			//driver.findElement(By.xpath("//*[@formcontrolname='marketName']")).click();
//			driver.findElement(By.xpath("//*[@formcontrolname='marketName']")).sendKeys("INDIA");
			//driver.findElement(By.xpath("//*[@formcontrolname='marketName']")).click();
			w.ManufactureName(Vendor_Name_Manufacturer);				
			w.MarketName("INDIA");//we can take from excel too
			w.Add_Button();
			w.ManufactureName(Vendor_Name_Manufacturer);
			w.MarketName("UNITED KINGDOM");
			w.Add_Button();
			w.ManufactureName(Vendor_Name_Manufacturer);
			w.MarketName("UNITED STATES");
			w.Add_Button();
			
		//	w.Add_Button();
			w.CheckBox_1();
			w.CheckBox_2();
			w.CheckBox_3();
			w.Submit();
			w.Yes();
			w.Password_Fill(Password);
			//w.Submit_Type();w.Ok();

			
			
		}}}
