package com.tengxh.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

/**
 * @ClassName: ExportExcel.java
 * @Description: java类作用描述
 * @Author: tengxh
 * @CreateDate: 2018/8/19
 * @Version: 1.0
 */
public class ExportExcel {
    //读取Xlsx
    public static Map<String, List<String[]>> readXlsx(String fileName) {

        Map<String, List<String[]>> map = new HashMap<String, List<String[]>>();
        try {
            InputStream is = new FileInputStream(fileName);
            XSSFWorkbook workbook = new XSSFWorkbook(is);

            System.out.println("sheet count: " + workbook.getNumberOfSheets());

            // 循环工作表Sheet
            for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
                XSSFSheet xssfSheet = workbook.getSheetAt(numSheet);
                String sheetName = xssfSheet.getSheetName();
                if (xssfSheet == null) {
                    continue;
                }
                List<String[]> list = new ArrayList<String[]>();

                for (int row = 0; row <= xssfSheet.getLastRowNum(); row++) {
                    XSSFRow xssfRow = xssfSheet.getRow(row);
                    if (xssfRow == null) {
                        continue;
                    }
                    String[] singleRow = new String[xssfRow.getLastCellNum()];
                    for (int column = 0; column < xssfRow.getLastCellNum(); column++) {
                        Cell cell = xssfRow.getCell(column, Row.CREATE_NULL_AS_BLANK);
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_BLANK:
                                singleRow[column] = "";
                                break;
                            case Cell.CELL_TYPE_BOOLEAN:
                                singleRow[column] = Boolean.toString(cell.getBooleanCellValue());
                                break;
                            case Cell.CELL_TYPE_ERROR:
                                singleRow[column] = "";
                                break;
                            case Cell.CELL_TYPE_FORMULA:
                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                singleRow[column] = cell.getStringCellValue();
                                if (singleRow[column] != null) {
                                    singleRow[column] = singleRow[column].replaceAll("#N/A", "").trim();
                                }
                                break;
                            case Cell.CELL_TYPE_NUMERIC:
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    singleRow[column] = String.valueOf(cell.getDateCellValue());
                                } else {
                                    cell.setCellType(Cell.CELL_TYPE_STRING);
                                    String temp = cell.getStringCellValue();
                                    // 判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串
                                    if (temp.indexOf(".") > -1) {
                                        singleRow[column] = String.valueOf(new Double(temp)).trim();
                                    } else {
                                        singleRow[column] = temp.trim();
                                    }
                                }

                                break;
                            case Cell.CELL_TYPE_STRING:
                                singleRow[column] = cell.getStringCellValue().trim();
                                break;
                            default:
                                singleRow[column] = "";
                                break;
                        }
                    }
                    list.add(singleRow);
                }
                map.put(sheetName, list);
            }
        } catch (FileNotFoundException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return map;
    }

    //写入Xlsx
    public static void writeXlsx(String fileName, Map<String, List<String[]>> map) {
        try {
            XSSFWorkbook wb = new XSSFWorkbook();
            for (Map.Entry<String, List<String[]>> vo : map.entrySet()) {
                XSSFSheet sheet = wb.createSheet(vo.getKey());
                List<String[]> list = vo.getValue();
                for (int i = 0; i < list.size(); i++) {
                    XSSFRow row = sheet.createRow(i);
                    String[] str = list.get(i);
                    for (int j = 0; j < str.length; j++) {
                        XSSFCell cell = row.createCell(j);
                        cell.setCellValue(str[j]);
                    }
                }
            }
            FileOutputStream outputStream = new FileOutputStream(fileName);
            wb.write(outputStream);
            outputStream.close();
        } catch (
                FileNotFoundException e)

        {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (
                IOException e)

        {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        System.out.println("开始读取Excle数据");
        Map<String, List<String[]>> listMap = readXlsx("C:\\Users\\luck_\\Desktop\\1.xlsx");
        if (listMap != null) {
            System.out.println("开始导出Excle数据");
            writeXlsx("C:\\Users\\luck_\\Desktop\\2.xlsx", listMap);
        }
        System.out.println("");
    }
}
