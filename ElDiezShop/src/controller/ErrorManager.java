package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public class ErrorManager {

	private StringBuilder data = new StringBuilder();

	public void notice(String field, String msg) throws IOException {
		data.append("notice=");
		data.append(field);
		data.append(":");
		data.append(msg);
		data.append("&");
	}

	public void message(String msg) throws IOException {
		data.append("message=");
		data.append(msg);
		data.append("&");
	}

	public void done(String msg) throws IOException {
		data.append("done=");
		data.append(msg);
		data.append("&");
	}

	public void redirect(String msg) throws IOException {
		data.append("redirect=");
		data.append(msg);
		data.append("&");
	}

	public void apply(HttpServletResponse resp, String location) throws IOException {
		
	}

	
	public String toString() {
		return data.toString();
	}

}
