package com.dollardays.listners;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.dollardays.utilities.PropertyUtil;

public class ExtentReport {

	
	private static ExtentSparkReporter extentSparkReporter;
	public static ExtentTest test;
	
	public static String getCurrentDateAnTime()
	{
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyhhmmss");
		String formattedate = formatter.format(date);
		return formattedate;
	}
	
	
	private static ExtentReports extent;
    private static String reportFileName = "Test-Automaton-Report"+getCurrentDateAnTime()+".html";
    private static String fileSeperator = System.getProperty("file.separator");
    private static String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "reports";
    private static String reportFileLocation =  reportFilepath +fileSeperator+ reportFileName;
 
    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }
 
    //Create an extent report instance
    public static ExtentReports createInstance() {
    	extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports"+ "/report.html");
    	//extentSparkReporter = new ExtentSparkReporter(".\\\\reports"+"\\\\"+getCurrentDateAnTime());
		extentSparkReporter.config().setReportName("Dollar Days Report");
	//	extentSparkReporter.config().setDocumentTitle("Dollar Days Document");

		extent = new ExtentReports();
		extent.attachReporter(extentSparkReporter);
		extent.setSystemInfo("Tester", "Tester Name");
 
         return extent;
    }
     

}
