package com.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "upload")
public class UploadController {
	
	/**
	 * 文件上传
	 * multipartFile参数，不可以从request.getAttribute获取，只能通过下面参数的方式
	 * 
	 * @param model
	 * @param request
	 * @param multipartFile
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(ModelMap model, HttpServletRequest request, @RequestParam(value = "myfile") MultipartFile multipartFile) throws Exception {
		
		//log.info(multipartFile.getName());
		File file = new File("d:/my.jpg");
		multipartFile.transferTo(file);
		model.put("status", "success!!!");
		return "success";
	}
	
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void download(HttpServletResponse response) throws Exception {
		OutputStream os = response.getOutputStream();
		response.setContentType("application/x-msdownload");
		response.setHeader("Content-Disposition", "attachment; filename=" + new String("下载文件".getBytes("GB18030"), "ISO8859-1"));
		//方法一:不推荐,原始java.io流操作
//		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("c:/my.txt"));
//		byte[] buffer = new byte[1000];
//		int len = bis.read(buffer);
//		os.write(buffer, 0, len);
		
		//方法二:推荐,借助commons.io.IOUTils
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("d:/my.jpg"));
		byte[] buffer = IOUtils.toByteArray(bis);
		os.write(buffer);
	}
}
