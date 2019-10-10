package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorParser {

	private HttpServletRequest request;

	public ErrorParser(HttpServletRequest request) {
		this.request = request;
	}

	public String parse(HttpServletResponse response) throws IOException {
		String notice = request.getParameter("notice");
		String message = request.getParameter("message");
		String done = request.getParameter("done");
		String redirect = request.getParameter("redirect");
		StringBuilder result = new StringBuilder();
		if (notice != null) {
			System.out.println();
			result.append(notice);
		}
		if (message != null) {
			System.out.println();
			result.append(message);
		}
		if (done != null) {
			System.out.println();
			result.append(done);
		}
		if (redirect != null) {
			System.out.println();
			response.sendRedirect(redirect);
			return "";
		}
		return result.toString();
	}

}
