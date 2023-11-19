package UtilityPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {
	
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFRow row;
	private XSSFCell cell;
	String filePath;
	FileInputStream fis;
	FileOutputStream fos;
	
	public WriteExcel(String filePath){
		this.filePath = filePath;
		
		try {
			fis = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet("Sheet1");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void writeExcel(int rownum, int columnIndex, String data) {
		if(sheet!=null) {
			row =sheet.createRow(rownum);
			cell = row.createCell(columnIndex);
			cell.setCellValue(data);
		}
		
	}
	
	public void saveAndClose() {
		try {
			fos = new FileOutputStream(filePath);
			try {
				workbook.write(fos);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
