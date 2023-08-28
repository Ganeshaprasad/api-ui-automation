package com.framework.library;

import java.io.File;
import java.net.MalformedURLException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.By.ByPartialLinkText;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.constants.WebConstants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumUtility {

	// Create Browser Instance to opening the browser
	public WebDriver createBrowserInstance(String browser) throws MalformedURLException {
		WebDriver driver = null;

		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.silentOutput", "true");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			options.addArguments("--disable-web-security");
			driver = new ChromeDriver(options);

		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions fOptions = new FirefoxOptions();
			fOptions.addArguments("-private");
			driver = new FirefoxDriver(fOptions);
		}
		return driver;
	}

	private WebDriver driver;

	// Inner class for Mouse Actions
	public static class MouseAction {

		/**
		 * Function to get Actions Class instance
		 * 
		 * @param driver
		 * @return Actions
		 */
		private static Actions getInstance(WebDriver driver) {
			return new Actions(driver);
		}

		/**
		 * Function to click on Current Mouse Location
		 * 
		 * @param driver
		 */
		public static void mouseClick(WebDriver driver) {
			Actions actions = getInstance(driver);
			actions.click().build().perform();
		}

		/**
		 * Function to click on middle of provided element
		 * 
		 * @param driver
		 * @param element
		 */
		public static void mouseClick(WebDriver driver, WebElement element) {
			Actions actions = getInstance(driver);
			DynamicWait.elementWait(driver, WebConstants.WAIT_TIME)
					.until(ExpectedConditions.elementToBeClickable(element));
			;
			actions.click(element).build().perform();
		}

		/**
		 * Function to click and hold on Current Mouse Location
		 * 
		 * @param driver
		 */
		public static void mouseClickAndHold(WebDriver driver) {
			Actions actions = getInstance(driver);
			actions.clickAndHold().build().perform();

		}

		/**
		 * Function to click and hold on middle of provided element
		 * 
		 * @param driver
		 * @param element
		 */
		public static void mouseClickAndHold(WebDriver driver, WebElement element) {
			Actions actions = getInstance(driver);
			DynamicWait.elementWait(driver, WebConstants.WAIT_TIME).until(ExpectedConditions.visibilityOf(element));
			actions.clickAndHold(element).build().perform();
		}

		/**
		 * Function to Right click on Current Mouse Location
		 * 
		 * @param driver
		 */
		public static void mouseRightClick(WebDriver driver) {
			Actions actions = getInstance(driver);
			actions.contextClick().build().perform();

		}

		/**
		 * Function to Right click on middle of provided element
		 * 
		 * @param driver
		 * @param element
		 */
		public static void mouseRightClick(WebDriver driver, WebElement element) {
			Actions actions = getInstance(driver);
			DynamicWait.elementWait(driver, WebConstants.WAIT_TIME)
					.until(ExpectedConditions.elementToBeClickable(element));
			actions.contextClick(element).build().perform();
		}

		/**
		 * Function to double click on Current Mouse Location
		 * 
		 * @param driver
		 */
		public static void mouseDoubleClick(WebDriver driver) {
			Actions actions = getInstance(driver);
			actions.doubleClick().build().perform();

		}

		/**
		 * Function to double click on middle of provided element
		 * 
		 * @param driver
		 * @param element
		 */
		public static void mouseDoubleClick(WebDriver driver, WebElement element) {
			Actions actions = getInstance(driver);
			DynamicWait.elementWait(driver, WebConstants.WAIT_TIME).until(ExpectedConditions.visibilityOf(element));
			actions.doubleClick(element).build().perform();
		}

		/**
		 * Function to click and hold mouse from source and then drag and drop to target
		 * element
		 * 
		 * @param driver
		 * @param source
		 * @param target
		 */
		public static void mouseDragAndDrop(WebDriver driver, WebElement source, WebElement target) {
			Actions actions = getInstance(driver);
			actions.dragAndDrop(source, target).build().perform();

		}

		/**
		 * Function to move the mouse to the Middle of the element
		 * 
		 * @param driver
		 * @param element
		 */
		public static void moveToElement(WebDriver driver, WebElement element) {
			Actions actions = getInstance(driver);
			DynamicWait.elementWait(driver, WebConstants.WAIT_TIME).until(ExpectedConditions.visibilityOf(element));
			actions.moveToElement(element).build().perform();

		}

		/**
		 * Function send keys to active element
		 * 
		 * @param driver
		 * @param charSequence
		 */
		public static void sendKeys(WebDriver driver, String charSequence) {
			Actions actions = getInstance(driver);
			actions.sendKeys(charSequence).build().perform();
		}

		/**
		 * Function to click first on a element and the send keys to element
		 * 
		 * @param driver
		 * @param charSequence
		 */
		public static void sendKeys(WebDriver driver, WebElement element, String charSequence) {
			Actions actions = getInstance(driver);
			DynamicWait.elementWait(driver, WebConstants.WAIT_TIME).until(ExpectedConditions.visibilityOf(element));
			actions.sendKeys(element, charSequence).build().perform();
		}

		/**
		 * Function to release pressed left mouse button on current mouse location
		 * 
		 * @param driver
		 */
		public static void mouseRelease(WebDriver driver) {
			Actions actions = getInstance(driver);
			actions.release().build().perform();

		}

		/**
		 * Function to release pressed left mouse button on middle of given element
		 * 
		 * @param driver
		 */
		public static void mouseRelease(WebDriver driver, WebElement element) {
			Actions actions = getInstance(driver);
			DynamicWait.elementWait(driver, WebConstants.WAIT_TIME).until(ExpectedConditions.visibilityOf(element));
			actions.release(element).build().perform();

		}

		/**
		 * Function to Scroll to particular web element
		 * 
		 * @param driver
		 * @param element
		 */
		public static void mouseScrollToElement(WebDriver driver, WebElement element) {
			Actions actions = getInstance(driver);
			DynamicWait.elementWait(driver, WebConstants.WAIT_TIME).until(ExpectedConditions.visibilityOf(element));
			actions.scrollToElement(element).build().perform();

		}

		/**
		 * Function to Bottom Of page
		 * 
		 * @param driver
		 * @param element
		 */
		public static void mouseScrollToBottomOfPage(WebDriver driver) {
			Actions actions = getInstance(driver);
			actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();

		}

		/**
		 * Function to Top Of page
		 * 
		 * @param driver
		 * @param element
		 */
		public static void mouseScrollToTopOfPage(WebDriver driver) {
			Actions actions = getInstance(driver);
			actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();

		}

		/**
		 * Function to Pause Mouse for Specified seconds
		 * 
		 * @param driver
		 * @param pauseSeconds
		 */
		public static void mousePauseByDurationSeconds(WebDriver driver, byte pauseSeconds) {
			Actions actions = getInstance(driver);
			actions.pause(Duration.ofSeconds(pauseSeconds)).build().perform();

		}

		/**
		 * Function to Pause Mouse for Specified Milli seconds
		 * 
		 * @param driver
		 * @param pauseSeconds
		 */
		public static void mousePauseByMilliSeconds(WebDriver driver, long pauseMilliSeconds) {
			Actions actions = getInstance(driver);
			actions.pause(pauseMilliSeconds).build().perform();

		}
	}

	// Inner class for Drop Down Select
	public static class DropDownSelect {

		/**
		 * Function to get Select Class instance
		 * 
		 * @param element
		 * @return Select
		 */
		private static Select getInstance(WebElement element) {
			return new Select(element);
		}

		/**
		 * Function to Select DropDown value By Visible Text
		 * 
		 * @param element
		 * @param visibleText
		 */
		public static void selectByVisibleText(WebDriver driver, WebElement element, String visibleText) {
			DynamicWait.elementWait(driver, WebConstants.WAIT_TIME).until(ExpectedConditions.visibilityOf(element));
			Select select = getInstance(element);
			select.selectByVisibleText(visibleText);
		}

		/**
		 * Function to Select DropDown value By Index
		 * 
		 * @param element
		 * @param index
		 */
		public static void selectByIndex(WebDriver driver, WebElement element, int index) {
			DynamicWait.elementWait(driver, WebConstants.WAIT_TIME).until(ExpectedConditions.visibilityOf(element));
			Select select = getInstance(element);
			select.selectByIndex(index);
		}

		/**
		 * Function to Select DropDown value By Value
		 * 
		 * @param element
		 * @param value
		 */
		public static void selectByValue(WebDriver driver, WebElement element, String value) {
			DynamicWait.elementWait(driver, WebConstants.WAIT_TIME).until(ExpectedConditions.visibilityOf(element));
			Select select = getInstance(element);
			select.selectByValue(value);
		}

		/**
		 * Function to Return First selected Option webElement on static Dropdown
		 * 
		 * @param element
		 * @return WebElement
		 */
		public static WebElement selectGetFirstSelectedOptions(WebDriver driver, WebElement element) {
			DynamicWait.elementWait(driver, WebConstants.WAIT_TIME).until(ExpectedConditions.visibilityOf(element));
			Select select = getInstance(element);
			return select.getFirstSelectedOption();
		}

		/**
		 * Function to Return List of selected Option WebElement on static Dropdown
		 * 
		 * @param element
		 * @return
		 * @return List<WebElement>
		 */
		public static List<WebElement> selectGetAllSelectedOptions(WebDriver driver, WebElement element) {
			DynamicWait.elementWait(driver, WebConstants.WAIT_TIME).until(ExpectedConditions.visibilityOf(element));
			Select select = getInstance(element);
			return select.getAllSelectedOptions();
		}

		/**
		 * Function to Return List of Option WebElement on static Dropdown
		 * 
		 * @param element
		 * @return
		 * @return List<WebElement>
		 */
		public static List<WebElement> selectGetAllOptions(WebDriver driver, WebElement element) {
			DynamicWait.elementWait(driver, WebConstants.WAIT_TIME).until(ExpectedConditions.visibilityOf(element));
			Select select = getInstance(element);
			return select.getOptions();
		}
	}

	public static class JavaScriptExecutor {

		/**
		 * Function to get JavaScript Executor instance
		 * 
		 * @param driver
		 * @return
		 * @return JavaScriptExecutor
		 */
		private static JavascriptExecutor getInstance(WebDriver driver) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			return executor;
		}

		/**
		 * Function to Scroll to Bottom of page
		 * 
		 * @param driver
		 */
		public static void scrollToBottom(WebDriver driver) {
			JavascriptExecutor js = getInstance(driver);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		}

		public static void deselectByIndex(int index) {
			deselectByIndex(index);
		}

		public static void deselectByValue(WebElement element, String value) {
			deselectByValue(element, value);
		}

		public static void deselectByVisibleText(String text) {
			deselectByVisibleText(text);
		}

		public static void deselectAll() {
			deselectAll();
		}

		public static WebElement getFirstSelectedOption() {
			return getFirstSelectedOption();
		}

		/**
		 * Function to Scroll to Top of page
		 * 
		 * @param driver
		 */
		public static void scrollToTop(WebDriver driver) {
			JavascriptExecutor js = getInstance(driver);
			js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");

		}

		/**
		 * Function to Navigate back to page
		 * 
		 * @param driver
		 */
		public static void browserNavigateBack(WebDriver driver) {
			JavascriptExecutor js = getInstance(driver);
			js.executeScript("window.history.back();");

		}

		/**
		 * Function to Move forward to page
		 * 
		 * @param driver
		 */
		public static void browserNavigateForward(WebDriver driver) {
			JavascriptExecutor js = getInstance(driver);
			js.executeScript("window.history.forward();");

		}

		/**
		 * Function to Get Web page Title
		 * 
		 * @param driver
		 * @return String
		 */
		public static String webPageTitle(WebDriver driver) {
			JavascriptExecutor js = getInstance(driver);
			return (String) js.executeScript("return document.title");

		}

		/**
		 * Function to show alert message
		 * 
		 * @param driver
		 */
		public static void alertMessage(WebDriver driver, String alertMessage) {
			JavascriptExecutor js = getInstance(driver);
			js.executeScript("alert('" + alertMessage + "');");

		}

		/**
		 * Function to get complete inner text of WebPage
		 * 
		 * @param driver
		 * @return String
		 */
		public static String completeInnerTextOfWebPage(WebDriver driver) {
			JavascriptExecutor js = getInstance(driver);
			return (String) js.executeScript("return document.documentElement.innerText");
		}

		/**
		 * Function to scroll Vertically for Certain Pixels x-pixels is the number at
		 * x-axis, it moves to the left if number is positive and it move to the right
		 * if number is negative .y-pixels is the number at y-axis, it moves to the down
		 * if number is positive and it move to the up if number is in negative .
		 * 
		 * @param driver
		 */
		public static void scrollCertainPixels(WebDriver driver, int x_pixels, int y_pixels) {
			JavascriptExecutor js = getInstance(driver);
			js.executeScript("window.scrollBy(" + x_pixels + "," + y_pixels + ")");
		}

		/**
		 * Function to click on web element
		 * 
		 * @param driver
		 * @param element
		 */
		public static void click(WebDriver driver, WebElement element) {
			JavascriptExecutor js = getInstance(driver);
			js.executeScript("arguments[0].click();", element);
		}

		/**
		 * Function to send value on web element
		 * 
		 * @param driver
		 * @param element
		 */
		public static void sendKeys(WebDriver driver, WebElement element, String value) {
			JavascriptExecutor js = getInstance(driver);
			js.executeScript("arguments[0].value=" + "'" + value + "'", element);
		}

		/**
		 * Function to HighlightWeb Element
		 * 
		 * @param driver
		 * @param element
		 */
		public static void highlightElement(WebDriver driver, WebElement element) {
			JavascriptExecutor js = getInstance(driver);
			js.executeScript("arguments[0].style.border='2px solid red'", element);
		}

		/**
		 * Function to Change Background Color of Web Element
		 * 
		 * @param driver
		 * @param element
		 */
		public static void changeBackgroundColorOfElement(WebDriver driver, WebElement element) {
			JavascriptExecutor js = getInstance(driver);
			js.executeScript("arguments[0].style.background='yellow'", element);
		}

		/**
		 * Function to Draw Border on WebElement
		 * 
		 * @param driver
		 * @param element
		 */
		public static void drawBorderOnElement(WebDriver driver, WebElement element) {
			JavascriptExecutor js = getInstance(driver);
			js.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", element);
		}
	}

	public static class ByLocator {

		/**
		 * Locator WebElement By Link Text
		 * 
		 * @param linkText
		 * @return
		 */
		public static By getElementByLinkText(String linkText) {
			return ByLinkText.linkText(linkText);

		}

		/**
		 * Locator WebElement By Class Name
		 * 
		 * @param linkText
		 * @return
		 */
		public static By getElementByClassName(String className) {
			return ByClassName.className(className);

		}

		/**
		 * Locator WebElement By CSS Selector
		 * 
		 * @param linkText
		 * @return
		 */
		public static By getElementByCssSelector(String cssSelector) {
			return ByCssSelector.cssSelector(cssSelector);

		}

		/**
		 * Locator WebElement By Id
		 * 
		 * @param linkText
		 * @return
		 */
		public static By getElementById(String id) {
			return ById.id(id);

		}

		/**
		 * Locator WebElement By Name
		 * 
		 * @param linkText
		 * @return
		 */
		public static By getElementByName(String name) {
			return ByName.name(name);

		}

		/**
		 * Locator WebElement By Tag Name
		 * 
		 * @param linkText
		 * @return
		 */
		public static By getElementByTagName(String tagName) {
			return ByTagName.tagName(tagName);

		}

		/**
		 * Locator WebElement By Partial Link Text
		 * 
		 * @param linkText
		 * @return
		 */
		public static By getElementByPartialLinkText(String partialLinkText) {
			return ByPartialLinkText.partialLinkText(partialLinkText);
		}

		/**
		 * Locator WebElement By Xpath
		 * 
		 * @param linkText
		 * @return
		 */
		public static By getElementByXpath(String xPath) {
			return ByXPath.xpath(xPath);
		}

		/**
		 * Function to Return WebElement
		 * 
		 * @param by
		 * @param driver
		 * @return
		 */
		public static WebElement elementFind(By by, WebDriver driver) {
			return driver.findElement(by);
		}

		/**
		 * Function to Return List of WebElement
		 * 
		 * @param by
		 * @param driver
		 * @return
		 */
		public static List<WebElement> elementsFind(By by, WebDriver driver) {
			return driver.findElements(by);
		}

	}

	public static class Screenshot {

		/**
		 * Function to Capture page Screenshot
		 * 
		 * @param TestClassname
		 * @param Screenshotname
		 * @param driver
		 * @return
		 * @throws Exception
		 */
		public static void capturePageScreenshot(String fileName, WebDriver driver) throws Exception {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File temperaryFileLocation = ts.getScreenshotAs(OutputType.FILE);
			LocalDate today = LocalDate.now();
			String PermenantFileLaction = System.getProperty("user.dir") + File.separator + "test-output"
					+ File.separator + "Screenshot" + File.separator + today + File.separator + "FailedScreenshot"
					+ File.separator + fileName + ".png";
			FileHandler.copy(temperaryFileLocation, new File(PermenantFileLaction));
		}

		/**
		 * Function to Capture Element Screenshot
		 * 
		 * @param TestClassname
		 * @param Screenshotname
		 * @param element
		 * @return
		 * @throws Exception
		 */
		public static void captureElementScreenshot(String fileName, WebElement element) throws Exception {
			File temperaryFileLocation = element.getScreenshotAs(OutputType.FILE);
			LocalDate today = LocalDate.now();
			String PermenantFileLaction = System.getProperty("user.dir") + File.separator + "test-output"
					+ File.separator + "Screenshot" + File.separator + today + File.separator + "FailedScreenshot"
					+ File.separator + fileName + ".png";
			FileHandler.copy(temperaryFileLocation, new File(PermenantFileLaction));
		}
	}

	public static class DynamicWait {

		/**
		 * Function to get WebDriver Wait instance
		 * 
		 * @param driver
		 * @param timeInSeconds
		 * @return
		 */
		public static WebDriverWait getInstance(WebDriver driver, int timeInSeconds) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
			return wait;
		}

		/**
		 * Function for Global Wait
		 * 
		 * @param driver
		 * @param timeInSeconds
		 */
		public static void globalWait(WebDriver driver, int timeInSeconds) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
		}

		/**
		 * Element Wait
		 * 
		 * @param driver
		 * @param timeInSeconds
		 * @return
		 */
		public static WebDriverWait elementWait(WebDriver driver, int timeInSeconds) {
			return getInstance(driver, timeInSeconds);
		}
	}

	/**
	 * Function to navigate to URL
	 * 
	 * @param driver , Url
	 */
	public void navigateToUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	/**
	 * Function for page Title
	 * 
	 * @param driver
	 */
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	/**
	 * Function forCurrent URL
	 * 
	 * @param driver
	 */
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	/**
	 * Function SwitchToFrameByIndex
	 * 
	 * @param index of Frame
	 */
	public void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * Function SwitchToDefaultContent
	 *
	 */
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	/**
	 * Function SwitchToFrameByIndex
	 * 
	 * @param Element
	 */
	public void clearElement(WebElement element) {
		element.clear();
	}

	/**
	 * Function for Get Attribute
	 * 
	 * @param Element
	 * @return Attribute
	 */
	public String getAttribute(WebElement element, String attributeName) {
		return element.getAttribute(attributeName);
	}

	/**
	 * Function for Get Text of element
	 * 
	 * @param Element
	 * @return Text
	 */
	public String getElementText(WebElement element) {
		return element.getText();
	}

	/**
	 * Function to check if Element is enabled
	 * 
	 * @param Element
	 * @return enabled Element
	 */
	public static boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}

	/**
	 * Function to check if element is Selected
	 * 
	 * @param Element
	 * @return Selected Element
	 */
	public static boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}

	/**
	 * Function to check if Element Displayed
	 * 
	 * @param Element
	 * @return displayed Element
	 */
	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public void quitWebDriver() {
		if (driver != null) {
			driver.quit();
		}
	}

}
