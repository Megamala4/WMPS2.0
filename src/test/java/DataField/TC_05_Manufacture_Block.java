package DataField;

import org.openqa.selenium.By;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_05_Manufacture_Block extends BaseClass
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
			String Manufacture_Block =xls.getCellData("Datafields_ALL", "Manufacture_Block", i);
			String Edit_Manufacture_Block =xls.getCellData("Datafields_ALL", "Edit_Manufacture_Block", i);
			

		WMPS_Login("Initiator","Password");
		w.Menu();
		driver.findElement(By.xpath("//*[contains(text(),'Manufacture Block')]")).click();
		w.Create();
		df.Manufacture_Block_SK(Manufacture_Block);//Data1
		w.Submit();
		E_Signature("Password");

		w.SearchBox(Manufacture_Block);//Data1
		w.Edit_Action_Button();
		df.Manufacture_Block_SK(Edit_Manufacture_Block); //Edited_Data_1
		Update("Password");

		w.SearchBox(Edit_Manufacture_Block);//Edited_Data_1
		Disable("Password");
		
		w.SearchBox(Edit_Manufacture_Block);//Edited_Data_1
		Enable("Password");
		
		w.Create();
		df.Manufacture_Block_SK(Edit_Manufacture_Block); //Edited_Data_1

		w.Submit();
		w.Cross_Close_Button();
		
		//driver.close();

		}}}
