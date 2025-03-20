package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class FB_profile {
	WebDriver driver;
	By account = By.cssSelector(
			"#mount_0_0_kO > div > div:nth-child(1) > div > div.x9f619.x1n2onr6.x1ja2u2z > div > div > div.x78zum5.xdt5ytf.x1t2pt76.x1n2onr6.x1ja2u2z.x10cihs4 > div.x9f619.x1ja2u2z.x78zum5.x2lah0s.x1n2onr6.xl56j7k.x1qjc9v5.xozqiw3.x1q0g3np.x1t2pt76.x17upfok > div > div.x9f619.x1ja2u2z.x78zum5.x1n2onr6.x1iyjqo2.xs83m0k.xeuugli.xl56j7k.x1qjc9v5.xozqiw3.x1q0g3np.x1iplk16.x1xfsgkm.xqmdsaz.x1mtsufr.x1w9j1nh > div > div > div > div.x78zum5.x1q0g3np.xl56j7k > div > div.x1yztbdb > div > div > div > div.x1cy8zhl.x78zum5.x1iyjqo2.xs83m0k.xh8yej3 > a > div.html-div.xdj266r.x11i5rnm.xat24cr.x1mh8g0r.xexx8yu.x4uap5.x18d9i69.xkhd6sd > div > svg > g > image");
	By profile = By.xpath(
			"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/*[name()='svg'][1]/*[name()='g'][1]/*[name()='image'][1]");
	By picadd = By.cssSelector(
			".x193iq5w.xeuugli.x13faqbe.x1vvkbs.x1xmvt09.x1lliihq.x1s928wv.xhkezso.x1gmr53x.x1cpjm7i.x1fgarty.x1943h6x.xudqn12.x3x7a5m.x6prxxf.xvq8zen.xk50ysn.xzsf02u.x1yc453h");
	By upload = By.cssSelector(
			"span[class='x193iq5w xeuugli x13faqbe x1vvkbs x1xmvt09 x1lliihq x1s928wv xhkezso x1gmr53x x1cpjm7i x1fgarty x1943h6x xudqn12 x3x7a5m x6prxxf xvq8zen x1s688f x1mvi0mv'] span[class='x1lliihq x6ikm8r x10wlt62 x1n2onr6 xlyipyv xuxw1ft']");
	By save = By.className(
			"x1ja2u2z x78zum5 x2lah0s x1n2onr6 xl56j7k x6s0dn4 xozqiw3 x1q0g3np xi112ho x17zwfj4 x585lrc x1403ito x972fbf xcfux6l x1qhh985 xm0m39n x9f619 xbxaen2 x1u72gb5 xtvsq51 x1r1pt67");
	By manuk = By.xpath("//span[contains(text(),'Manu K')]");

	public void facebookcover() throws AWTException, InterruptedException {
		// Thread.sleep(20000);
		driver.findElement(manuk).click();
		driver.findElement(By.xpath("//span[contains(text(),'Add Cover Photo')]")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Upload photo']")).click();
		fileUpoad2("C:\\Users\\Dell\\Downloads\\cover_photo.jpg");
		driver.findElement(By.xpath(
				"//div[@class='x1ja2u2z x78zum5 x2lah0s x1n2onr6 xl56j7k x6s0dn4 xozqiw3 x1q0g3np xi112ho x17zwfj4 x585lrc x1403ito x972fbf xcfux6l x1qhh985 xm0m39n x9f619 xbxaen2 x1u72gb5 xtvsq51 x1r1pt67']"))
				.click();

	}

	private void fileUpoad2(String p) throws AWTException {

		StringSelection strselection = new StringSelection(p);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strselection, null);
		Robot robot = new Robot();
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public void actions1() throws AWTException, InterruptedException {

		Thread.sleep(20000);
		driver.findElement(account).click();
		// driver.navigate().refresh();
		Thread.sleep(20000);
		driver.findElement(profile).click();
		Thread.sleep(10000);
		driver.findElement(picadd).click();
		Thread.sleep(10000);
		driver.findElement(upload).click();
		// Thread.sleep(20000);
		fileUpoad("C:\\Users\\Dell\\Downloads\\news.jpg");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		driver.findElement(save).click();

	}

	private void fileUpoad(String p) throws AWTException {

		StringSelection strselection = new StringSelection(p);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strselection, null);
		Robot robot = new Robot();
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	public FB_profile(WebDriver driver) {
		this.driver = driver;
	}

}