package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    String path = System.getProperty("user.dir") + "/TestData/LoginData.xlsx";

    XSSFWorkbook workbook;
    XSSFSheet sheet;

    public ExcelUtils() throws IOException {

        FileInputStream fis = new FileInputStream(path);

        workbook = new XSSFWorkbook(fis);

        sheet = workbook.getSheetAt(0);
    }

    public int getRowCount() {

        return sheet.getLastRowNum();
    }

    public int getCellCount() {

        Row row = sheet.getRow(0);

        return row.getLastCellNum();
    }

    public String getCellData(int rowNum, int cellNum) {

        Row row = sheet.getRow(rowNum);

        Cell cell = row.getCell(cellNum);

        return cell.toString();
    }

    public void closeWorkbook() throws IOException {

        workbook.close();
    }
    public Object[][] getSheetData(String sheetName) {

        XSSFSheet sheet = workbook.getSheet(sheetName);

        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows][cols];

        for (int i = 1; i <= rows; i++) {   // Header skip

            for (int j = 0; j < cols; j++) {

                data[i - 1][j] = sheet.getRow(i).getCell(j).toString();

            }
        }

        return data;
    }
}