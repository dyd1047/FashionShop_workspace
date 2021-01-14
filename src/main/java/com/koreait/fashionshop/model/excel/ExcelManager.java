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
		//λ‘μ»¬? ??Ό? ? κ·ΌνκΈ? ??΄?? ??Ό ?€?Έλ¦Όμ΄ ???¨
		try {
			fis = new FileInputStream("D:/korea_workspace/FashionShop/src/main/webapp/resources/excel/myskill.xlsx");
			//???? ? ?΄?? κ°μ²΄ ??± XSSFWorkbook
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			
			//??Ό? κ·Όμ? ?±κ³΅ν ???΄λ―?λ‘?, ?΄ ?? λΆ??°? ?¬?Έ? ? κ·Όν?€ 
			XSSFSheet sheet=workbook.getSheetAt(0); //μ²«λ²μ§? ?¬?Έ ? ?
			
			//?΄ ?? λΆ??°? sheetλ₯? ? ?΄?  ? ??Όλ―?λ‘?, μ΄? λͺκ±΄?΄ μ‘΄μ¬??μ§?λΆ??° ??λ³Έλ€ 
			int rows = sheet.getPhysicalNumberOfRows(); //?°?΄?°κ°? μ±μμ§? row ?
			System.out.println("? μ½λ ?? : "+rows);
			
			//λ‘μ°?? μ»¬λΌ ?λ§νΌ λ°λ³΅λ¬? ?€??λ©?, ?°?΄?°λ₯? ? ?΄?΄λ³΄μ
			for(int i=0;i<rows;i++) {
				XSSFRow row=sheet.getRow(i); //??? λ‘μ°λ₯? ? κ·?
				
				//μ»¬λΌ?λ§νΌ λ°λ³΅λ¬? ?€?
				int columCount=row.getPhysicalNumberOfCells();
				for(int a=0;a<columCount;a++) {
					XSSFCell cell=row.getCell(a); //μ»¬λΌ ?κ°λ?? ? κ·?
					
					//κ°μ?? ?λ£ν? ??¨??¬ κ·Έμ λ§κ² ? κ·? 
					if(cell.getCellType() == CellType.STRING ) {//??? ?λ£ν?΄ λ¬Έμ?Έκ²½μ°..
						System.out.print(cell.getStringCellValue()+"\t");
					}else if(cell.getCellType() == CellType.NUMERIC) {
						System.out.print((int)cell.getNumericCellValue()+"\t");
					}
				}
				System.out.println();//μ€λ°κΏ?
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
