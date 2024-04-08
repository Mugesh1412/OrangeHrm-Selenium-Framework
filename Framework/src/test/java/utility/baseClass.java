package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.orangeHrm_Pages.login_logout;


public class baseClass {


	public static WebDriver driver=null;
	public static FileInputStream file;
	public static Properties data;
	public static ExtentTest test;
	public static ExtentReports extent;



	@BeforeSuite
	public void setup() {

		Extentreport my = new Extentreport();
		extent=my.getReport();

	}

	
	@BeforeClass
	@Parameters("browser")
	public void openBroswer(String broswer) throws IOException {

		//String broswerName = getValues().getProperty("Broswer");
		String broswerName=broswer;

		if(broswerName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if (broswerName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "./Driver/msedgedriver.exe");
			driver= new ChromeDriver();
		}
		else {
			System.out.println("we do not support this broswer");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		driver.get(getValues().getProperty("URL"));

	}

	@AfterClass
	public void closeBroswer() {
		driver.close();
	}





	public  Properties getValues() throws IOException {



		file = new FileInputStream("./src/main/resources/resources/Globaldata.txt");
		data = new Properties();
		data.load(file);
		return data;

	
	}

	public String takeScreenShot(String name) throws IOException {

		TakesScreenshot tss = (TakesScreenshot)driver;
		File source = tss.getScreenshotAs(OutputType.FILE);
		File target = new File("./Screenshoot/" + name + ".png");
		FileUtils.copyFile(source, target); 
		return System.getProperty("user.dir")+ "//Screenshoot//" + name + ".png";


	}

           



}
