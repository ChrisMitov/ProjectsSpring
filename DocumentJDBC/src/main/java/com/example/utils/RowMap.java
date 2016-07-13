package com.example.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.model.Document;

public class RowMap implements RowMapper<Document> {

	@Override
	public Document mapRow(ResultSet rs, int rowNum) throws SQLException {
		Document document = new Document();
		document.setId(rs.getLong("DOCUMENT_ID"));
		document.setName(rs.getString("DOCUMENT_NAME"));
		document.setCreatedOn(rs.getDate("CREATED_ON"));
		return document;
	}

}
