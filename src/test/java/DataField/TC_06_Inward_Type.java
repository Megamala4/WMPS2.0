package DataField;

import org.openqa.selenium.By;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_06_Inward_Type extends BaseClass
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
			String Inward_Type =xls.getCellData("Datafields_ALL", "Inward_Type", i);
			String Edit_Inward_Type =xls.getCellData("Datafields_ALL", "Edit_Inward_Type", i);

		WMPS_Login("Initiator","Password");
		w.Menu();
		driver.findElement(By.xpath("(//*[contains(text(),'Inward Type')])[1]")).click();
		w.Create();
		df.Inward_Type_SK(Inward_Type);//Data1
		w.Submit();
		E_Signature("Password");

		w.SearchBox(Inward_Type);//Data1
		w.Edit_Action_Button();
		df.Inward_Type_SK(Edit_Inward_Type); //Edited_Data_1
		Update("Password");

		w.SearchBox(Edit_Inward_Type);//Edited_Data_1
		Disable("Password");
		
		w.SearchBox(Edit_Inward_Type);//Edited_Data_1
		Enable("Password");
		
		w.Create();
		df.Inward_Type_SK(Edit_Inward_Type); //Edited_Data_1

		w.Submit();
		w.Cross_Close_Button();
		
		driver.close();

	}
	}




}
