package Pages;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FB_Top_news {
	WebDriver driver;

	// Define the Facebook news pages
	By[] newsPages = { By.xpath("//a[@href='https://facebook.com/IndiaToday']//span"),
			By.xpath("//a[@href='https://facebook.com/bbcnews']//span"),
			By.xpath("//a[@href='https://facebook.com/nytimes']//span"),
			By.xpath("//a[@href='https://facebook.com/cnn']//span"),
			By.xpath("//a[@href='https://facebook.com/Reuters']//span") };

	String[] newsTitles = { "India Today", "BBC News", "New York Times", "CNN", "Reuters" };

	public FB_Top_news(WebDriver driver) {
		this.driver = driver;
	}

	public void facebooknews() throws InterruptedException, IOException {
		driver.get("https://www.facebook.com/pages/?category=liked&ref=bookmarks");
		String parentWindow = driver.getWindowHandle();

		// Open CSV file once (to store all news)
		FileWriter writer = new FileWriter("C:\\Users\\Dell\\Desktop\\news_data3.csv");
		writer.append("Source, News Content\n"); // CSV Headers

		// Iterate through each news source
		for (int i = 0; i < newsPages.length; i++) {
			String newsTitle = newsTitles[i];
			driver.findElement(newsPages[i]).click(); // Click news link

			Set<String> allWindows = driver.getWindowHandles();
			for (String handle : allWindows) {
				if (!handle.equalsIgnoreCase(parentWindow)) {
					driver.switchTo().window(handle);
					scrapeNews(writer, newsTitle);
					driver.close(); // Close tab after extracting data
				}
			}
			driver.switchTo().window(parentWindow); // Return to main window
		}

		writer.flush();
		writer.close();
		System.out.println("✅ News data saved successfully in one file!");
	}

	private void scrapeNews(FileWriter writer, String newsTitle) throws IOException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll to load more posts
		for (int i = 0; i < 5; i++) {
			js.executeScript("window.scrollBy(0,1000)");
			Thread.sleep(2000);
		}

		// Wait for posts to load
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-ad-preview='message']")));
		List<WebElement> posts = driver.findElements(By.xpath("//div[@data-ad-preview='message']"));

		System.out.println("Total Posts from " + newsTitle + ": " + posts.size());

		// Write news content to file
		for (WebElement post : posts) {
			String newsText = post.getText().replace("\n", " ");
			System.out.println(newsTitle + " News: " + newsText);
			writer.append(newsTitle).append(", ").append(newsText).append("\n");
		}
	}

}
