package Transactions_Warehouse;

import org.openqa.selenium.By;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.Master_Xpaths;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_05_Material_Inventory_Updated extends BaseClass
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


		WMPS_Login("441111","Password");
		w.Menu_Navigate();w.Menu_Navigate();

		w.WareHouse();
		w.Material_Inventory();
		w.Create();


		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)
		{ 

			w.SearchBox(Pro.getProperty("Batch_Number"));
			driver.findElement(By.xpath("/html/body/app-root/div/div/app-material-inventory/div/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[2]/span")).click();Thread.sleep(2000); 



		}}}
