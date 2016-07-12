package com.example.repository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.Document;
import com.example.repository.DocumentRepository;

@Repository
public class JdbcDocumentRepository implements DocumentRepository {
	private NamedParameterJdbcTemplate temp;

	@Autowired
	public JdbcDocumentRepository(NamedParameterJdbcTemplate temp) {
		this.temp = temp;
	}

	@Override
	public Iterable<Document> getDocuments() {
		List<Document> documents = temp.query("select DOCUMENT_ID, DOCUMENT_NAME,CREATED_ON from DOCUMENT order by DOCUMENT_ID",
				new RowMapper<Document>() {
					public Document mapRow(ResultSet rs, int rowNum) throws SQLException {
						Document document = new Document();
						document.setId(rs.getLong("DOCUMENT_ID"));
						document.setName(rs.getString("DOCUMENT_NAME"));
						document.setCreatedOn(rs.getDate("CREATED_ON"));
						return document;
					}
				});
		return documents;
	}

	@Override
	public void addDocument(Document doc) {
		StringBuilder sb = new StringBuilder();
		sb.append("insert into document (DOCUMENT_ID, DOCUMENT_NAME, CREATED_ON) values ");
		sb.append("(offerdocs_seq.nextval,:name, :createdOn)");
		
		Map<String, Object> documentMap = new HashMap<String, Object>();
		documentMap.put("name", doc.getName());
		documentMap.put("createdOn", doc.getCreatedOn());
		temp.update(sb.toString(), documentMap);
		
	}

}
