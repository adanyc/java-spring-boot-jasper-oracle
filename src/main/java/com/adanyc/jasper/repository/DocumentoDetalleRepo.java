package com.adanyc.jasper.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.adanyc.jasper.model.DocumentoDetalle;

@Repository
public class DocumentoDetalleRepo {
	@Autowired
	JdbcTemplate jdbcTemplate;

	class DocumentoDetalleRowMapper implements RowMapper<DocumentoDetalle> {
		@Override
		public DocumentoDetalle mapRow(ResultSet rs, int rowNum) throws SQLException {
			DocumentoDetalle obj = new DocumentoDetalle();
			obj.setCodigoItem(rs.getString("CODIGO_ITEM"));
			obj.setDescripcionItem(rs.getString("DESCRIPCION_ITEM"));
			obj.setPrecioUnitario(rs.getDouble("PRECIO_UNITARIO"));
			obj.setCantidad(rs.getInt("CANTIDAD"));
			obj.setDescuento(rs.getDouble("DESCUENTO"));
			return obj;
		}
	}

	public List<DocumentoDetalle> documentoDetalle(int numDocumento) {
		String query = "SELECT CODIGO_ITEM, DESCRIPCION_ITEM, PRECIO_UNITARIO, CANTIDAD, DESCUENTO FROM ADANYC.DETALLE_DOCUMENTO WHERE NUM_DOCUMENTO = "
				+ numDocumento;
		List<DocumentoDetalle> lista = jdbcTemplate.query(query, new DocumentoDetalleRowMapper());
		return lista;
	}

}
