package Transactions_Release;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.Master_Xpaths;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_08_Quality_Inspection_Release_Approve extends BaseClass
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

			WMPS_Login_Release("441122","ApproverPassword");			
			w.Menu_Navigate();w.Menu_Navigate();
			w.Second_Level();			
			w.ReviewApprovalCategory("Quality Inspection Release");			
			w.Search_Button();
			//w.SearchBox("");
			w.USDE();		
			w.ActionLevelApproverAction("Approve");
			//Manually Dates
			w.ExpiryDate("14122023");
			Thread.sleep(3000);Thread.sleep(3000);
			Thread.sleep(3000);
			Thread.sleep(3000);
			w.Comments("Quality_Inspection_Release");Thread.sleep(2000);
			w.Submit();w.Yes();Thread.sleep(2000);
			w.Password_Fill(ApproverPassword);
			//w.SubmitType_1();w.Ok();

			



		}}}
