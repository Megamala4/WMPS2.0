package DataField;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_01_Inspection_Type extends BaseClass
{

	@org.testng.annotations.Test
	public static void Ordertypr() throws Exception
	{
		Actions actions = new Actions(driver);
		WMPS_OBJECT w=new WMPS_OBJECT(driver);
		HomePage hp=new HomePage(driver);
		Common_Xpath cxp=new Common_Xpath(driver);
		PWO_Xpath p=new PWO_Xpath(driver);
		DataFields df=new DataFields(driver);


		WMPS_Login("Initiator","Password");

		int rowcount = xls.getRowCount("Datafields_ALL");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)
		{ 
			String Inspection_Type =xls.getCellData("Inspection_Type", "Inspection_Type", i);
			String Inspection_Type_Edit =xls.getCellData("Inspection_Type", "Inspection_Type_Edit", i);	

			driver.findElement(By.xpath("//*[contains(text(),'Data Fields')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Inspection Type')]")).click();
			Thread.sleep(1000);
			
			WebElement MoveCursor = driver.findElement(By.xpath("//*[contains(text(),'Transactions')]"));
			actions.moveToElement(MoveCursor).perform();Thread.sleep(1000);	
			
			w.Create();
			df.Inspection_Type_SK(Inspection_Type);//Data1
			w.Submit();
			E_Signature("Password");
			w.SearchBox(Inspection_Type);//Data1
			w.Edit_Action_Button();
			df.Inspection_Type_SK(Inspection_Type_Edit);//Edited_Data_1
			Update("Password");
			w.SearchBox(Inspection_Type_Edit);//Edited_Data_1
			Disable("Password");
			w.SearchBox(Inspection_Type_Edit);//Edited_Data_1
			Enable("Password");
			w.Create();
			df.Inspection_Type_SK(Inspection_Type_Edit); //Edited_Data_1
			w.Submit();
			w.Cross_Close_Button();
		}
			driver.close();
	}
}
