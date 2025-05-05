package com.watso.invoice.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.watso.invoice.entity.InvoiceItem;

@Service
public class PdfGenerator {

	public ByteArrayInputStream generatePdf(List<InvoiceItem> items) {

		Document document = new Document();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		try {

			PdfWriter.getInstance(document, outputStream);
			document.open();
			Font titlFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 15, BaseColor.BLACK);
			Font headerFont = FontFactory.getFont(FontFactory.HELVETICA, 14);
			Font normalFont = FontFactory.getFont(FontFactory.HELVETICA, 13);

			// Invoice tittle
			Paragraph title = new Paragraph("Invoice", titlFont);
			title.setAlignment(Element.ALIGN_CENTER);
			title.setSpacingAfter(20);
			document.add(title);

			// invoice info
			PdfPTable info = new PdfPTable(2);
			info.setWidthPercentage(100);
			info.setWidths(new int[] { 1, 2 });

			info.addCell(getCell("Customer Name:", headerFont));
			info.addCell(getCell("Anil Kumar Pradhan", normalFont));
			info.addCell(getCell("Invoice No:", headerFont));
			info.addCell(getCell("753672", normalFont));
			info.addCell(getCell("Date:", headerFont));
			info.addCell(getCell("15.02.2025", normalFont));
			info.setSpacingAfter(20);
			document.add(info);
			

            // Table Header
            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            table.setWidths(new int[]{4, 2, 2, 2});

            addTableHeader(table, headerFont, "Item", "Qty", "Unit Price", "Total");
            
            double grandTotal = 0;
            for (InvoiceItem item : items) {
                table.addCell(new PdfPCell(new Phrase(item.getItemName(), normalFont)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(item.getQuantity()), normalFont)));
                table.addCell(new PdfPCell(new Phrase("₹" + item.getUnitPrice(), normalFont)));
                double total = item.getQuantity() * item.getUnitPrice();
                grandTotal += total;
                table.addCell(new PdfPCell(new Phrase("₹" + total, normalFont)));
            }
            
            PdfPCell blankCell = new PdfPCell(new Phrase(""));
            blankCell.setColspan(3);
            blankCell.setBorder(Rectangle.NO_BORDER);
            table.addCell(blankCell);

            PdfPCell totalCell = new PdfPCell(new Phrase("Total: ₹" + grandTotal, headerFont));
            totalCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            table.addCell(totalCell);

            document.add(table);
            document.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ByteArrayInputStream(outputStream.toByteArray());
	}

	// get cell
	private PdfPCell getCell(String text, Font font) {

		PdfPCell cell = new PdfPCell(new Phrase(text, font));
		cell.setBorder(Rectangle.NO_BORDER);

		return cell;
	}

	// add table header
	private void addTableHeader(PdfPTable table, Font font, String... headers) {

		for (String header : headers) {
			PdfPCell cell = new PdfPCell();
			cell.setBackgroundColor(BaseColor.CYAN);
			cell.setPhrase(new Phrase(header, font));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);

			table.addCell(cell);
		}

	}
}
