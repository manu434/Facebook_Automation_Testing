package Test;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvException;

import Pages.FB_Login;
import Pages.FB_Top_news;
import Pages.FB_new_post;
import Pages.FB_page;
import Pages.FB_profile;
import Pages.FB_register;

public class FB_test {
	WebDriver driver;
	EdgeOptions options;

	@BeforeTest
	public void bt() {
		options = new EdgeOptions();
		options.addArguments("--disable-notifications");
		driver = new EdgeDriver(options);
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void bm() {
		driver.get("https://www.facebook.com/");

	}

	@Test(priority = 1)
	public void test_login() throws IOException, InterruptedException {
		// driver.navigate().back();
		FB_Login fb2 = new FB_Login(driver);
		String x1 = "D:\\Book1.xlsx";
		String sheet = "Sheet1";
		int rowCount = Utility.Excel_utility.getRowcount(x1, sheet);
		for (int i = 1; i <= rowCount; i++) {

			String username = Utility.Excel_utility.gecellvalue(x1, sheet, i, 0);
			System.out.println("username :" + username);
			String password = Utility.Excel_utility.gecellvalue(x1, sheet, i, 1);
			System.out.println("password :" + password);
			fb2.setvalues4(username, password);
			fb2.login();

			// driver.findElement(By.xpath(""))

		}

	}

	@Test(enabled = false)
	public void test_register() {
		driver.findElement(By.xpath("//a[contains(., 'Create new account')]")).click();
		FB_register fb1 = new FB_register(driver);
		fb1.setvalues1("Manu", "K");
		fb1.setvalues2("11", "5", "1990");
		fb1.setvalues3("mksmanu45@gmail.com", "ASwe12345@");
		fb1.register();
	}

	@Test(enabled = false)
	public void test_profile() throws AWTException, InterruptedException {
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		FB_profile fb4 = new FB_profile(driver);
		// fb4.actions1();
		fb4.facebookcover();

	}

	@Test(priority = 2)
	public void pagetest() throws InterruptedException {
		FB_page fbp = new FB_page(driver);
		fbp.content_verify();
		// fbp.page();
		fbp.tagname();
	}

	@Test(enabled = false)
	public void testnews() throws InterruptedException, IOException {
		FB_Top_news fbnp = new FB_Top_news(driver);
		fbnp.facebooknews();

	}

	@Test(enabled = false)
	public void testnewpost() throws FileNotFoundException, IOException, CsvException, AWTException {
		FB_new_post fbnp = new FB_new_post(driver);
		fbnp.fbpage();
		fbnp.fileUpload("C:\\Users\\Dell\\Downloads\\news_data3.png");
		fbnp.postbutton();
		driver.navigate().refresh();
		fbnp.screenshot();

	}

//	@AfterTest
//	public void quitDriver() {
//		if (driver != null) {
//			driver.quit(); // Closes all browser windows and quits the session
//		}
//	}

}
