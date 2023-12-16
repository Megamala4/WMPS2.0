package DataField;

import org.openqa.selenium.By;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_14_Rounding extends BaseClass
{

	@org.testng.annotations.Test
	public static void Ordertypr() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);
		HomePage hp=new HomePage(driver);
		Common_Xpath cxp=new Common_Xpath(driver);
		PWO_Xpath p=new PWO_Xpath(driver);
		DataFields df=new DataFields(driver);

		WMPS_Login("Initiator","Password");
		w.Menu();
		driver.findElement(By.xpath("(//*[contains(text(),'Rounding')])[1]")).click();

		w.Create();
		df.Rounding_SK("Internal_Procurement");//Data
		
		w.Submit();
		E_Signature("Password");

		w.SearchBox("Internal_Procurement");//Data
		w.Edit_Action_Button();
		df.Rounding_SK("Internal_Procurement01"); //Edited_Data
		Update("Password");

		w.SearchBox("Internal_Procurement01");//Edited_Data
		Disable("Password");
		
		w.SearchBox("Internal_Procurement01");///Edited_Data
		Enable("Password");
		
		w.Create();
		df.Rounding_SK("Internal_Procurement01"); //Edited_Data
		w.Submit();
		w.Cross_Close_Button();
		
		driver.close();


	}





}
