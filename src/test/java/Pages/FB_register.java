package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FB_register {
	WebDriver driver;
	By fname = By.name("firstname");
	By sname = By.name("lastname");
	By daysc = By.id("day");
	By monthsc = By.id("month");
	By yearsc = By.id("year");
	By sex = By.xpath("//*[@id=\"sex\"]");
	By email = By.name("reg_email__");
	By password = By.id("password_step_input");
	By signup = By.name("websubmit");

	public void setvalues1(String name, String lastname) {
		driver.findElement(fname).sendKeys(name);
		driver.findElement(sname).sendKeys(lastname);
	}

	public void setvalues2(String day, String month, String year) {
		WebElement dayDropdown = driver.findElement(daysc);
		WebElement monthDropdown = driver.findElement(monthsc);
		WebElement yearDropdown = driver.findElement(yearsc);

		// Create Select objects for each dropdown
		Select daySelect = new Select(dayDropdown);
		Select monthSelect = new Select(monthDropdown);
		Select yearSelect = new Select(yearDropdown);

		daySelect.selectByValue(day);
		monthSelect.selectByValue(month);
		yearSelect.selectByValue(year);
	}

	public void setvalues3(String emaill, String passwordd) {
		driver.findElement(sex).click();
		driver.findElement(email).sendKeys(emaill);
		driver.findElement(password).sendKeys(passwordd);
	}

	public void register() {
		driver.findElement(signup).click();
	}

	public FB_register(WebDriver driver) {
		this.driver = driver;
	}

}