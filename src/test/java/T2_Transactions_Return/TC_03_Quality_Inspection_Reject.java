package T2_Transactions_Return;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_03_Quality_Inspection_Reject extends BaseClass
{

	@org.testng.annotations.Test
	public static void Ordertypr() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)
			
		{ 	
			String AR_Number_I =xls.getCellData("Dependency", "AR_Number_I", i);					

			
			
			//String AR_Number_I =xls.getCellData("Quality_Inspection", "AR_Number_I", i);
			String AR_Number_II =xls.getCellData("Quality_Inspection", "AR_Number_II", i);
			String AR_Number_III =xls.getCellData("Quality_Inspection", "AR_Number_III", i);
			String BatchNoFromGoodRecipt =xls.getCellData("VVI", "BatchNoFromGoodRecipt", i);			
			String Material_Description =xls.getCellData("Excel_Data", "Material_Description", i);

String InitiatorPassword =xls.getCellData("Changable_Data", "InitiatorPassword", i);
String ApproverPassword=xls.getCellData("Changable_Data", "ApproverPassword", i);
String WrongPassword =xls.getCellData("Changable_Data", "WrongPassword", i);

			WMPS_Login_Release("441122","ApproverPassword");			
			w.Second_Level();	
			w.ReviewApprovalCategory("Quality Inspection Release");			
			w.Search_Button();	
			//w.SearchBox("AR00");
			Thread.sleep(2000);Thread.sleep(2000);
			w.USDE(); 		
			w.ActionLevelApproverAction("Reject");
			w.Comments("Quality_Inspection_Reject");Thread.sleep(2000);			
			w.Submit();w.Yes();Thread.sleep(2000);
			w.Password_Fill(ApproverPassword);
			//w.SubmitType_1();w.Ok();driver.close();
		}}}
