package config;

public class constants 
{
	//This is the list of System Variables
    //Declared as 'public', so that it can be used in other classes of this project
    //Declared as 'static', so that we do not need to instantiate a class object
    //Declared as 'final', so that the value of this variable can be changed
    // 'String' & 'int' are the data type for storing a type of value	
	public static final String URL_ADMIN = "https://blue.testlab.nhs.uk/cidadmin/";
	public static final String URL_REALM_ADMIN = "https://blue.testlab.nhs.uk/auth/admin/Test/console";
	public static final String URL_PATIENT_RECORDS = "https://blue.testlab.nhs.uk/nhsgpclient/record";
	public static final String Path_TestData = "D://Selenium & Java Workspace//";
	public static final String Path_OR = "D://Selenium & Java Workspace//";
	public static final String File_TestData = "DataEngine.xlsx";
	public static final String Path_ScreenShots = "D://Selenium & Java Workspace//";
	public static final String Path_Execution_Report = "D://Selenium & Java Workspace//PrototypeTest//src//TestExecutionReport//";
	
	
	//List of Data Sheet Column Numbers
	public static final int Col_TestCaseID = 0;	
	public static final int Col_TestCaseDesc = 1;	

	public static final int Col_TestScenarioID = 1 ;
	public static final int Col_ActionKeyword = 4 ;
	//This is the new column for 'Page Object'
	public static final int Col_PageObject = 3 ;
	public static final int Col_RunMode = 2 ;
	
	public static final int Col_Result = 3 ;
	public static final int Col_TestStepResult = 6 ;
	public static final int Col_DataSet =5 ;
		
	//List of Data Engine Excel sheets
	public static final String Sheet_TestSteps = "TestSteps";
	public static final String Sheet_TestCases = "TestCases";
	
	public static final String KEYWORD_FAIL = "FAIL";
	public static final String KEYWORD_PASS = "PASS";
 
	// List of Test Data
	public static final String UserName_admin = "adminuser";
	public static final String Password_admin = "Welcome123";
	public static final String UserName_realm_admin = "realmadmin";
	public static final String Password_realm_admin = "Welcome123";
	public static final String Patient_email_id = "cid.testuser1@gmail.com";
	public static final String Patient_nhs_number = "9998880001";
	public static final String Patient_gmail_password = "WELCOMEcid123#";
	public static final String Patient_password = "Welcome123";



	
 
 
}
