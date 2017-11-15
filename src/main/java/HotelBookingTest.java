import com.sun.javafx.PlatformUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelBookingTest {

    static WebDriver driver ;
    HotelBookingTest page;
    
    @FindBy(linkText = "Hotels")
    public WebElement hotelLink;

    @FindBy(id = "Tags")
     public WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    public WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    public WebElement travellerSelection;

    @Test
    public void shouldBeAbleToSearchForHotels()throws InterruptedException {
    	
    		driver = new ChromeDriver();
        setDriverPath();
        
        
        driver.get("https://www.cleartrip.com/");
        page = PageFactory.initElements(driver,HotelBookingTest.class);
        
        waitFor(2000);
       
        page.hotelLink.click();

        page.localityTextBox.sendKeys("Indiranagar, Bangalore");

        new Select(page.travellerSelection).selectByVisibleText("1 room, 2 adults");
        page.searchButton.click();

        driver.quit();

    }
    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }

}
