package com.securitytest.test.captcha;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.util.StringUtils;

public class MyWebAuthenticationDetails extends WebAuthenticationDetails {

	private boolean imageCodeIsRight;
	
	public boolean getImageCodeIsRight() {
		return imageCodeIsRight;
	}

	public MyWebAuthenticationDetails(HttpServletRequest request) {
		super(request);
		String imageCode = request.getParameter("captcha");
		HttpSession session = request.getSession();
		String savedImageCode = (String) session.getAttribute("captcha");
		if(!StringUtils.isEmpty(savedImageCode)) {
			session.removeAttribute("captcha");
			if(savedImageCode.equals(imageCode)) {
				imageCodeIsRight = true;
			}
		}	
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8857935051804557638L;

}
