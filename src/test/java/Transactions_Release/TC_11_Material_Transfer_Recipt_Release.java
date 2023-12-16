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


public class TC_11_Material_Transfer_Recipt_Release extends BaseClass
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
			String BOM_BatchNo_II =xls.getCellData("Dependency", "BOM_BatchNo_II", i);

String InitiatorPassword =xls.getCellData("Changable_Data", "InitiatorPassword", i);
String ApproverPassword=xls.getCellData("Changable_Data", "ApproverPassword", i);
String WrongPassword =xls.getCellData("Changable_Data", "WrongPassword", i);

			WMPS_Login_Release("441122","ApproverPassword");			
			w.Second_Level();		
			w.ReviewApprovalCategory("Material Transfer Receipt Release");			

//			Select Review_Approval_Category=new Select(driver.findElement(By.xpath("//*[@formcontrolname='Category']")));
//			Review_Approval_Category.selectByVisibleText("Material Transfer Receipt Release");
			
			w.Search_Button();
			w.SearchBox(BOM_BatchNo_II);
			w.Edit_Action_Button();
			w.Comments("Material_Transfer_Recipt_Release");Thread.sleep(2000);
			Select Action_Level_Select=new Select(driver.findElement(By.xpath("//*[@formcontrolname='status']")));
			
			Action_Level_Select.selectByVisibleText("Release");Thread.sleep(2000);
			w.Submit();w.Yes();Thread.sleep(2000);
			w.Password_Fill(ApproverPassword);
		//	w.SubmitType12();w.Ok(); 
			}}}
