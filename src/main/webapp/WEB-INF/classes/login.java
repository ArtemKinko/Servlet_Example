import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

@WebServlet(value = "/")
public class login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("user");
        String pass = req.getParameter("pass");
        System.out.println("LOGIN: " + login + ". PASS: " + pass);
        User user = UsersDB.selectOne(login);

        String path = req.getContextPath();

        if (user == null)
            getServletContext().getRequestDispatcher("/jsp/bad_login.jsp").forward(req, resp);
        else {
            if (Objects.equals(pass, user.getPass()))
                resp.sendRedirect(path + "/secret");
            else
                getServletContext().getRequestDispatcher("/jsp/bad_password.jsp").forward(req, resp);
        }
    }
}
