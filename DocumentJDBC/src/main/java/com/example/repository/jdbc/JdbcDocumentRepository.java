package com.example.repository.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.Document;
import com.example.repository.DocumentRepository;
import com.example.utils.RowMap;

@Repository
public class JdbcDocumentRepository implements DocumentRepository {
	private static final RowMapper<Document> DOCUMENT_ROW_MAPPER = new RowMap();
	private NamedParameterJdbcTemplate temp;

	@Autowired
	public JdbcDocumentRepository(NamedParameterJdbcTemplate temp) {
		this.temp = temp;
	}

	@Override
	public Iterable<Document> getDocuments() {
		String sql = "select DOCUMENT_ID, DOCUMENT_NAME,CREATED_ON from DOCUMENT order by DOCUMENT_NAME";
		List<Document> documents = temp.query(sql, DOCUMENT_ROW_MAPPER);
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

	@Override
	public Optional<Document> findById(long id) {
		String sql = "select DOCUMENT_ID, DOCUMENT_NAME, CREATED_ON from DOCUMENT d where d.DOCUMENT_ID = :documentId ";
		Map<String, Object> params = new HashMap<>();
		params.put("documentId", id);
		List<Document> documents = temp.query(sql, params, DOCUMENT_ROW_MAPPER);
		return documents.size() == 1 ? Optional.of(documents.get(0)) : Optional.empty();
	}

	@Override
	public void updateDocument(long id, Document document) {
		Map<String, Object> documentMap = new HashMap<String, Object>();
		documentMap.put("documentId", id);
		documentMap.put("name", document.getName());
		documentMap.put("createdOn", document.getCreatedOn());
		String sql = "update Document d set d.DOCUMENT_NAME = :name, d.CREATED_ON=:createdOn where d.DOCUMENT_ID = :documentId";
		temp.update(sql, documentMap);
	}

	@Override
	public void deleteDocument(long id) {
		Map<String, Object> documentMap = new HashMap<String, Object>();
		documentMap.put("documentId", id);
		temp.update("delete Document d where d.DOCUMENT_ID = :documentId", documentMap);
	}
}
