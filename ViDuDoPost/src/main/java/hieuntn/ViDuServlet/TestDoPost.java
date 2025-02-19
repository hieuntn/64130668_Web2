package hieuntn.ViDuServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestDoPost")
public class TestDoPost extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public TestDoPost() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter pw = response.getWriter();

        String ndHTML = "<html>\n<head>\n"
                + "<style>\n"
                + "body { text-align: center; font-size: 20px; }\n"
                + "form { display: inline-block; margin-top: 20px; }\n"
                + "</style>\n</head>\n"
                + "<body>\n"
                + "<form method='POST' action='/ViDuDoPost/TestDoPost'>\n"
                + "<h2>Nhập vào tham số a và b</h2>\n"
                + "<label for='a'>Tham số a:</label><br>\n"
                + "<input type='text' name='a'><br><br>\n"
                + "<label for='b'>Tham số b:</label><br>\n"
                + "<input type='text' name='b'><br><br>\n"
                + "<input type='submit' value='Gửi'>\n"
                + "</form>\n"
                + "</body>\n</html>";

        pw.append(ndHTML);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter pw = response.getWriter();

        String value1 = request.getParameter("a");
        String value2 = request.getParameter("b");

        pw.append("<html>\n<head>\n"
                + "<style>\n"
                + "body { text-align: center; font-size: 20px; margin-top: 20px; }\n"
                + "</style>\n</head>\n"
                + "<body>\n"
                + "<div>\n"
                + "Tham số a có giá trị là: " + value1 + "<br>\n"
                + "Tham số b có giá trị là: " + value2 + "<br><br>\n"
                + "<a href='/ViDuDoPost/TestDoPost'>Quay lại form</a>\n"
                + "</div>\n"
                + "</body>\n</html>");
    }
}