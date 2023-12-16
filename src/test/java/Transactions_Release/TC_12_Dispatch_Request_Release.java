package Transactions_Release;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.Master_Xpaths;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_12_Dispatch_Request_Release extends BaseClass
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

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)
		{ 

String InitiatorPassword =xls.getCellData("Changable_Data", "InitiatorPassword", i);
String ApproverPassword=xls.getCellData("Changable_Data", "ApproverPassword", i);
String WrongPassword =xls.getCellData("Changable_Data", "WrongPassword", i);

			String Batch_Number =xls.getCellData("Material_Indent", "Batch_number", i);
			WMPS_Login("441122","ApproverPassword");
			Thread.sleep(1500);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			try {
				driver.findElement( By.xpath("//li[@routerlink='/Second-Level-Approval']")).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			Thread.sleep(1500);
			//w.Second_Level();			
			w.ReviewApprovalCategory("Dispatch Request Release");			
			w.Search_Button();
			//w.SearchBox(Batch_Number);
			w.Edit_Action_Button();
			w.Comments("Dispatch_Request_Release");Thread.sleep(2000);
			w.ActionLevelApproverAction("Release");				
			w.Submit();w.Yes();Thread.sleep(2000);
			w.Password_Fill(ApproverPassword);
			w.SubmitType12();w.Ok();
			}}}
