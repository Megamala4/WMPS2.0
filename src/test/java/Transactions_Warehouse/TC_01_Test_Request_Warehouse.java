package Transactions_Warehouse;

import org.openqa.selenium.By;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.Master_Xpaths;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_01_Test_Request_Warehouse extends BaseClass
{

	@org.testng.annotations.Test
	public static void Ordertypr() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);
		HomePage hp=new HomePage(driver);
		Common_Xpath cxp=new Common_Xpath(driver);
		PWO_Xpath p=new PWO_Xpath(driver);
		DataFields df=new DataFields(driver);
		Master_Xpaths mp =new Master_Xpaths(driver);

//		WMPS_Login("441111","Password");
//
//		w.Menu_Navigate();
//		w.Transactions();
//		w.WareHouse();
//		w.Test_Request_Warehouse();
//		w.Menu_Navigate();
//		w.Create();

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)
		{ 


		      //application launch
		      driver.get("https://www.tutorialspoint.com/about/about_careers.htm");

		      // getTitle() to obtain page title
		      System.out.println("Page title is : " + driver.getTitle());
		      
		      driver.findElement(By.xpath("(//*[@class='modeswitch-icon'])")).click();
		      driver.close();


		}}}
