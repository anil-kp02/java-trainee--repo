package com.watso.invoice.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.watso.invoice.entity.InvoiceItem;

@Service
public class ExcelGeneratorService {

	public ByteArrayInputStream generateExcelByteArray(List<InvoiceItem> items) {
		
		try( XSSFWorkbook workkBook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
			
			Sheet sheet = workkBook.createSheet("Invoice");
			
			//Font cell style
			Font titleFont = workkBook.createFont();
			titleFont.setBold(true);
			titleFont.setFontHeight((short) 20);
			titleFont.setColor(IndexedColors.WHITE.getIndex());
			
			CellStyle titleStyle = workkBook.createCellStyle();
			titleStyle.setFont(titleFont);
			titleStyle.setAlignment(HorizontalAlignment.CENTER);
			titleStyle.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
			titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			CellStyle headerStyle = workkBook.createCellStyle();
			
			Font headerFont = workkBook.createFont();
			headerFont.setBold(true);
			
			headerStyle.setFont(headerFont);
			headerStyle.setAlignment(HorizontalAlignment.CENTER);
			headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
			headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			headerStyle.setBorderBottom(BorderStyle.THIN);
			
			CellStyle dataStyle = workkBook.createCellStyle();
			dataStyle.setBorderBottom(BorderStyle.THIN);
			dataStyle.setBorderTop(BorderStyle.THIN);
			dataStyle.setBorderLeft(BorderStyle.THIN);
			dataStyle.setBorderRight(BorderStyle.THIN);
			
			
			CellStyle currencyStyle = workkBook.createCellStyle();
			currencyStyle.cloneStyleFrom(dataStyle);
			currencyStyle.setDataFormat(workkBook.createDataFormat().getFormat("₹#,##0.00"));
		
			
			CellStyle totalCellStyle = workkBook.createCellStyle();
			totalCellStyle.cloneStyleFrom(currencyStyle);
			totalCellStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
			totalCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			Font totalFont = workkBook.createFont();
			totalFont.setBold(true);
			totalCellStyle.setFont(totalFont);
			
			// Company Branding 
			Row brandingRow = sheet.createRow(0);
			Cell companyCell = brandingRow.createCell(0);
			companyCell.setCellValue("Watsoo Express PVT LTD - Invoice");
			companyCell.setCellStyle(titleStyle);
			
			// merge 4 cell to one 
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3)); 
			
			// customer details 
			Row detailedRow = sheet.createRow(2);
			detailedRow.createCell(0).setCellValue("Customer Name :");
			detailedRow.createCell(1).setCellValue(" Anil Kumar Pradhan");
			detailedRow.createCell(2).setCellValue(" Date :");
			detailedRow.createCell(3).setCellValue(new Date());
			
			// Table header 
			Row tableHeader = sheet.createRow(4);
			String[] headers= {"Item ","Quantity ","Unit Price ", "Total "};
			for(int i =0; i< headers.length;i++) {
				Cell cell = tableHeader.createCell(i);
				cell.setCellValue(headers[i]);
				cell.setCellStyle(headerStyle);
			}
			
			// invoice calculation 
			int rowNum =5;
			Double grandTotal=0d;
			for(int i=0; i < items.size() ; i++) {
				
				InvoiceItem item = items.get(i);
				
				Row row = sheet.createRow(rowNum++);
				
				row.createCell(0).setCellValue(item.getItemName());
				row.createCell(1).setCellValue(item.getQuantity());
				row.createCell(2).setCellValue(item.getUnitPrice());
				row.createCell(3).setCellValue(item.getTotal());
				
				row.getCell(0).setCellStyle(dataStyle);
				row.getCell(1).setCellStyle(dataStyle);
				row.getCell(2).setCellStyle(currencyStyle);
				row.getCell(3).setCellStyle(currencyStyle);
				
				if(i % 2==0) {
					for(int j=0;j<4;j++) {
						row.getCell(j).getCellStyle().setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE1.getIndex());
						row.getCell(j).getCellStyle().setFillPattern(FillPatternType.SOLID_FOREGROUND);
					}
				}
				grandTotal+=item.getTotal();
				
				
			}
			// Grand total row 
			Row totalRow = sheet.createRow(rowNum);
			totalRow.createCell(2).setCellValue("Total ");
			totalRow.createCell(3).setCellValue(grandTotal);
			
			totalRow.getCell(2).setCellStyle(totalCellStyle);
			totalRow.getCell(3).setCellStyle(totalCellStyle);
			
			// auto size column 
			for(int k= 0 ; k< 4; k++)
				sheet.autoSizeColumn(k);

			workkBook.write(out);
			
			return new ByteArrayInputStream(out.toByteArray());
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	

}
