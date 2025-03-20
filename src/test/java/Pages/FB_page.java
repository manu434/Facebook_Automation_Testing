package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FB_page {
	WebDriver driver;
	// follow 5 news pages
	By search = By.xpath("//input[@placeholder='Search Facebook']");
	By follow1 = By.xpath(
			"//div[@class='x1ja2u2z x78zum5 x2lah0s x1n2onr6 xl56j7k x6s0dn4 xozqiw3 x1q0g3np xi112ho x17zwfj4 x585lrc x1403ito x972fbf xcfux6l x1qhh985 xm0m39n x9f619 xn6708d x1ye3gou x1hr4nm9 x1r1pt67']//div[@class='x6s0dn4 x78zum5 xl56j7k x1608yet xljgi0e x1e0frkt']");

	String[] pagesToFollow = { "BBC News offcial page", "India Today offcial page", "CNN offcial page",
			"The New York Times offcial page", "The Guardian offcial page" };

	public void page() throws InterruptedException {
		Thread.sleep(20000);
		// Loop through the list of pages and follow each one
		for (String page : pagesToFollow) {
			// Search for the page
			WebElement searchBox = driver.findElement(search);
			// Thread.sleep(20000);
			searchBox.clear();
			searchBox.sendKeys(page, Keys.ENTER);

			// Wait for the search results to load
			Thread.sleep(5000);

			// Click the follow button
			driver.findElement(follow1).click();

			// Wait before the next iteration
			Thread.sleep(5000);
		}
	}

	public void content_verify() throws InterruptedException {
//		driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M18.5 1A1.')]")).click();
//		Thread.sleep(20000);
//		driver.findElement(By.xpath("//span[normalize-space()='Pages']")).click();
//		Thread.sleep(10000);
//		driver.findElement(By.xpath(
//				"//*[@id=\"mount_0_0_fO\"]/div/div[1]/div/div[3]/div/div/div[2]/div[1]/div[1]/div/div[2]/div[1]/div[4]/div[3]"))
//				.click();
		driver.get("https://www.facebook.com/pages/?category=liked&ref=bookmarks");
		String[] pagesToCheck = { "BBC News", "India Today", "CNN", "The New York Times", "The Guardian" };
		String pagesource = driver.getPageSource();
		for (String page : pagesToCheck) {
			if (pagesource.contains(page)) {
				System.out.println(page + " is present in the page source.");
			} else {
				System.out.println(page + " is NOT present in the page source.");
			}
		}
	}

	public void tagname() {
		List<WebElement> li = driver.findElements(By.tagName("a"));
		System.out.println("Total links in the facebook following page  Site :" + li.size());
		for (WebElement link : li) {
			// Getting the href attribute
			// String href = link.getAttribute("href");
			String href = link.getDomAttribute("href");
			// Getting the text of the link
			String text = link.getText();

			System.out.println("Link Text: " + text);
			System.out.println("Href: " + href);
		}
	}

	public FB_page(WebDriver driver) {
		this.driver = driver;
	}

}