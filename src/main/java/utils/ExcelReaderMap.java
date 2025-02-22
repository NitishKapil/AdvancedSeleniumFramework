package utils;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelReaderMap {

    static FileInputStream fileInputStream;
    static Workbook workbook;
    static Sheet sheet;

    public static void main(String[] args) throws IOException {
        ExcelReaderMap.excelData();
    }


    public static Map<String,String> excelData() throws IOException {
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
        Map<String,String> values = new HashMap<>();
        for (int i = 1; i <row; i++) {
            for (int j = 0; j < col; j++) {

                values.put(sheet.getRow(i).getCell(j).toString(),sheet.getRow(i + 1).getCell(j).toString());
            }
            System.out.println(values);
        }

        return values;


    }
    /*@DataProvider
    public Object[][] getdata() throws IOException {

        try {
            return excelData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/

}
