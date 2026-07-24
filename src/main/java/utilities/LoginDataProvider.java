package utilities;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] getData() throws Exception {

        ExcelUtils excel = new ExcelUtils();

        return excel.getSheetData("Sheet1");
    }
}