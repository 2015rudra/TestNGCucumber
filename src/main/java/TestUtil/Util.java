package TestUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Util extends TestBase
{

	static public int Page_Load_TimeOut = 20;
	static public int Implicit_Wait = 15;
	static public int minWait = 15;
	
	public Util() throws IOException {
		super();
	
	}



	public static String TESTDATA_SHEET_PATH = "D:\\FreeCRM\\FreeCRM\\FreeCRM\\src\\main\\java\\testdata\\TestData.xlsx";
	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;


	public static boolean waitForAnObject(WebDriver driver, WebElement elmt,
			Integer time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(presenceOfElementLocated(elmt));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static Function<WebDriver, WebElement> presenceOfElementLocated(
			final WebElement locator) {
		return new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement((By) locator);
			}
		};
	}





	public static boolean waitForAnObjectToBeAvailable(WebDriver driver,
			By element, Integer time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element)));
			return true;
		} catch (Exception e) {
			return false;
		}

	}


	public static boolean waitForPresenceOfAnObject(WebDriver driver,
			By element, Integer time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.presenceOfElementLocated(element));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public static boolean waitForAnObjectToBeVisible(WebDriver driver,
			By element, Integer time) throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.visibilityOf(driver
					.findElement(element)));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean waitForAnObjectToBeVisibilityLocated(WebDriver driver,	
			By element, Integer time) throws InterruptedException {	
		try {	
			WebDriverWait wait = new WebDriverWait(driver, time);	
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));	
			return true;	
		} catch (Exception e) {	
			return false;	
		}	
	}

	public static boolean waitForAnObjectToBeInVisible(WebDriver driver,
			By element, Integer time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public static boolean isEnabled(By elmt, WebDriver driver) {
		return driver.findElement(elmt).isEnabled();
	}
	public static void waitForAnObjectToBeEnable(WebDriver driver,By element) throws InterruptedException {
		for (int i=0;i<=5;i++){
			if(!isEnabled(element, driver)){
				Thread.sleep(1000);
			}else{
				break;
			}
		}
	}

	public static void isChecked(By elmt, WebDriver driver) {
		if (driver.findElement(elmt).isSelected()) {
			driver.findElement(elmt).click();
		}
	}

	public static void waitForAjax(WebDriver driver)
			throws InterruptedException {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		if ((Boolean) executor
				.executeScript("return window.jQuery != undefined")) {
			while (!(Boolean) executor
					.executeScript("return jQuery.active == 0")) {
				Thread.sleep(1000);
			}
		}
		return;
	}


	public static boolean isDropDownEmpty(WebElement elmt) {

		Select select = new Select(elmt);
		List<WebElement> options = select.getOptions();
		if (options.isEmpty()) {
			return true;
		} else
			return false;
	}


	public static boolean selectFromDropdown(String Value, WebElement elmt) {
		try {
			Select select = new Select(elmt);
			select.selectByVisibleText(Value);
			return true;
		} catch (Exception e) {
			return false;
		}

	}


	public static boolean selectFromDropdownByValue(String value,
			WebElement elmt) throws InterruptedException {
		try {
			Select select = new Select(elmt);
			select.selectByValue(value);
			return true;

		} catch (Exception e) {
			return false;
		}

	}
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			try {
				book = WorkbookFactory.create(file);
			} catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
}
