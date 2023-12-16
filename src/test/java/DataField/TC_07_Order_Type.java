package DataField;

import org.openqa.selenium.By;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_07_Order_Type extends BaseClass
{

	@org.testng.annotations.Test
	public static void Ordertypr() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);
		HomePage hp=new HomePage(driver);
		Common_Xpath cxp=new Common_Xpath(driver);
		PWO_Xpath p=new PWO_Xpath(driver);
		DataFields df=new DataFields(driver);

		
		int rowcount = xls.getRowCount("Datafields_ALL");
		System.out.println(rowcount);
		for(int i=2; i<=rowcount;i++)
		{ 
			String Order_Type =xls.getCellData("Datafields_ALL", "Order_Type", i);
			String Edit_Order_Type =xls.getCellData("Datafields_ALL", "Edit_Order_Type", i);
			
		WMPS_Login("Initiator","Password");
		w.Menu();
		driver.findElement(By.xpath("(//*[contains(text(),'Order Type')])")).click();

		w.Create();
		df.Order_Type_SK(Order_Type);//Data
		
		w.Submit();
		E_Signature("Password");

		w.SearchBox(Order_Type);//Data
		w.Edit_Action_Button();
		df.Order_Type_SK(Edit_Order_Type); //Edited_Data
		Update("Password");

		w.SearchBox(Edit_Order_Type);//Edited_Data
		Disable("Password");
		
		w.SearchBox(Edit_Order_Type);//Edited_Data
		Enable("Password");

	}

	}



}
