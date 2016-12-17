package infra;


import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class WebDriverCommon {

//	public static void cleanScreenshotsDirectory(WebDriver driver) {
//		// Make sure we always start with clean screenshot dir to reduce size
//		String destDir = "test-output/screenshots";
//		File screenShotsFile = new File(destDir);
//		for (File file : screenShotsFile.listFiles()) {
//			if (!file.isDirectory()) {
//				file.delete();
//			}
//		}
//	}
	
	public void takeScreenshotAndAddToReport(WebDriver driver) {
		String destDir = "test-output/screenshots";

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		DateFormat dateFormat = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");

		new File(destDir).mkdirs();
		String destFile = dateFormat.format(new Date()) + ".png";

		try {
			FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Reporter.setEscapeHtml(false);
		Reporter.log("Saved <a href=screenshots/" + destFile + ">SE Screenshot</a>");
	}
	
	public void selectDxfFile(WebDriver driver, final String dxfFilePath) throws InterruptedException, IOException {		
		final String script_path = System.getProperty("user.dir") + "\\" +
				"\\src\\test\\resources\\selenium\\autoItScripts\\chrome" + "\\"
				+ "setSiteImageScript.exe";
		final Thread t = new Thread() {
			@Override
			public void run() {
				try {
					System.out.println(script_path + " " + dxfFilePath);
					Runtime.getRuntime().exec(script_path + " " + dxfFilePath);
					Thread.sleep(10000);
				} catch (final IOException e) {
					e.printStackTrace();
				} catch (final InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		t.start();
	}

	private static WebDriver d;

	public static WebDriver getDriverInstance() {
		return d;
	}

	public static WebDriver startDriver() {
		d = new FirefoxDriver();
		return d;
	}

	public static void stopDriver() {
		d.close();
	}
}

