package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_utility {
	public static String gecellvalue(String x1, String sheet, int r, int c) {
		try {

			File f = new File(x1);
			FileInputStream fi = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(fi);
			XSSFCell cell = (XSSFCell) wb.getSheet(sheet).getRow(r).getCell(c);
			if (cell.getCellType() == CellType.STRING) {
				return cell.getStringCellValue();
			} else {
				return cell.getRawValue();
			}

		} catch (Exception e) {

			return "";

		}
	}

	public static int getRowcount(String x1, String sheet) throws IOException {
		try {
			File f = new File(x1);
			FileInputStream fi = new FileInputStream(f);
			XSSFWorkbook wb = new XSSFWorkbook(fi);
			return wb.getSheet(sheet).getLastRowNum();

		} catch (Exception e) {
			return 0;
		}
	}

}