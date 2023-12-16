package DataField;

import org.openqa.selenium.By;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_21_Country extends BaseClass
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
		driver.findElement(By.xpath("(//*[contains(text(),'Country')])[1]")).click();
		w.Create();
		df.Country_SK("Wakanda");//Data1
		w.Submit();
		E_Signature("Password");

		w.SearchBox("Wakanda");//Data1
		w.Edit_Action_Button();
		df.Country_SK("TelAndra"); //Edited_Data_1
		Update("Password");

		w.SearchBox("TelAndra");//Edited_Data_1
		Disable("Password");
		
		w.SearchBox("TelAndra");//Edited_Data_1
		Enable("Password");
		
		w.Create();
		df.Country_SK("TelAndra"); //Edited_Data_1

		w.Submit();
		w.Cross_Close_Button();
		
		driver.close();

	}





}
