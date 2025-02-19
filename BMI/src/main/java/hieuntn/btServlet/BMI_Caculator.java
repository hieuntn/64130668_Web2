package hieuntn.btServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BMI_Caculator
 */
@WebServlet("/BMI_Caculator")
public class BMI_Caculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BMI_Caculator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter pw = response.getWriter();

        String ndHTML = "<html>\n<head>\n"
                + "<style>\n"
                + "body { text-align: center; font-size: 20px; }\n"
                + "form { display: inline-block; margin-top: 20px; }\n"
                + "input { margin: 5px; padding: 5px; }\n"
                + "</style>\n</head>\n"
                + "<body>\n"
                + "<form method='POST' action='/BMI/BMI_Caculator'>\n"
                + "<h2>Tính Chỉ Số BMI</h2>\n"
                + "<label for='height'>Chiều cao (cm):</label><br>\n"
                + "<input type='number'  name='height' ><br><br>\n"
                + "<label for='weight'>Cân nặng (kg):</label><br>\n"
                + "<input type='number'  name='weight'><br><br>\n"
                + "<input type='submit' value='Tính BMI'>\n"
                + "</form>\n"
                + "</body>\n</html>";

        pw.append(ndHTML);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter pw = response.getWriter();

        try {
            double height = Double.parseDouble(request.getParameter("height")) / 100; 
            double weight = Double.parseDouble(request.getParameter("weight"));
            
            double bmi = weight / (height * height);
            String category = getBMICategory(bmi);

            pw.append("<html>\n<head>\n"
                    + "<style>\n"
                    + "body { text-align: center; font-size: 20px; margin-top: 20px; }\n"
                    + ".result { color: blue; font-weight: bold; }\n"
                    + "</style>\n</head>\n"
                    + "<body>\n"
                    + "<div>\n"
                    + "<h2>Kết Quả Tính BMI</h2>\n"
                    + "Chiều cao: " + (height * 100) + " cm<br>\n"
                    + "Cân nặng: " + weight + " kg<br><br>\n"
                    + "<div class='result'>\n"
                    + "Chỉ số BMI của bạn là: " + String.format("%.2f", bmi) + "<br>\n"
                    + "Phân loại: " + category + "<br><br>\n"
                    + "</div>\n"
                    + "<a href='/BMI/BMI_Caculator'>Tính lại</a>\n"
                    + "</div>\n"
                    + "</body>\n</html>");
        } catch (NumberFormatException e) {
            pw.append("<html><body>\n"
                    + "<h2>Lỗi: Vui lòng nhập số hợp lệ</h2>\n"
                    + "<a href='/BMI/BMI_Caculator'>Quay lại</a>\n"
                    + "</body></html>");
        }
    }

    private String getBMICategory(double bmi) {
        if (bmi < 18.5) return "Thiếu cân";
        else if (bmi < 25) return "Bình thường";
        else if (bmi < 30) return "Thừa cân";
        else return "Béo phì";
    }
}