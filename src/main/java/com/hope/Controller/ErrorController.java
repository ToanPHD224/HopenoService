package com.hope.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

	@RequestMapping("/error")
	@ResponseBody
	public String handleError(HttpServletRequest request) {
		String rq = request.getRequestURI();
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if (status != null) {
			Integer statusCode = Integer.valueOf(status.toString());
			if (statusCode == HttpStatus.NOT_FOUND.value()) {
				return "error-404"+ " " + rq  +" This is lỗi 404 ";
			} else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				return "error-500"+ " " + rq  +" This is lỗi 500 ";
			}
		}
		
		
		return "error" +status+ " " +rq  +" This is lỗi  ";
	}

	@Override
	@ResponseBody
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}

}
