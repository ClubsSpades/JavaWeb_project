package class7;

import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public TestServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("questionNumber", 1);
        Random random = new Random();
        int num1 = random.nextInt(9) + 1; 
        int num2 = random.nextInt(9) + 1; 
        request.setAttribute("num1", num1);
        request.setAttribute("num2", num2);
        request.getRequestDispatcher("/WEB-INF/jsp/cal.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String questionNumberStr = request.getParameter("questionNumber");
        int questionNumber = questionNumberStr == null ? 1 : Integer.parseInt(questionNumberStr);

        String answer = request.getParameter("answer");
        String num1Str = request.getParameter("num1");
        String num2Str = request.getParameter("num2");
        String answers = request.getParameter("answers");
        String correctAnswers = request.getParameter("correctAnswers");

        if (answer != null && num1Str != null && num2Str != null) {
            try {
                int userAnswer = Integer.parseInt(answer);
                int num1 = Integer.parseInt(num1Str);
                int num2 = Integer.parseInt(num2Str);
                int correctAnswer = num1 * num2;
                answers = answers == null ? String.valueOf(userAnswer) : answers + "," + userAnswer;
                correctAnswers = correctAnswers == null ? String.valueOf(correctAnswer) : correctAnswers + "," + correctAnswer;
            } catch (NumberFormatException e) {
                answers = answers == null ? "0" : answers + ",0";
                correctAnswers = correctAnswers == null ? "0" : correctAnswers + ",0";
            }
        }

        questionNumber++;

        Random random = new Random();
        int num1 = random.nextInt(9) + 1; 
        int num2 = random.nextInt(9) + 1; 

        request.setAttribute("questionNumber", questionNumber);
        request.setAttribute("num1", num1);
        request.setAttribute("num2", num2);
        request.setAttribute("answers", answers);
        request.setAttribute("correctAnswers", correctAnswers);

        request.getRequestDispatcher("/WEB-INF/jsp/cal.jsp").forward(request, response);
    }
}