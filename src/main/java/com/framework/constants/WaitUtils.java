package com.framework.constants;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	WebDriver webdriverManager;
	/*Function to Wait until Element to be clickable
	 * @param element 
	 * @param driver 
	 * 
	 */
	
	public void waituntillElementToBeClickable (WebDriver driver, WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/*Function to Wait until Element to be selected
	 * @param element 
	 * @param driver 
	 * 
	 */
	public void waitUntilelementToBeSelected(WebElement element, WebDriver driver) {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
	/*Function to Wait until Element to be invisible
	 * @param element 
	 * @param driver 
	 * 
	 */
	public void waitUntilelementToBeInvisible(WebElement element, WebDriver driver) {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	/*Function to Wait until Element to be Visible
	 * @param element 
	 * @param driver 
	 * 
	 */
	public static void waitTillWebElementIsVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element)); 
	}
	/*Function to Wait untilElement to be Clickable by By 
	 * @param elementBy 
	 * @param driver 
	 * 
	 */
	public static void waitUntilClickable(WebDriver driver, By elementBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(elementBy)); 
	}
	
	/*Function to Wait until Element to be selectable
	 * @param elementBy 
	 * @param driver 
	 * 
	 */
	public static void waitUntilSelectable(WebDriver driver, By elementBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeSelected(elementBy)); 
	}
}
