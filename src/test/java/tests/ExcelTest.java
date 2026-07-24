package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import utilities.ExcelUtils;

public class ExcelTest {

    @Test
    public void readExcelData() throws IOException {

        ExcelUtils excel = new ExcelUtils();

        System.out.println("Rows : " + excel.getRowCount());

        System.out.println("Columns : " + excel.getCellCount());

        System.out.println("Username : " + excel.getCellData(1, 0));

        System.out.println("Password : " + excel.getCellData(1, 1));

        excel.closeWorkbook();
    }
}