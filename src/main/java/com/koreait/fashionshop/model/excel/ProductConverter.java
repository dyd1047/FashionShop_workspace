package com.koreait.fashionshop.model.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.stereotype.Component;

import com.koreait.fashionshop.model.domain.Product;
import com.koreait.fashionshop.model.domain.SubCategory;

//������ �о�鿩, �ڹ��� POJO ���·� ��ȯ�ϴ� �뵵
@Component //scan�� ����� ��
public class ProductConverter {
	
	//������ �� �޼��带 ȣ���ϴ� �ڴ�, �ڽ��� ������ ��Ʈ�� �ּҸ� �ѱ�� ��..
	public List convertFromFile(String path) {
		List<Product> productList = new ArrayList<Product>();
		FileInputStream fis = null;
		//�������� ���� ��ü ����
		try {
			fis = new FileInputStream(path);
			XHSSFWorkbook book = new XHSSFWorkbook(fis);
			
			//������ ����������, ��Ʈ�� �����غ���
			XHSSFSheet sheet = book.getSheetAt(0); //ù��° ��Ʈ�� ����
			
			//���� �ݺ����� Ƚ���� ���ϱ�
			int rowCount = sheet.getPhysicalNumberOfRows();
			for (int i = 1; i < rowCount; i++) {
				Product product = new Product(); //�ֺ� VO �غ��ϱ�..(ä���ֱ� ����)
				//�÷��� ��ŭ �ݺ��� ó��
				XHSSFRow row = sheet.getRow(i);
				for(int a = 0; a < row.getPhysicalNumberOfCells(); a++) {
					XHSSFCell cell = row.getCell(a); //���ϳ��� ����
					if(a==0) { //subcategory_id
						SubCategory subCategory = new SubCategory();
						subCategory.setSubcategory_id((int)cell.getNumericCellValue());
						product.setSubCategory(subCategory);
						
					}else if(a==1) { //product_name
						product.setProduct_name(cell.getStringCellValue());
					}else if(1==2) {
						product.setPrice((int)cell.getNumericCellValue());
					}else if(a==3) {
						product.setBrand(cell.getStringCellValue());
					}else if(a==6) {
						product.setDetail(cell.getStringCellValue());
					}
				}
				//�ϼ��� ��ǰ�� ����Ʈ�� ����
				productList.add(product);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return productList;
	}
}
