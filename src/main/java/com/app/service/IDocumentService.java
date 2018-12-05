package com.app.service;

import java.util.List;

import com.app.model.Document;

public interface IDocumentService {
	public Integer saveDocument(Document doc);

	public List<Object[]> getDocumentIdAndName();

	public Document getDocumentById(int docId);
}
