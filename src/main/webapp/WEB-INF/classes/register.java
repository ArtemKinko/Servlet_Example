import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/register")
public class register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET");
        getServletContext().getRequestDispatcher("/jsp/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("user");
        String pass = req.getParameter("pass");
        String email = req.getParameter("email");
        User user = UsersDB.selectOne(login);

        String path = req.getContextPath();

        if (user == null) {
            if (login.equals("") || email.equals("") || pass.equals(""))
                getServletContext().getRequestDispatcher("/jsp/bad_register.jsp").forward(req, resp);
            else {
                user = new User(login, pass, email);
                if (UsersDB.insert(user) != 0)
                    getServletContext().getRequestDispatcher("/jsp/good_register.jsp").forward(req, resp);
                else
                    getServletContext().getRequestDispatcher("/jsp/bad_register.jsp").forward(req, resp);
            }
        }
        else
            getServletContext().getRequestDispatcher("/jsp/bad_register.jsp").forward(req, resp);
    }
}
