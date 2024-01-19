package T1_Transactions_Positive;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.Master_Xpaths;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;

public class TC_04_Quality_Inspection_for_1_Batch extends BaseClass {

	@org.testng.annotations.Test
	public static void Quality_Inspection() throws Exception {
		WMPS_OBJECT w = new WMPS_OBJECT(driver);
		HomePage hp = new HomePage(driver);
		Common_Xpath cxp = new Common_Xpath(driver);
		PWO_Xpath p = new PWO_Xpath(driver);
		DataFields df = new DataFields(driver);
		Master_Xpaths mp = new Master_Xpaths(driver);
		// ***************************************************************************************************************
		// ***************************************************************************************************************
		WMPS_Login("Initiator", "Initiator_Password");
		w.Quality_Control();
		w.Quality_Inspection();
		// ***************************************************************************************************************
		// ***************************************************************************************************************

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for (int i = 2; i <= 2; i++) {
			// ***************************************************************************************************************
			// ***************************************************************************************************************
			// ***************************************************************************************************************
			// Unique First AR Number in Raw Material Flow
			String AR_Number_I = xls.getCellData("Dependency", "AR_Number_I", i);
			// **************************************************************************************************************
			// **************************************************************************************************
			// **************************************************************************************************	
			String MaterialMasterRM = xls.getCellData("Excel_Data", "MaterialMasterRM", i);
			String MaterialMasterRM_Edit = xls.getCellData("Excel_Data", "MaterialMasterRM_Edit", i);
			// **************************************************************************************************	
			// **************************************************************************************************
			String Vendor_Name_Manufacturer = xls.getCellData("Excel_Data", "Vendor_Name_Manufacturer", i);
			String Vendor_Name_Supplier = xls.getCellData("Excel_Data", "Vendor_Name_Supplier", i);
			// **************************************************************************************************
			String Vendor_Name_Supplier_Edit = xls.getCellData("Excel_Data", "Vendor_Name_Supplier_Edit", i);
			String Vendor_Name_Manufacturer_Edit = xls.getCellData("Excel_Data", "Vendor_Name_Manufacturer_Edit", i);
			// **************************************************************************************************
			// **************************************************************************************************	
			String MaterialMasterSFP = xls.getCellData("Excel_Data", "MaterialMasterSFP", i);
			String MaterialCodeFP = xls.getCellData("Excel_Data", "MaterialCodeFP", i);
			// ***************************************************************************************************************
			// ***************************************************************************************************************
			String Pharmacopoeia = xls.getCellData("Quality_Inspection", "Pharmacopoeia", i);
			String Action = xls.getCellData("Quality_Inspection", "Action", i);
			String Sampled_Quantity = xls.getCellData("Quality_Inspection", "Sampled_Quantity", i);
			String SampledQuantityUOM = xls.getCellData("Quality_Inspection", "SampledQuantityUOM", i);
			// ***************************************************************************************************************
			// ***************************************************************************************************************
			String InitiatorPassword = xls.getCellData("Changable_Data", "InitiatorPassword", i);
			String ApproverPassword = xls.getCellData("Changable_Data", "ApproverPassword", i);
			String WrongPassword = xls.getCellData("Changable_Data", "WrongPassword", i);
			// ***************************************************************************************************************
			w.SearchBox(MaterialMasterRM_Edit);
			w.SMPL();
			w.PharmacopoeiaId(Pharmacopoeia);
			w.ARNumber(AR_Number_I);
			w.Action(Action);
			System.out.println(Action);
			boolean t = driver.findElement(By.xpath("//input[@formcontrolname='SampledQuantity']")).isDisplayed();
			if (t) {
				System.out.println(Action);
				w.SampledQuantity(Sampled_Quantity);
				w.SampledQuantityUOM(SampledQuantityUOM);
			}
			System.out.println(Action);
			boolean tt = driver.findElement(By.xpath("//input[@formcontrolname='SampledQuantity']")).isDisplayed();
			if (tt) {
				System.out.println(Action);
				w.Comments("Quality_Inspection_Passed");
			}
			// w.SampledQuantity(Sampled_Quantity);
			// w.SampledQuantityUOM(SampledQuantityUOM);
			w.Comments("Quality_Inspection_Passed");
			w.Submit();
			w.Yes();
			w.Password_Fill.sendKeys(Pro.getProperty("Initiator_Password"));
			w.SubmitType_1();
			w.Ok();
		}
		// driver.close();
	}
}
