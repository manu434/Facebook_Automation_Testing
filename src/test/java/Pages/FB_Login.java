package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class FB_Login {
	WebDriver driver;
	By email = By.id("email");
	By Pass = By.id("pass");
	By Login = By.name("login");

	public void setvalues4(String gmail, String password) {
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(gmail);
		driver.findElement(Pass).clear();
		driver.findElement(Pass).sendKeys(password);
	}

	public void login() throws InterruptedException {
		// Thread.sleep(2000);
		driver.findElement(Login).click();
		// Thread.sleep(30000);
	}

	public void verifyurl() {
		String expected = "https://www.facebook.com/";
		String actual = driver.getCurrentUrl();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actual, expected, "incorrect url");
		soft.assertAll();

	}

	public void veeifytitle() {
		String expected = "Facebook";
		String actual = "Facebook";
		SoftAssert soft2 = new SoftAssert();
		soft2.assertEquals(expected, actual, "Title is Wrong");
		soft2.assertAll();
	}

	public FB_Login(WebDriver driver) {
		this.driver = driver;
	}
}