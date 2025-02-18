package ntnhieu.viduServlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AboutMe")
public class AboutMe extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AboutMe() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Thiết lập kiểu nội dung là HTML
        response.setContentType("text/html; charset=UTF-8");

        // Đọc file HTML từ thư mục webapp
        InputStream inputStream = getServletContext().getResourceAsStream("/index.html");
        if (inputStream != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
                // Đọc từng dòng của file HTML
                StringBuilder htmlContent = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    htmlContent.append(line).append("\n");
                }

                // Gửi nội dung HTML đến client
                PrintWriter out = response.getWriter();
                out.println(htmlContent.toString());
            }
        } else {
            // Nếu không tìm thấy file, gửi thông báo lỗi
            response.getWriter().println("File not found!");
        }
    }
}