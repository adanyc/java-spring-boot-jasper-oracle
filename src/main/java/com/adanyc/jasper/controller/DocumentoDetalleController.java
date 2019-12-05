package com.adanyc.jasper.controller;

import java.io.ByteArrayOutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adanyc.jasper.service.IDocumentoDetalle;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
public class DocumentoDetalleController {
	@Autowired
	private IDocumentoDetalle documentoDetalle;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	private ResourceLoader resourceLoader;

	@RequestMapping(path = { "/index", "/" })
	public String inicializa(Model model) {
		model.addAttribute("lista", documentoDetalle.documentoDetalle(1));
		return "index";
	}

	@RequestMapping(path = "/exportarPDF/{doc}")
	public void exportarPDF(Model model, @PathVariable(name = "doc") int doc, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ByteArrayOutputStream baos = null;
		ServletOutputStream out = null;
		try {
			Connection cn = jdbcTemplate.getDataSource().getConnection();
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("P_RAZON_SOCIAL", "ALEX DANIEL CABELLO LEON");
			params.put("P_NUM_DOC", 1);
			String jasper = resourceLoader.getResource("classpath:/static/reports/Factura.jasper").getURI().getPath();
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasper, params, cn);
			String filename = "REPORTE.pdf";
			baos = new ByteArrayOutputStream();
			response.setContentType("application/pdf");
			response.setHeader("content-disposition", "attachment; filename=\"" + filename + "\"");
			JasperExportManager.exportReportToPdfStream(jasperPrint, baos);
			response.setContentLength(baos.size());
			out = response.getOutputStream();
			baos.writeTo(out);
		} catch (Exception e) {
			throw e;
		} finally {
			if (baos != null) {
				baos.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
}
