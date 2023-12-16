package Transaction_PharmaDispatch;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.Master_Xpaths;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_06_Handling_Of_Returned_Goods extends BaseClass
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
		w.Menu_Navigate();
		w.Transactions();
		w.Pharma_Dispatch();
		w.Handling_Of_Returned_Goods();
		w.Menu_Navigate();
		w.Create();
	
		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=3; i<=3;i++)		
		{ 




		}}}
