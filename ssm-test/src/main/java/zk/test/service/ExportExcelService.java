package zk.test.service;

import org.apache.poi.hssf.usermodel.*;
import org.springframework.stereotype.Service;
import zk.test.entities.Employee;

import java.util.List;

/**
 * Created by zk on 2017/6/20.
 */
@Service
public class ExportExcelService {


    public HSSFWorkbook export(List<Employee> list,String[] headers) {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("Student");
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框

        HSSFRow row = sheet.createRow((int) 0);
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(style);
            sheet.autoSizeColumn(i);
            // sheet.SetColumnWidth(i, 100 * 256);
        }

        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow(i + 1);
            Employee employee = list.get(i);
            row.createCell(0).setCellValue(employee.getId());
            row.createCell(1).setCellValue(employee.getEmail());
            row.createCell(2).setCellValue(employee.getGender());
            row.createCell(3).setCellValue(employee.getLastName());
            row.createCell(4).setCellValue(employee.getDepartment().getDepartmentName());
        }
        return wb;
    }
}
