package DataField;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_18_State extends BaseClass
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
		driver.findElement(By.xpath("(//*[contains(text(),'State')])[1]")).click();

		w.Create();
		
df.selectCountry_Name_DD();
		
		df.State_SK("Slow_Movement1100");//Data1
		E_Signature("Password");
		
//EDIT DROPDOWN		

		w.SearchBox("Slow_Movement");//Data
		w.Edit_Action_Button();
		df.State_SK("Sl_Movement"); //Edited_Data  
		Update("Password");

		
		
		//FOR DISABLING RECORD		
		
		w.SearchBox("Slow_Movement");//Edited_Data
		Disable("Password");
		

		
	//FOR ENABLING RECORD	
		w.SearchBox("Slow_Movement");///Edited_Data
		Enable("Password");
		

		
		
		
		
		w.Create();
		df.selectCountry_Name_DD();
		df.State_SK("Slow_Movement"); //Edited_Data
		
		w.Submit();
		w.Cross_Close_Button();
		
		driver.close();

	}





}
