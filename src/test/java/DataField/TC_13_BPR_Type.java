package DataField;

import org.openqa.selenium.By;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_13_BPR_Type extends BaseClass
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
		driver.findElement(By.xpath("(//*[contains(text(),'BPR Type')])[1]")).click();

		w.Create();
		df.BPR_Type_SK("Internal_Validation");//Data
		
		w.Submit();
		E_Signature("Password");

		w.SearchBox("Internal_Validation");//Data
		w.Edit_Action_Button();
		df.BPR_Type_SK("Internal_Procureee"); //Edited_Data
		Update("Password");

		w.SearchBox("Internal_Procureee");//Edited_Data
		Disable("Password");
		
		w.SearchBox("Internal_Procureee");///Edited_Data
		Enable("Password");
		
		w.Create();
		df.BPR_Type_SK("Internal_Procureee"); //Edited_Data
		w.Submit();
		w.Cross_Close_Button();
		
		driver.close();


	}





}
