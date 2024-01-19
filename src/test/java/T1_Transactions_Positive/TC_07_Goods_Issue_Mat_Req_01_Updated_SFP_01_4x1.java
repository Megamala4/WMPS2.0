package T1_Transactions_Positive;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.Master_Xpaths;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;

public class TC_07_Goods_Issue_Mat_Req_01_Updated_SFP_01_4x1 extends BaseClass {

	@org.testng.annotations.Test
	public static void Ordertypr() throws Exception {
		WMPS_OBJECT w = new WMPS_OBJECT(driver);
		HomePage hp = new HomePage(driver);
		Common_Xpath cxp = new Common_Xpath(driver);
		PWO_Xpath p = new PWO_Xpath(driver);
		DataFields df = new DataFields(driver);
		Master_Xpaths mp = new Master_Xpaths(driver);
		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for (int i = 2; i <= 2; i++) {
			// ****************************************************************************************************
			String Batch_Number_I = xls.getCellData("Dependency", "Batch_Number_I", i);// For Semifinished Product
			String Batch_Number_II = xls.getCellData("Dependency", "Batch_Number_II", i);// For Semifinished Product
			String Batch_Number_FP = xls.getCellData("Dependency", "Batch_Number_FP", i);// ************************
			// ****************************************************************************************************
			// MaterialMasterFP
			String InitiatorPassword = xls.getCellData("Changable_Data", "InitiatorPassword", i);
			String ApproverPassword = xls.getCellData("Changable_Data", "ApproverPassword", i);
			String WrongPassword = xls.getCellData("Changable_Data", "WrongPassword", i);
			// ****************************************************************************************************
			WMPS_Login("Initiator", "Initiator_Password");
			w.Menu_Navigate();
			w.Menu_Navigate();
			w.WareHouse();
			w.Goods_Issue_Mat_Req();
			// ****************************************************************************************************
			w.SearchBox(Batch_Number_I);// *****************************
			// ****************************************************************************************************
			w.Edit_Action_Button();
			// Batch No Selection
			// ********************************Try to link this Number Excel to previous
			// screen
			driver.findElement(By.xpath("(//a[contains(text(),'Select')])[1]")).click();
			w.TT_2("50");// Issued Quantity
			w.Submit_Button();

			driver.findElement(By.xpath("(//a[contains(text(),'Select')])[2]")).click();
			w.TT_3("50");// Issued Quantity
			w.Submit_Button();

			driver.findElement(By.xpath("(//a[contains(text(),'Select')])[3]")).click();
			Thread.sleep(4000);
			w.TT_4("50");// Issued Quantity
			w.Submit_Button();

			driver.findElement(By.xpath("(//a[contains(text(),'Select')])[4]")).click();
			w.TT_5("50");// Issued Quantity
			w.Submit_Button();

			w.CheckBox_1();// Outer checkbox for selecting Material
			w.CheckBox_2();// Outer checkbox for selecting Material
			w.CheckBox_3();// Outer checkbox for selecting Material
			w.CheckBox_4();// Outer checkbox for selecting Material

			w.Issue_Button();
			w.Yes();
			w.Password_Fill(InitiatorPassword);
			w.SubmitText01();
			w.Ok();
			w.Eye_FF_01();
		}
	}
}
