package Configurations;

import org.openqa.selenium.By;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class Assign_Stor_Loc_To_WH extends BaseClass
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
		
		driver.findElement(By.xpath("(//*[contains(text(),'Assign Stor. Loc. To WH')])[1]")).click();
		w.Create();
		
		

		
		driver.close();

	}





}
