package ExcelTests;

import utils.ExcelUtils;

import java.io.IOException;

public class ExcelTest {
    public static void main(String[] args) throws IOException {
        String filepath = "src/test/resources/TestData.xlsx";
        ExcelUtils.loadExcelFile(filepath, "LoginData");

        System.out.println("--------Full Sheet Data--------");
        ExcelUtils.readAllData();

        System.out.println("---- Row 1 Data ----");
        ExcelUtils.readRow(1);

        System.out.println("---- Column 0 Data ----");
        ExcelUtils.readColumn(0);

    }

}
