package utils;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.annotations.DataProvider;

public class ExcelReader {

    static FileInputStream fileInputStream;
    static Workbook workbook;
    static Sheet sheet;


    public static Object[][] excelData() throws IOException {
        String sheetPath = System.getProperty("user.dir") + "/src/test/resources/TestCase.xlsx";


        try {
            fileInputStream = new FileInputStream(sheetPath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        workbook = WorkbookFactory.create(fileInputStream);
        sheet = workbook.getSheet("Sheet1");

        int row = sheet.getLastRowNum();
        int col = sheet.getRow(0).getLastCellNum();
        System.out.println(col);
        System.out.println(row);
        Object[][] data = new Object[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
                System.out.println(sheet.getRow(i + 1).getCell(j).toString());
            }
        }
        return data;


    }

    @DataProvider
    public Object[][] getdata() throws IOException {

        try {
            return excelData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
