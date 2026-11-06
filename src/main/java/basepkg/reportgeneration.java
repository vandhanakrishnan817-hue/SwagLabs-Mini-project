package basepkg;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class reportgeneration 
{
  public static WebDriver driver;
  public static ExtentSparkReporter reporter;
  public static ExtentReports extent;
  public static ExtentTest test;
  
  public static ExtentReports sam()
  {
	  reporter = new ExtentSparkReporter("C:\\Users\\VANDHANA K\\eclipse-workspace\\Mini_project\\Reports\\swaglabreport.html");
	  reporter.config().setDocumentTitle("Automation report");
	  reporter.config().setReportName("Functional Test");
	  reporter.config().setTheme(Theme.DARK);
	  extent = new ExtentReports();
	  extent.attachReporter(reporter);
	  
	  extent.setSystemInfo("hostname", "localhost");
	  extent.setSystemInfo("os", "windows11");
	  extent.setSystemInfo("testername", "Hridhya");
	  extent.setSystemInfo("browsername", "chrome");
	  return extent;
  }
  @AfterMethod
  public void browserclose(ITestResult result)
  {
	  if(result.getStatus()==ITestResult.FAILURE)
	  {
		  test.log(Status.FAIL, "test case failed is" +result.getName());
		  test.log(Status.FAIL,"test case failed is" +result.getThrowable());
	  }
	  else if(result.getStatus() == ITestResult.SKIP)
	  {
		  test.log(Status.SKIP,"test case skipped is" +result.getName());
	  }}
//	  else if(result.getStatus() == ITestResult.SUCCESS)
//	  {
//		  test.log(Status.PASS, "test case passed is" +result.getName());
//	  }}
  public static String screenshotMethod(WebDriver driver,String screenshotName) throws IOException
  {
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String destination="C:\\Users\\VANDHANA K\\eclipse-workspace\\Mini_project\\Reports\\screenshot\\"+screenshotName +".png";
	FileHandler.copy(src, new File(destination));
	
	return destination;
			
  }
  
  
	
  }


