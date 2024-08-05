package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreport extends baseClass {

	public  ExtentReports getReport() {

		ExtentSparkReporter reporter = new ExtentSparkReporter("./Reports/testReport.html");
		reporter.config().setReportName("Orange HRM ");
		reporter.config().setDocumentTitle("Test Execution Results");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("TEST EXECUTED BY","Mugesh");
		return extent;                                                                                                                                                                                                                                                                                                                                                                                        



	}
}















