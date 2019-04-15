package Login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet{
    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Login/LoginForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String uName = request.getParameter("username");
        String uPassword = request.getParameter("password");
        response.setContentType("text/html");
        if (LoginCheck.checkLog(uName, uPassword)) {
            request.getRequestDispatcher("user").forward(request,response);
        }
        else
        {
            request.getRequestDispatcher("/Login/LoginFail.jsp").forward(request, response);
        }
    }
}
