package com.shopme.admin.user.export;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;


public class AbstractExporter {
	
	public void setResponseHeader(HttpServletResponse response, String contentType,
			String extension) throws IOException {
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String timestamp = dateFormatter.format(new Date());
		String fileName = "users_" + timestamp + extension;

		response.setContentType(contentType);

		String headerKey = "Content-Disposition";
		String headerValue = "attachments; filename=" + fileName;
		response.setHeader(headerKey, headerValue);

		
	}
}
