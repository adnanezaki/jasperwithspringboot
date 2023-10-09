package com.tuto.Document.Report;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@SpringBootApplication
public class DocumentReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocumentReportApplication.class, args);

		String filePath = "C:\\Users\\dell\\JaspersoftWorkspace\\MyReports\\Blank_A4.jrxml";
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("nomdeContract", "Nom du contrat");
		parameters.put("extension de document", "pdf");
		parameters.put("association", "hbm");
		parameters.put("sg", "M. XYZ");

		try {
			JasperReport report = JasperCompileManager.compileReport(filePath);
			JasperPrint print = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
			JasperExportManager.exportReportToPdfFile(print, "C:\\Users\\Adnane ZAKI\\Desktop\\cdd.pdf");
			System.out.println("Le rapport a été généré avec succès !");
		} catch (JRException e) {
			e.printStackTrace();
			System.err.println("Une erreur s'est produite lors de la génération du rapport : " + e.getMessage());
		}
	}
}
