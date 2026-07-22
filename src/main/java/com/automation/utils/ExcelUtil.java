package com.automation.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xslf.usermodel.XSLFFreeformShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.SchemaAttributeGroup;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectStreamException;

public class ExcelUtil {

    public static Object[][] getTestData(String sheetName) {

        Object[][] data = null;

        try {

            File file = new File("src/test/resources/testdata/LoginDataLatest.xlsx");

            FileInputStream fis = new FileInputStream(file);

            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            XSSFSheet sheet = workbook.getSheet(sheetName);

            int rowCount = sheet.getPhysicalNumberOfRows();

            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

            data = new Object[rowCount - 1][colCount];

            DataFormatter formatter = new DataFormatter();

            for (int i = 1; i < rowCount; i++) {

                for (int j = 0; j < colCount; j++) {

                    Cell cell = sheet.getRow(i).getCell(j);

                    data[i - 1][j] = formatter.formatCellValue(cell);
                }
            }

            workbook.close();
            fis.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return data;
    }


}
