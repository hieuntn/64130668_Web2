package ntnhieu.viduServlet;


import java.io.IOException;
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
        PrintWriter pw = response.getWriter();	
        pw.println("<!DOCTYPE html>");
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<meta charset='UTF-8'>");
        pw.println("<title>Thông tin cá nhân</title>");
        pw.println("<style>");
        pw.println("  body {");
        pw.println("    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;");
        pw.println("    line-height: 1.6;");
        pw.println("    color: #333;");
        pw.println("    max-width: 600px;");
        pw.println("    margin: 0 auto;");
        pw.println("    padding: 20px;");
        pw.println("    background-color: #f9f9f9;");
        pw.println("  }");
        pw.println("  .container {");
        pw.println("    background-color: white;");
        pw.println("    border-radius: 8px;");
        pw.println("    box-shadow: 0 2px 4px rgba(0,0,0,0.1);");
        pw.println("    padding: 25px;");
        pw.println("  }");
        pw.println("  h1 {");
        pw.println("    color: #2c3e50;");
        pw.println("    text-align: center;");
        pw.println("    border-bottom: 2px solid #3498db;");
        pw.println("    padding-bottom: 10px;");
        pw.println("    margin-bottom: 20px;");
        pw.println("  }");
        pw.println("  .info-item {");
        pw.println("    margin-bottom: 15px;");
        pw.println("    display: flex;");
        pw.println("  }");
        pw.println("  .info-label {");
        pw.println("    font-weight: bold;");
        pw.println("    min-width: 120px;");
        pw.println("    color: #3498db;");
        pw.println("  }");
        pw.println("  .info-value {");
        pw.println("    flex: 1;");
        pw.println("  }");
      
        
        pw.println("</style>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<div class='container'>");
        
      
        
        // Tiêu đề
        pw.println("<h1>Thông tin cá nhân</h1>");
        
        // Thông tin cá nhân - thay thế bằng thông tin của bạn
        pw.println("<div class='info-item'>");
        pw.println("  <div class='info-label'>Họ và tên:</div>");
        pw.println("  <div class='info-value'>Nguyễn Thị Ngọc Hiếu</div>");
        pw.println("</div>");
        
        pw.println("<div class='info-item'>");
        pw.println("  <div class='info-label'>Lớp:</div>");
        pw.println("  <div class='info-value'>64 CNTTCLC</div>");
        pw.println("</div>");
        
        pw.println("<div class='info-item'>");
        pw.println("  <div class='info-label'>Trường:</div>");
        pw.println("  <div class='info-value'>Đại học Nha Trang </div>");
        pw.println("</div>");
        
        pw.println("<div class='info-item'>");
        pw.println("  <div class='info-label'>Gmail:</div>");
        pw.println("  <div class='info-value'>hieuntn@gmail.com</div>");
        pw.println("</div>");
        
        pw.println("<div class='info-item'>");
        pw.println("  <div class='info-label'>Số điện thoại:</div>");
        pw.println("  <div class='info-value'>012346789</div>");
        pw.println("</div>");
        
       ;
        
        pw.println("</div>");
        pw.println("</body>");
        pw.println("</html>");
    }
}