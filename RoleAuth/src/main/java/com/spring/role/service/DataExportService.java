package com.spring.role.service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.wp.usermodel.Paragraph;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.itextpdf.io.font.woff2.Woff2Common.Table;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.property.TextAlignment;
import com.spring.role.entity.Employee;


@Controller
public class DataExportService {
	@Autowired
	private EmployeeService employeeService;
	
	public byte[] generateExcel() {
		
		try {
			
			List<Employee> employees = employeeService.findAll();
			
			Workbook workbook = new XSSFWorkbook();
			Sheet sheet = workbook.createSheet("Employee_list");
			
			Row headerRow= sheet.createRow(0);
			String[] headers= {"Id","Name","E-mail","Roles","Address"};
			for(int i=0;i<headers.length;i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(headers[i]);
				/* cell.setCellStyle(); */
			}
			
			Integer rowIndex=1;
			for(Employee employee :employees) {
				Row createRow = sheet.createRow(rowIndex++);
				createRow.createCell(0).setCellValue(employee.getId());
				createRow.createCell(1).setCellValue(employee.getName());
				createRow.createCell(2).setCellValue(employee.getEmail());
				
				String roles = employee.getRoles().stream()
						.map(r->r.getName().name())
						.collect(Collectors.joining(", "));
				createRow.createCell(3).setCellValue(roles);
				 
				String address = employee.getAddresses().stream()
	                        .map(Object::toString)
	                        .collect(Collectors.joining(", ")); 
				createRow.createCell(4).setCellValue(address);
			}
			
			for(int i =0;i<headers.length;i++) {
				sheet.autoSizeColumn(i);
			}
			
			ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
			workbook.write(arrayOutputStream);
			workbook.close();
			
			return arrayOutputStream.toByteArray();
			
		}catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
		
	}
	
	//Generate pdf 
	
	/*
	 * public byte[] generatePdf() { try (ByteArrayOutputStream outputStream = new
	 * ByteArrayOutputStream()) {
	 * 
	 * // Create PDF Document PdfWriter writer = new PdfWriter(outputStream);
	 * PdfDocument pdfDocument = new PdfDocument(writer); Document document = new
	 * Document(pdfDocument);
	 * 
	 * // Add Title Paragraph title = new Paragraph("Employee List")
	 * .setTextAlignment(TextAlignment.CENTER) .setBold() .setFontSize(18);
	 * document.add(title); document.add(new Paragraph("\n"));
	 * 
	 * // Fetch Employees List<Employee> employees = employeeService.findAll();
	 * 
	 * // Create Table float[] columnWidths = {50f, 120f, 150f, 150f, 200f}; Table
	 * table = new Table(columnWidths); table.setWidthPercent(100);
	 * 
	 * // Add Table Headers String[] headers = {"ID", "Name", "Email", "Roles",
	 * "Address"}; for (String header : headers) { table.addCell(new Cell().add(new
	 * Paragraph(header).setBold())); }
	 * 
	 * // Add Employee Data to Table for (Employee employee : employees) {
	 * table.addCell(String.valueOf(employee.getId()));
	 * table.addCell(employee.getName()); table.addCell(employee.getEmail());
	 * 
	 * String roles = employee.getRoles().stream() .map(r -> r.getName().name())
	 * .collect(Collectors.joining(", ")); table.addCell(roles);
	 * 
	 * String address = employee.getAddresses().stream() .map(Object::toString)
	 * .collect(Collectors.joining(", ")); table.addCell(address); }
	 * 
	 * // Add Table to Document document.add(table); document.close();
	 * 
	 * return outputStream.toByteArray(); } catch (Exception e) {
	 * e.printStackTrace(); return null; } }
	 */
}
