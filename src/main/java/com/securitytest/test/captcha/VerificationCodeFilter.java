package com.securitytest.test.captcha;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

public class VerificationCodeFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if(!"/auth/form".equals(request.getRequestURI())) {
			filterChain.doFilter(request, response);
		}else {
			String imageCode = request.getParameter("captcha");
			HttpSession session = request.getSession();
			String savedImageCode = (String) session.getAttribute("captcha");
			if(!StringUtils.isEmpty(savedImageCode)) {
				session.removeAttribute("captcha");
				if(!savedImageCode.equals(imageCode)) {
					throw new VerificationCodeException("图形验证码校验失败");
				}
			}
			filterChain.doFilter(request, response);
		}

	}

}
