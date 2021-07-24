package com.mycompany.healthcare;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/", "/main", "/login", "/manage", "/guideline", "/result", "/result/specimennum", "/teststate", "/diagnosis", "/receipt", "/reserve", "/page403", "/page404"}, method = RequestMethod.GET)
	public String home() {
		return "/index.html";
	}
	
	@GetMapping("/image")
	@ResponseBody
	public String getImage(String path, HttpServletResponse response) {
		String filePath = System.getProperty("user.home") + "/images/" + path;
		logger.info(filePath);
		if(path.equals("undefined")) {
			return null;
		}
		try {
			response.setHeader("Content-Disposition", "attachment;");
			response.setContentType("image/jpeg");
			InputStream is = new FileInputStream(filePath);
			OutputStream os = response.getOutputStream();
			FileCopyUtils.copy(is, os);
			is.close();
			os.flush();
			os.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "home";
	}
	
}
