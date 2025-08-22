package HOME;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet(urlPatterns = { "/hello/", "/hello" })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String message;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloServlet() {
		super();
	}

	@SuppressWarnings("serial")
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		message = "Hello World";
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
//		
		String name = "";
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("username")) {
					name = c.getValue();
					break;
				}
			}
		}
		if (name.isEmpty()) { // Use isEmpty() for clarity
			response.sendRedirect(request.getContextPath() + "/login/"); // Include context path
		} else {
			PrintWriter printwriter = response.getWriter();
			printwriter.println("Xin chao " + name);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
