package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.TestBase;

public class Extent_Reports extends TestBase
{
	static ExtentReports report;
	public static ExtentReports getReportInstance()
	{
		if(report==null)
		{
			String reportName = new SimpleDateFormat("dd-MM-YYYY ss-mm-HH").format(new Date());
			ExtentHtmlReporter htmlReporter= new ExtentHtmlReporter("C:\\Users\\Abhishek\\eclipse-workspace\\Selenium_Framework\\ExtentReportsFile"+reportName+".html");
			report= new ExtentReports();
			report.attachReporter(htmlReporter);
			report.setSystemInfo("OS", "Windows");
			report.setSystemInfo("Environment", "SIT");
			report.setSystemInfo("Build", "101.01.01.123");
			report.setSystemInfo("Browser", "Chrome");
			htmlReporter.config().setDocumentTitle("UI Testing Document");
			htmlReporter.config().setReportName("UI Test Report");
		}
		return report; 
	}
}


































