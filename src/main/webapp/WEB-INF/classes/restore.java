import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/restore")
public class restore extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET");
        getServletContext().getRequestDispatcher("/jsp/restore.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("user");
        User user = UsersDB.selectOne(login);
        if (user != null) {
            UsersDB.update(user);
            req.setAttribute("login", login);
            getServletContext().getRequestDispatcher("/jsp/good_restore.jsp").forward(req, resp);
        }
        else
            getServletContext().getRequestDispatcher("/jsp/bad_restore.jsp").forward(req, resp);
    }
}
