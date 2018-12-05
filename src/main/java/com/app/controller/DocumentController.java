package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Document;
import com.app.service.IDocumentService;

@Controller
@RequestMapping("/document")
public class DocumentController {

	@Autowired
	private IDocumentService service;

	@RequestMapping("/show")
	public String showDocument(ModelMap map) {
		List<Object[]> list = service.getDocumentIdAndName();
		map.addAttribute("docs", list);
		return "Document";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadDocument(@RequestParam CommonsMultipartFile file, ModelMap map) {
		if (file!= null) {

			Document d = new Document();
			d.setFileName(file.getOriginalFilename());
			d.setFileData(file.getBytes());
			Integer id = service.saveDocument(d);
			String msg = "Document '" + id + "' Saved Successfully...";
			// read all file name,Id from Database
			List<Object[]> docs = service.getDocumentIdAndName();
			map.addAttribute("message", msg);
			map.addAttribute("docs", docs);
		}
		return "Document";
	}

	@RequestMapping("/dow")
	public void downloadDocument(@RequestParam("id") Integer fileId, HttpServletResponse res) {

		Document doc = service.getDocumentById(fileId);
		res.addHeader("Content-Disposition", "attachment;filename= " + doc.getFileName());
		try {
			FileCopyUtils.copy(doc.getFileData(), res.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
