package com.koreait.fashionshop.model.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelManager {
	FileInputStream fis;
	
	public ExcelManager() {
		//로컬?�� ?��?��?�� ?��근하�? ?��?��?��?�� ?��?�� ?��?��림이 ?��?��?��
		try {
			fis = new FileInputStream("D:/korea_workspace/FashionShop/src/main/webapp/resources/excel/myskill.xlsx");
			//?��???�� ?��?��?��?�� 객체 ?��?�� XSSFWorkbook
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			
			//?��?��?��근�? ?��공한 ?��?��?���?�?, ?�� ?��?���??��?�� ?��?��?�� ?��근한?�� 
			XSSFSheet sheet=workbook.getSheetAt(0); //첫번�? ?��?�� ?��?��
			
			//?�� ?��?���??��?�� sheet�? ?��?��?�� ?�� ?��?���?�?, �? 몇건?�� 존재?��?���?�??�� ?��?��본다 
			int rows = sheet.getPhysicalNumberOfRows(); //?��?��?���? 채워�? row ?��
			System.out.println("?��코드 ?��?�� : "+rows);
			
			//로우?? 컬럼 ?��만큼 반복�? ?��?��?���?, ?��?��?���? ?��?��?��보자
			for(int i=0;i<rows;i++) {
				XSSFRow row=sheet.getRow(i); //?��?��?�� 로우�? ?���?
				
				//컬럼?��만큼 반복�? ?��?��
				int columCount=row.getPhysicalNumberOfCells();
				for(int a=0;a<columCount;a++) {
					XSSFCell cell=row.getCell(a); //컬럼 ?��개�?? ?���?
					
					//각�??�� ?��료형?�� ?��?��?��?�� 그에 맞게 ?���? 
					if(cell.getCellType() == CellType.STRING ) {//???�� ?��료형?�� 문자?��경우..
						System.out.print(cell.getStringCellValue()+"\t");
					}else if(cell.getCellType() == CellType.NUMERIC) {
						System.out.print((int)cell.getNumericCellValue()+"\t");
					}
				}
				System.out.println();//줄바�?
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new ExcelManager();
	}

}
