package com.app.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "doctab")
public class Document {
	@Id
	@GeneratedValue(generator = "document_gen")
	@GenericGenerator(name = "document_gen", strategy = "increment")
	@Column(name = "fId")
	private int fileId;

	@Column(name = "fName")
	private String fileName;
	@Lob
	@Column(name = "fData")
	private byte[] fileData;

	public Document() {
		super();
	}

	public Document(int fileId) {
		super();
		this.fileId = fileId;
	}

	public Document(int fileId, String fileName, byte[] fileData) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.fileData = fileData;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	@Override
	public String toString() {
		return "Document [fileId=" + fileId + ", fileName=" + fileName + ", fileData=" + Arrays.toString(fileData)
				+ "]";
	}

}
