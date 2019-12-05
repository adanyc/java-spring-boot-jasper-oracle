package com.adanyc.jasper.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adanyc.jasper.model.DocumentoDetalle;
import com.adanyc.jasper.repository.DocumentoDetalleRepo;
import com.adanyc.jasper.service.IDocumentoDetalle;

@Service
public class DocumentoDetalleService implements IDocumentoDetalle {

	@Autowired
	private DocumentoDetalleRepo documentoDetalleRepo;

	@Override
	public List<DocumentoDetalle> documentoDetalle(int numDocumento) {
		return documentoDetalleRepo.documentoDetalle(numDocumento);
	}

}
