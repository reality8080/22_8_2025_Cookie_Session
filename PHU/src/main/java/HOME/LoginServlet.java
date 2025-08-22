package HOME;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = {"/login", "/login/"})
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        if (user != null && pass != null && user.equals("Phu") && pass.equals("123")) {
            Cookie cookie = new Cookie("username", user);
            cookie.setMaxAge(30); // Cookie expires in 30 seconds
            cookie.setPath("/PHU"); // Ensure cookie is accessible under /PHU
            response.addCookie(cookie);
            response.sendRedirect(request.getContextPath() + "/hello/");
        } else {
            response.sendRedirect(request.getContextPath() + "/login/");
        }
    }
}
