package T3_Transaction_ReInitiate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.Master_Xpaths;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;

public class TC_06_Product_Requirement_ReInitiate extends BaseClass {

	@org.testng.annotations.Test
	public static void Material_Master() throws Exception {
		WMPS_OBJECT w = new WMPS_OBJECT(driver);
		Master_Xpaths mp = new Master_Xpaths(driver);
		Actions actions = new Actions(driver);

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for (int i = 2; i <= 2; i++) {
			String MaterialMasterSFP = xls.getCellData("Excel_Data", "MaterialMasterSFP", i);
			String InitiatorPassword = xls.getCellData("Changable_Data", "InitiatorPassword", i);

			String Material_Description_RawMaterial = xls.getCellData("Excel_Data", "Material_Description", i);

			String Material_Description = xls.getCellData("Excel_Data", "Material_Description",i);// **************
			String MaterialMasterRM = xls.getCellData("Excel_Data", "MaterialMasterRM",i);

			String Market = xls.getCellData("Changable_Data", "Market", i);

			String Password = xls.getCellData("Changable_Data", "Password", i);
			String WrongPassword = xls.getCellData("Changable_Data", "WrongPassword", i);
			String Stage = xls.getCellData("Material_Master", "Stage", i);

			// DataMapping
			String Vendor_Name_Manufacturer = xls.getCellData("Excel_Data", "Vendor_Name_Manufacturer", i);// *************

			WMPS_Login("Initiator", "Initiator_Password");

			WebElement MoveCursor = driver.findElement(By.xpath("//*[text()='Masters']"));
			Thread.sleep(2000);
			actions.moveToElement(MoveCursor).perform();
			Thread.sleep(1000);
			mp.Master_Click();
			mp.Product_Requirement();
			w.Edit_Action_Button();
			Select manufactureName = new Select(
					driver.findElement(By.xpath("//*[@formcontrolname='manufactureName']")));
			manufactureName.selectByVisibleText(Vendor_Name_Manufacturer);
			Thread.sleep(2000);
			Select marketName = new Select(driver.findElement(By.xpath("//*[@formcontrolname='marketName']")));
			// marketName.selectByValue(Market);
			marketName.selectByVisibleText("UNITED KINGDOM");
			Thread.sleep(2000);// Excel data
			Thread.sleep(2000);
			Thread.sleep(2000);
			Thread.sleep(2000);
			w.Remarks(Material_Description);
			w.Add_Button();
			w.CheckBox_2();
			w.Update_Button();
			w.Yes();
			w.Password_Fill("321");
			w.SubmitType_1();
			w.Ok();

		}
	}
}
