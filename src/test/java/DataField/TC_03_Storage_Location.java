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


public class TC_03_Storage_Location extends BaseClass
{

	@org.testng.annotations.Test
	public static void Ordertypr() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);
		HomePage hp=new HomePage(driver);
		Common_Xpath cxp=new Common_Xpath(driver);
		PWO_Xpath p=new PWO_Xpath(driver);
		DataFields df=new DataFields(driver);
		Actions actions=new Actions(driver);

		WMPS_Login("Initiator","Password");
		int rowcount = xls.getRowCount("Datafields_ALL");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)
		{ 
			
			String Storage_Location =xls.getCellData("Datafields_ALL", "StorageLocation", i);
			String Location_Description =xls.getCellData("Datafields_ALL", "LocationDescription", i);
			String Edit_Storage_Location =xls.getCellData("Datafields_ALL", "StorageLocation", i);
			String Edit_Location_Description =xls.getCellData("Datafields_ALL", "Edit_LocationDescription", i);

			driver.findElement(By.xpath("//*[contains(text(),'Data Fields')]")).click();
			driver.findElement(By.xpath("(//*[contains(text(),'Storage Location')])[1]")).click();

			WebElement MoveCursor = driver.findElement(By.xpath("//*[contains(text(),'Transactions')]"));
			actions.moveToElement(MoveCursor).perform();Thread.sleep(1000);	
			w.Create();
			df.Storage_Location_SK(Storage_Location);//Data_1
			df.Location_Description_SK(Location_Description);//Data_2
			w.Submit();
			E_Signature("Password");

			w.SearchBox(Storage_Location);//Data_1
			w.Edit_Action_Button();
			df.Storage_Location_SK(Edit_Storage_Location);//Edited_Data_1
			df.Location_Description_SK(Edit_Location_Description);//Edited_Data_2
			Update("Password");

			w.SearchBox(Edit_Storage_Location);//Edited_Data_1
			Disable("Password");

			w.SearchBox(Edit_Storage_Location);//Edited_Data_1
			Enable("Password");

			w.Create();
			df.Storage_Location_SK(Edit_Storage_Location);//Edited_Data_1
			df.Location_Description_SK(Edit_Location_Description);//Edited_Data_2

			w.Submit();
			w.Cross_Close_Button();

			
		}
		driver.close();
		}}