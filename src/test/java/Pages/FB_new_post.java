package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import com.opencsv.exceptions.CsvException;

public class FB_new_post {
	WebDriver driver;

	public void fbpage() throws FileNotFoundException, IOException, CsvException {
		// Create an instance of the Actions class
		Actions actions = new Actions(driver);

		// Create an instance of JavascriptExecutor for scrolling
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Total number of Tab key presses
		int totalIterations = 29;

		for (int i = 1; i <= totalIterations; i++) {
			// Press Tab
			actions.sendKeys(Keys.TAB).perform();

			// Check if it's iteration 7 or 29
			if (i == 7 || i == 29) {
				// Press Enter for iterations 7 and 29
				actions.sendKeys(Keys.ENTER).perform();
			}

			// Scroll between the 7th and 29th iterations
			if (i > 7 && i < 29) {
				// Scroll down a little using JavaScript
				js.executeScript("window.scrollBy(0, 80);"); // Scroll down by 80 pixels
			}

			// Optional: Add a small delay (in milliseconds) between actions
			try {
				Thread.sleep(2000); // 2-second delay
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// After iteration 29, press Tab until iteration 4, then press Enter
		for (int i = 1; i <= 4; i++) {
			actions.sendKeys(Keys.TAB).perform();
			try {
				Thread.sleep(2000); // 2-second delay between Tab presses
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		actions.sendKeys(Keys.ENTER).perform(); // Press Enter for iteration 4

		// After iteration 4, press Enter for iteration 5 (no additional Tab presses)
		actions.sendKeys(Keys.ENTER).perform(); // Press Enter for iteration 5

	}

	public void fileUpload(String filePath) throws AWTException {
		// Use Robot class to handle file upload (if necessary)
		StringSelection strselection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strselection, null);

		Robot robot = new Robot();
		robot.delay(3000); // Wait for 3 seconds
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void postbutton() {
		Actions actions = new Actions(driver);
		int totalIterations = 8;
		for (int i = 1; i <= totalIterations; i++) {
			// Press Tab
			actions.sendKeys(Keys.TAB).perform();

			// Check if it's iteration 7 or 29
			if (i == 7) {
				// Press Enter for iterations 7 and 29
				actions.sendKeys(Keys.ENTER).perform();
			}
			try {
				Thread.sleep(2000); // 2-second delay
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public FB_new_post(WebDriver driver) {
		this.driver = driver;
	}

	public void screenshot() throws IOException {
		WebElement screenshot1 = driver.findElement(By.xpath("//span[contains(text(),'Manu K')]"));
		File sc = screenshot1.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(sc, new File("./newsscreenshots/facebookelementscreenshot.png"));
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshot, new File("./newsscreenshots/facebookhomepage.png"));

	}
}