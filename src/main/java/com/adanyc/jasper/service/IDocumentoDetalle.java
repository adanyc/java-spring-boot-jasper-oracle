package com.adanyc.jasper.service;

import java.util.List;

import com.adanyc.jasper.model.DocumentoDetalle;

public interface IDocumentoDetalle {
	public abstract List<DocumentoDetalle> documentoDetalle(int numDocumento);
}
