package com.watso.invoice.controller;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.watso.invoice.entity.InvoiceItem;
import com.watso.invoice.service.ExcelGeneratorService;
import com.watso.invoice.service.PdfGenerator;

@RestController
public class InvoiceController {
	
	@Autowired
	private ExcelGeneratorService excelGeneratorService;
	
	@Autowired
	private PdfGenerator generator;
	
	@GetMapping("/download/invoice")
	public ResponseEntity<?> generateExcelInvoive(){
		
		List<InvoiceItem> items = Arrays.asList(new InvoiceItem("pen",5,2.8 ),
				new InvoiceItem("Book", 10, 150),
				new InvoiceItem("Pencil", 7, 4.2),
				new InvoiceItem("Geometry Box", 2, 320)
				);
		ByteArrayInputStream generateExcelByteArray = excelGeneratorService.generateExcelByteArray(items);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=invoice.xlsx");
		
		return ResponseEntity.ok()
				.headers(headers)
				.contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
				.body(new InputStreamResource(generateExcelByteArray));
		
		
		
		
	}
	@GetMapping("download/pdf")
	public ResponseEntity<?> downloadPdfFormatInvoice(){
		
		List<InvoiceItem> items = Arrays.asList(new InvoiceItem("pen",5,2.8 ),
				new InvoiceItem("Book", 10, 150),
				new InvoiceItem("Pencil", 7, 4.2),
				new InvoiceItem("Geometry Box", 2, 320)
				);
		ByteArrayInputStream generatePdf = generator.generatePdf(items);
		
		return ResponseEntity.ok()
				.header("Content-Disposition", "inline; filename=invoice.pdf")
				.contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(generatePdf));
		
	}

}
