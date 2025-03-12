package Excel;
import java.io.*;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;


public class logindata {
		public static String[][] readExcel(int sheet) throws Exception {

			String[][] testData = null;

			String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\logintestdata.xlsx";

			FileInputStream file = new FileInputStream(filePath);

			XSSFWorkbook wb = new XSSFWorkbook(file);

			XSSFSheet ws = wb.getSheetAt(sheet); 

			testData = new String[1][3];

			for (int i = 0; i <= ws.getLastRowNum(); i++) {

				Row r = ws.getRow(i);

				for (int j = 0; j < r.getLastCellNum(); j++) {

					testData[i][j] = String.valueOf(ws.getRow(i).getCell(j));

					//testData[0][0] = Row[0].Column[0]   1001

					//testData[0][1] = Row[0].Column[1]	  Vivek

					//testData[1][0] = Row[1].Column[0]	  1002

					//testData[1][1] = Row[1].Column[1]	  Monish

				}

			}

			wb.close();

			return testData;

		}

}
