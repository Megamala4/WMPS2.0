

package DataField;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_02_MaterialType extends BaseClass
{

	@org.testng.annotations.Test
	public static void Ordertypr() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);
		HomePage hp=new HomePage(driver);
		Common_Xpath cxp=new Common_Xpath(driver);
		PWO_Xpath p=new PWO_Xpath(driver);
		DataFields df=new DataFields(driver);
		Actions actions = new Actions(driver);

		WMPS_Login("Initiator","Password");

		
		int rowcount = xls.getRowCount("Df_Material_Type");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)
		{ 
			String MaterialType = xls.getCellData("Df_Material_Type", "Material_Type", i);
			String Material_Type_Edit =xls.getCellData("Df_Material_Type", "Material_Type_Edit", i);
			String TypeCode =xls.getCellData("Df_Material_Type", "Type_Code", i);
			String TypeCode_Edit =xls.getCellData("Df_Material_Type", "Material_Code_Edit", i);
			
			driver.findElement(By.xpath("//*[contains(text(),'Data Fields')]")).click();
			driver.findElement(By.xpath("(//a[contains(text(),'Material Type')])[1]")).click();
			
			WebElement MoveCursor = driver.findElement(By.xpath("//*[contains(text(),'Transactions')]"));
			actions.moveToElement(MoveCursor).perform();Thread.sleep(1000);	
			
			w.Create();

			df.Material_Type_SK(MaterialType);//Data_1
			df.TypeCode_SK(TypeCode);//Data_2
			w.Submit();
			E_Signature("Password");

			w.SearchBox(MaterialType);//Data1
			w.Edit_Action_Button();
			df.Material_Type_SK(Material_Type_Edit);//Edited_Data_1
			df.TypeCode_SK(TypeCode_Edit);//Edited_Data_2
			Update("Password");

			w.SearchBox(Material_Type_Edit);//Edited_Data_1
			Disable("Password");

			w.SearchBox(Material_Type_Edit);//Edited_Data_1
			Enable("Password");

			w.Create();
			df.Material_Type_SK(Material_Type_Edit); //Edited_Data_1
			df.TypeCode_SK(TypeCode_Edit);//Edited_Data_2

			w.Submit();
			w.Cross_Close_Button();
		}
			driver.close();
		}}
