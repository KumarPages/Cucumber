package misc;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import ru.stqa.selenium.factory.WebDriverPool;

public class Login {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		Capabilities chrome = DesiredCapabilities.chrome();
		WebDriver driver = WebDriverPool.DEFAULT.getDriver(chrome);
		driver.get("http://leaftaps.com/opentaps");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

	}

}
