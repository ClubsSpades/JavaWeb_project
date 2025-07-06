package class7;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/score")
public class ReasultServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String answersStr = request.getParameter("answers");
        String correctAnswersStr = request.getParameter("correctAnswers");
        String currentAnswer = request.getParameter("answer");
        String num1Str = request.getParameter("num1");
        String num2Str = request.getParameter("num2");

        if (currentAnswer != null && num1Str != null && num2Str != null) {
            try {
                int userAnswer = Integer.parseInt(currentAnswer);
                int num1 = Integer.parseInt(num1Str);
                int num2 = Integer.parseInt(num2Str);
                int correctAnswer = num1 * num2;
                answersStr = answersStr == null ? String.valueOf(userAnswer) : answersStr + "," + userAnswer;
                correctAnswersStr = correctAnswersStr == null ? String.valueOf(correctAnswer) : correctAnswersStr + "," + correctAnswer;
            } catch (NumberFormatException e) {
                answersStr = answersStr == null ? "0" : answersStr + ",0";
                correctAnswersStr = correctAnswersStr == null ? "0" : correctAnswersStr + ",0";
            }
        }

        int correctCount = 0;
        if (answersStr != null && correctAnswersStr != null) {
            String[] answers = answersStr.split(",");
            String[] correctAnswers = correctAnswersStr.split(",");
            for (int i = 0; i < answers.length && i < correctAnswers.length; i++) {
                try {
                    if (Integer.parseInt(answers[i]) == Integer.parseInt(correctAnswers[i])) {
                        correctCount++;
                    }
                } catch (NumberFormatException e) {
                    
                }
            }
        }

        int score = correctCount == 4 ? 100 : correctCount == 3 ? 75 : correctCount * 25;

        request.setAttribute("score", score);

        request.getRequestDispatcher("/WEB-INF/jsp/score.jsp").forward(request, response);
    }
}