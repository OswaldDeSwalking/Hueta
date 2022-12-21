package Ppe;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class WorkcBoock {
    XSSFWorkbook workbook;

    public XSSFSheet WorkcBoock(int i) throws IOException {
        FileInputStream fis = new FileInputStream("d:\\Jobs\\24.xlsx");
        workbook = new XSSFWorkbook(fis);
        XSSFSheet s = workbook.getSheetAt(i);
        return s;
    }
}
