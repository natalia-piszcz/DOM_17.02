package np;
/*Zdefiniuj program, w którym znajduje się pole tekstowe (do wprowadzenia większej ilości tekstu
        możesz wykorzystać znacznik <textarea> zamiast <input>).
        Po wysłaniu formularza użytkownik powinien zobaczyć w wyniku przesłany tekst oraz informacje o:
        ilości wszystkich znaków
        ilość znaków bez spacji
        ilości wyrazów w tekście
        czy tekst jest palindromem (czytany wspak jest identyczny z oryginalnym)*/

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/text")
public class text extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String userText = request.getParameter("userText");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println(userText);

        writer.println("Ilość znaków = " + userText.length());

        int space = 0;
        for (int i = 0; i < userText.length(); i++) {
            if (userText.charAt(i) == '\u0020') {
                space++;
            }
        }
        writer.println("Ilość znaków bez spacji = " + (userText.length() - space));

        if (new StringBuilder(userText).reverse().toString().equals(userText)) {
            writer.println("Tekst jest palindromem");
        } else {
            writer.println("Tekst nie jest palindromem");
        }

        String word = userText.trim();
        if (word.isEmpty()  ) {
            writer.println("Ilość słów = 0");
        }
        writer.println("Ilość słów: " + word.split(" ").length);
    }
}
