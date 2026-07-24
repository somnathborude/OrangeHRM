package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "LoginData")
    public Object[][] getData() throws IOException {

        ExcelUtils excel = new ExcelUtils();

        int rows = excel.getRowCount();
        int cols = excel.getCellCount();

        Object[][] data = new Object[rows - 1][cols];

        for (int i = 1; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                data[i - 1][j] = excel.getCellData(i + 1, j);

            }
        }

        excel.closeWorkbook();

        return data;
    }
}