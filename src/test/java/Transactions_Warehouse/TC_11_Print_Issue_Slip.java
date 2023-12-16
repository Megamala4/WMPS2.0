package Transactions_Warehouse;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.Master_Xpaths;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_11_Print_Issue_Slip extends BaseClass
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
		w.Print_Issue_Slip();
		
		
		driver.findElement(By.xpath("/html/body/app-root/div/div/app-tblprintissueslip/div/div[2]/div/div/div/div/table/tbody/tr[1]/td[2]")).click();

		Select Review_Approval_Category=new Select(driver.findElement(By.xpath("//*[@class='form-control ng-untouched ng-pristine ng-valid']")));
		
		Review_Approval_Category.selectByIndex(1);
		
		w.Preview();
		w.Cross_Close_Button();
		w.Print_Button();
		
		w.Yes();Thread.sleep(2000);
		w.Password_Fill("321");
		w.Submit_Text();w.Ok();
		Close_Opened_File();

		
		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)
		{ 




		}}}
