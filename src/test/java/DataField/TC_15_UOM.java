

package DataField;

import org.openqa.selenium.By;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_15_UOM extends BaseClass
{

	@org.testng.annotations.Test
	public static void Ordertypr() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);
		HomePage hp=new HomePage(driver);
		Common_Xpath cxp=new Common_Xpath(driver);
		PWO_Xpath p=new PWO_Xpath(driver);
		DataFields df=new DataFields(driver);

		int rowcount = xls.getRowCount("Df_Material_Type");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)
		{ 
			String MaterialType = xls.getCellData("Df_Material_Type", "Material_type", i);
			String Material_Type_Edit =xls.getCellData("Df_Material_Type", "Material_Type_Edit", i);
			String TypeCode =xls.getCellData("Df_Material_Type", "Type_Code", i);

			WMPS_Login("Initiator","Password");
			w.Menu();
			driver.findElement(By.xpath("(//*[contains(text(),'UOM')])[1]")).click();
			w.Create();

			df.UOM_Name_SK("Raw Material-RW38");		//Data_1
			df.UOM_Code_SK("RW38");                  //Data_2
			w.Submit();
			E_Signature("Password");

			w.SearchBox("Raw Material-RW38");               //Data1
			w.Edit_Action_Button();
			df.UOM_Name_SK("Raw Material-RW38E"); 			//Edited_Data_1
			df.UOM_Code_SK("RW388");      			    //Edited_Data_2
			Update("Password");

			w.SearchBox("Raw Material-RW38E");//Edited_Data_1
			Disable("Password");

			w.SearchBox("Raw Material-RW38E");//Edited_Data_1
			Enable("Password");

			w.Create();
			df.UOM_Name_SK("Raw Material-RW38E"); 			//Edited_Data_1
			df.UOM_Code_SK("RW388");      			    //Edited_Data_2

			w.Submit();
			w.Cross_Close_Button();

			driver.close();
		}}}
