package hieuntn.ViDuServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HelloWorld") // URL sẽ truy cập Sevelet này
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
       // khơit tạo nếu có
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Biến request sẽ lưu thông tin yêu cầu
		// Biến response đại diện kết quả trả về cho người dùng
		// luồng xuất, trả dữ liệu về cho clinet, để ghi dữ liệu ta dùng write của dối tượng respone
		PrintWriter wt = response.getWriter();
		
		// lấy dữ liẹu từ tham số URL
		// giả sử có dạng /HelloWorld?ten=NguyenThiNgocHieu
		String valueNhanDuoc = request.getParameter("ten");
		wt.println("<h1> Good morning<h/1>");
		wt.println(valueNhanDuoc);
		
		
	}

}
