package popularReport.ExtentReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	
				// 1. First Need to create system path to store the file
				// 2. Need to create object for ExtentSparkReporter class 
				// 3. Pass the file path in ExtentSparkReporter
				// 4. By using config method in ExtentSparkResults we can change the Document title, ReportName
				// 5. Need to create object for ExtentResults class
				// 6. attach the ExtentSparkReporter class object to ExtentResults class
				// 7. We can provide system info also by using Extent report object
				// 8. Declaring the ExtentReports class globally
				// 9. Create test and run
		ExtentReports extent;														//8
	
	@BeforeTest
	public void test()
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html";		//1
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);			//2
		reporter.config().setReportName("Mahesh Report");						//3
		reporter.config().setDocumentTitle("Test Result");						//4
		
		extent = new ExtentReports();											//5
		extent.attachReporter(reporter);										//6
		extent.setSystemInfo("Tester", "Mahesh Babu");							//7
		
		}
		
	@Test
	public void initialDemo()
	{
		extent.createTest("intitalDemo");										// 9
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		}
}
