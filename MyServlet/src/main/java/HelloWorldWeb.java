
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloWorldWeb extends HttpServlet {
        @Override
        public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
                throws IOException {
            httpServletResponse.getWriter().print("Hello world!");
        }
    }

