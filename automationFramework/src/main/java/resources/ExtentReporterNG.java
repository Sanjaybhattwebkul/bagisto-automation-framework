package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	public static ExtentReports getReportObject() {
		// ExtentReports , ExtentSparkReporter [ in donu classes ka use krna hota h extentReport bnane k liye ]
				String path = System.getProperty("user.dir")+"\\Reports\\report.html"; // Create Report folder and report.html file
				ExtentSparkReporter report = new ExtentSparkReporter(path); // is se 1 reports k ander report.html ki file bnegi, usme result show hoga
				report.config().setReportName("Demo ExtentReport"); // set report Name 
				report.config().setDocumentTitle("TestNg ExtentReport"); // Set Page title <title>TestNg ExtentReport</title>
				
				ExtentReports extentObj = new ExtentReports(); // is se main report generate hot i h grafically
				extentObj.attachReporter(report);  // ExtentSparkReporter ko attache krta h. mtlb ExtentSparkReporter k obj ka use k file or folder name get krte h .  
				extentObj.setSystemInfo("Tester", "Bhatt Sanju");  // Testresult m Tester ka name bhi dal skte hai.
				return extentObj;
	}
	
}
