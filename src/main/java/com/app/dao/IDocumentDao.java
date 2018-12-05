package com.app.dao;

import java.util.List;

import com.app.model.Document;

public interface IDocumentDao {
	public Integer saveDocument(Document doc);

	public List<Object[]> getDocumentIdAndName();

	public Document getDocumentById(int docId);
}
