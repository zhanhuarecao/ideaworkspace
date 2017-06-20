package zk.test.controller;

/**
 * Created by zk on 2017/6/20.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.RichTextString;

/**
 * 15.	 * 共分为六部完成根据模板导出excel操作：<br/>
 * 16.	 * 第一步、设置excel模板路径（setSrcPath）<br/>
 * 17.	 * 第二步、设置要生成excel文件路径（setDesPath）<br/>
 * 18.	 * 第三步、设置模板中哪个Sheet列（setSheetName）<br/>
 * 19.	 * 第四步、获取所读取excel模板的对象（getSheet）<br/>
 * 20.	 * 第五步、设置数据（分为6种类型数据：setCellStrValue、setCellDateValue、setCellDoubleValue、setCellBoolValue、setCellCalendarValue、setCellRichTextStrValue）<br/>
 * 21.	 * 第六步、完成导出 （exportToNewFile）<br/>
 * 22.	 *
 * 23.	 * @author Administrator
 * 24.	 *
 * 25.
 */
public class PoiTest {
    private String srcXlsPath = "";// // excel模板路径
    private String desXlsPath = "";
    private String sheetName = "";
    POIFSFileSystem fs = null;
    HSSFWorkbook wb = null;
    HSSFSheet sheet = null;

    /**
     * 35.	     * 第一步、设置excel模板路径
     * 36.	     * @param srcXlsPath
     * 37.
     */
    public void setSrcPath(String srcXlsPath) {
        this.srcXlsPath = srcXlsPath;
    }

    /**
     * 43.	     * 第二步、设置要生成excel文件路径
     * 44.	     * @param desXlsPath
     * 45.
     */
    public void setDesPath(String desXlsPath) {
        this.desXlsPath = desXlsPath;
    }

    /**
     * 51.	     * 第三步、设置模板中哪个Sheet列
     * 52.	     * @param sheetName
     * 53.
     */
    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    /**
     * 59.	     * 第四步、获取所读取excel模板的对象
     * 60.
     */
    public void getSheet() {
        try {
            File fi = new File(srcXlsPath);
            if (!fi.exists()) {
                System.out.println("模板文件:" + srcXlsPath + "不存在!");
                return;
            }
            fs = new POIFSFileSystem(new FileInputStream(fi));
            wb = new HSSFWorkbook(fs);
            sheet = wb.getSheet(sheetName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 79.	     * 第五步、设置字符串类型的数据
     * 80.	     * @param rowIndex--行值
     * 81.	     * @param cellnum--列值
     * 82.	     * @param value--字符串类型的数据
     * 83.
     */
    public void setCellStrValue(int rowIndex, int cellnum, String value) {
        HSSFCell cell = sheet.getRow(rowIndex).getCell(cellnum);
        cell.setCellValue(value);
    }

    /**
     * 90.	     * 第五步、设置日期/时间类型的数据
     * 91.	     * @param rowIndex--行值
     * 92.	     * @param cellnum--列值
     * 93.	     * @param value--日期/时间类型的数据
     * 94.
     */
    public void setCellDateValue(int rowIndex, int cellnum, Date value) {
        HSSFCell cell = sheet.getRow(rowIndex).getCell(cellnum);
        cell.setCellValue(value);
    }

    /**
     * 101.	     * 第五步、设置浮点类型的数据
     * 102.	     * @param rowIndex--行值
     * 103.	     * @param cellnum--列值
     * 104.	     * @param value--浮点类型的数据
     * 105.
     */
    public void setCellDoubleValue(int rowIndex, int cellnum, double value) {
        HSSFCell cell = sheet.getRow(rowIndex).getCell(cellnum);
        cell.setCellValue(value);
    }

    /**
     * 112.	     * 第五步、设置Bool类型的数据
     * 113.	     * @param rowIndex--行值
     * 114.	     * @param cellnum--列值
     * 115.	     * @param value--Bool类型的数据
     * 116.
     */
    public void setCellBoolValue(int rowIndex, int cellnum, boolean value) {
        HSSFCell cell = sheet.getRow(rowIndex).getCell(cellnum);
        cell.setCellValue(value);
    }

    /**
     * 123.	     * 第五步、设置日历类型的数据
     * 124.	     * @param rowIndex--行值
     * 125.	     * @param cellnum--列值
     * 126.	     * @param value--日历类型的数据
     * 127.
     */
    public void setCellCalendarValue(int rowIndex, int cellnum, Calendar value) {
        HSSFCell cell = sheet.getRow(rowIndex).getCell(cellnum);
        cell.setCellValue(value);
    }

    /**
     * 134.	     * 第五步、设置富文本字符串类型的数据。可以为同一个单元格内的字符串的不同部分设置不同的字体、颜色、下划线
     * 135.	     * @param rowIndex--行值
     * 136.	     * @param cellnum--列值
     * 137.	     * @param value--富文本字符串类型的数据
     * 138.
     */
    public void setCellRichTextStrValue(int rowIndex, int cellnum,
                                        RichTextString value) {
        HSSFCell cell = sheet.getRow(rowIndex).getCell(cellnum);
        cell.setCellValue(value);
    }

    /**
     * 146.	     * 第六步、完成导出
     * 147.
     */
    public void exportToNewFile() {
        FileOutputStream out;
        try {
            out = new FileOutputStream(desXlsPath);
            wb.write(out);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

