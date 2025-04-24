package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    private static Workbook workbook;
    private static Sheet sheet;

    //Load excel sheet
    public static void loadExcelFile(String filepath, String sheetname) throws IOException {
        FileInputStream fis = new FileInputStream(filepath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetname);
    }

    //Read entire sheet
    public static void readAllData() {
        for (Row row : sheet) {
            for (Cell cell : row) {
                System.out.println(getCellValue(cell) + "\t");
            }
            System.out.println();
        }
    }

    // Read from specific row (0-based index)
    public static void readRow(int rowIndex) {
        Row row = sheet.getRow(rowIndex);
        for (Cell cell : row) {
            System.out.print(getCellValue(cell) + "\t");
        }
        System.out.println();
    }

    //Read from specific column(0-based index)
    public static void readColumn(int colIndex) {
        for (Row row : sheet) {
            Cell cell = row.getCell(colIndex);
            System.out.println(getCellValue(cell));
        }
    }

    //Utility method to handle various cell types
    private static String getCellValue(Cell cell) {
        if (cell == null) return "";

        switch (cell.getCellType()) {
            case STRING: return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) return cell.getDateCellValue().toString();
                else return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN: return String.valueOf(cell.getBooleanCellValue());
            case FORMULA: return cell.getCellFormula();
            case BLANK: return "";
            default: return "Unsupported Cell Type";
        }
    }
}
