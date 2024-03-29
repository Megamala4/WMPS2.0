package T1_Transactions_Positive;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.Master_Xpaths;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_16_Batch_Process_Closure2 extends BaseClass
{

	@org.testng.annotations.Test
	public static void Bill_Of_Material() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);
		HomePage hp=new HomePage(driver);
		Common_Xpath cxp=new Common_Xpath(driver);
		PWO_Xpath p=new PWO_Xpath(driver);
		DataFields df=new DataFields(driver);
		Master_Xpaths mp =new Master_Xpaths(driver);

		WMPS_Login("441111","Password");
		w.Production();
		w.Batch_Process_Closure();
		w.Create();

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)			
		{ 
			String MaterialMasterFP=xls.getCellData("Excel_Data", "MaterialMasterFP", i);//New Semifinished Material Upper Part		
			String Batch_Number_II =xls.getCellData("Dependency", "Batch_Number_II", i);

			String InitiatorPassword =xls.getCellData("Changable_Data", "InitiatorPassword", i);
			String ApproverPassword=xls.getCellData("Changable_Data", "ApproverPassword", i);
			String WrongPassword =xls.getCellData("Changable_Data", "WrongPassword", i);



			w.TT_4_AD_E(MaterialMasterFP);
			w.TT_7_AD_E(Batch_Number_II);

			w.Remarks("Okay");
			w.Submit();w.Yes();
			w.Password_Fill(InitiatorPassword);
			//w.SubmitType12();w.Ok();    
		}}}
