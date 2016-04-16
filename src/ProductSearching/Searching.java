package ProductSearching;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Searching extends BasePackage.BaseClass{
	public String keyword ="dress";
	public String expected = "Search - My Store";
	
	@Test
	public void searchingProduct() {		
		driver.findElement(By.id("search_query_top")).sendKeys(keyword);
		driver.findElement(By.id("searchbox")).submit();
		Assert.assertEquals(driver.getTitle(), expected);
	}
	
	@Test
	public void verifySearchSuggestion(){
		driver.findElement(By.id("search_query_top")).sendKeys(keyword);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ac_results")));
		
		List<WebElement> allElements = driver.findElements(By.xpath("//*[@class='ac_results']/ul/li")); 
		for (WebElement element: allElements) {
			Assert.assertTrue(element.getText().contains(keyword));		
			//Assert.assertNotSame(element.getText(), suggestion.getText());						
			//System.out.println(element.getText()+" : "+element.findElements(By.name(element.getText())).size());
		}
	}
	
	@Test
	public void verifySearchSuggestionResult(){
		driver.findElement(By.id("search_query_top")).sendKeys(keyword);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ac_results")));
		driver.findElement(By.xpath("//*[@class='ac_results']/ul/li")).click();
		Assert.assertEquals(driver.getTitle(), expected);
	}
}
