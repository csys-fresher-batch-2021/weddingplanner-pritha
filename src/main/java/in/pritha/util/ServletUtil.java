package in.pritha.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public class ServletUtil {
	private ServletUtil() {
		
	}

	public static void sendRedirect(HttpServletResponse response, String url) {
		try {
			response.sendRedirect(url);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
