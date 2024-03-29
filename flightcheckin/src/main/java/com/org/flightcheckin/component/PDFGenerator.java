package com.org.flightcheckin.component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.org.flightcheckin.integeration.dto.Reservation;

@Component
public class PDFGenerator {

	public void generateItinerary(Reservation reservation, String filePath) {

		Document document = new Document();

		try {
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
			document.open();
			document.add(new PdfPTable(2));
			document.close();

		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}

}
