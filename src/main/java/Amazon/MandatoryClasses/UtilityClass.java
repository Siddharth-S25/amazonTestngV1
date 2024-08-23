package Amazon.MandatoryClasses;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class UtilityClass {

        public static String fetchdata(int rowindex,int colindex) throws IOException, FileNotFoundException {

            FileInputStream file1= new FileInputStream("C:\\Users\\ADMIN\\Downloads\\Test2.xlsx");

            XSSFWorkbook book= new XSSFWorkbook(file1);

            XSSFSheet sheet = book.getSheet("TestData");

            String data = sheet.getRow(rowindex).getCell(colindex).getStringCellValue();

            return data;
        }

        public static void screenShot(WebDriver driver,String filename) throws IOException
        {
            TakesScreenshot sc=(TakesScreenshot)driver;
            File src=sc.getScreenshotAs(OutputType.FILE);
            File des=new File("C:\\Users\\ADMIN\\Desktop\\ScreenShoots\\"+filename+".jpg");
            FileHandler.copy(src, des);
        }

    }
