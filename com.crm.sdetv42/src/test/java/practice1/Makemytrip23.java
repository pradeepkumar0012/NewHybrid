package practice1;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Makemytrip23 {
	public static void main(String[] args) throws Throwable {
		System.setProperty("Webdriver.gecko.driver", "./geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		FileInputStream fis= new FileInputStream("./makemytrip.txt");
		Properties pro =new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		driver.get(URL);
		FileInputStream fis1= new FileInputStream("./makemytripexcel.xlsx");
		Workbook book= WorkbookFactory.create(fis1);
		Sheet sheet = book.getSheet("sheet1");
		Row ro = sheet.getRow(0);
		Cell cell= ro.getCell(0);
		Cell value = ro.getCell(1);
		String from = cell.getStringCellValue();
		String to = value.getStringCellValue();
		System.out.println(from);
		System.out.println(to);
		//Assert.assertEquals(true, false);
		//SoftAssert s=new SoftAssert();
		//s.assertEquals(true, false);
		driver.findElement(By.xpath("//span[.='From']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(from);
		driver.findElement(By.xpath("//div[.='HYD']")).click();
		driver.findElement(By.xpath("//span[.='To']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(to);
		driver.findElement(By.xpath("//div[.='MAA']")).click();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		/*driver.findElement(By.xpath("//div[@aria-label='Mon Oct 03 2022']")).click();
		Thread.sleep(2000);*/
		//driver.findElement(By.xpath("//div[@aria-label='Sun Oct 13 2022']")).click();
		String depmonth = "October 2022";
		String fromdate = "1";
		driver.findElement(By.xpath("//div[text()='"+depmonth+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+fromdate+"']")).click();
		driver.findElement(By.xpath("//span[.='RETURN']")).click();
		String ret = "October";
		String rd = "13";
		driver.findElement(By.xpath("//div[text()='"+ret+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+rd+"']")).click();
		driver.findElement(By.xpath("//span[text()='Travellers & CLASS']")).click();
		String no = "3";
		driver.findElement(By.xpath("//li[text()='"+no+"']")).click();
		String chno = "2";
		driver.findElement(By.xpath("//ul/../following::div[@class='makeFlex column childCounter']/descendant::li[text()='"+chno+"']")).click();
		String infant = "1";
		driver.findElement(By.xpath("//ul/../following::div[@class='makeFlex column pushRight infantCounter']/descendant::li[text()='"+infant+"']")).click();
		driver.findElement(By.xpath("//button[.='APPLY']")).click();
       // s.assertAll();
	}

}


