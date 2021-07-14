package searchfunctionality;

//Below are drivers
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTesting {
	
	public static void main(String[] args) throws InterruptedException  {
		
		System.setProperty("webdriver.chrome.driver", "D:/selenium dump/chromedriver/chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		//navigating to the URL
		driver.get("http://skunkworks.ignitesol.com:3000/");
		driver.manage().window().maximize();
		
		//checking the links in home page
		List<String> expLinks=new ArrayList<String>();
		expLinks.add("PHILOSOPHY");expLinks.add("DRAMA");expLinks.add("HUMOR");expLinks.add("POLITICS");expLinks.add("HISTORY");expLinks.add("ADVENTURE");
		expLinks.add("FICTION");
			
		List<WebElement> actualLinks=driver.findElements(By.xpath("//a//span[@class=\"btn_text\"]"));
		int img=0;
		for (String j:expLinks) {
			for(WebElement i:actualLinks) {
				String actualText=i.getText();
				if(j.equalsIgnoreCase(actualText)) {
					img=img+1;
				}
			}
		}
		if (img==7) {
			System.out.println("Test case 1 is pass");
		}else
			System.out.println("Test case 1 is fail");
		
		
		//selecting the book
		
		//navigating to the page: Fiction
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/button[1]")).click();
		
		//Searching for a book starting with the key word : "Great Expectations"
		int expImgNO=2;
		driver.findElement(By.xpath("//input[@id='outlined-full-width']")).sendKeys("Great Expectations");
		driver.findElement(By.xpath("//span[contains(text(),'Search')]")).click();	
		Thread.sleep(3500);
		
		List<WebElement> imgList=driver.findElements(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[2]/div[1]/div"));
		
		System.out.println(imgList.size());
		
		if(expImgNO==imgList.size()) {
			System.out.println("test case 2 pass");
		}else
			System.out.println("test case 2 fail");
		for(WebElement i:imgList) {
			i.click();
		}
		
		
		
		//load more button click testing on the page : Fiction
		//driver.findElement(By.xpath("//span[contains(text(),'Load More')]")).click();
	
		driver.close();
	
	}

}
