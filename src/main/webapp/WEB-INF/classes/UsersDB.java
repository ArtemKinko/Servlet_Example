import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class UsersDB {

    private static String url = "jdbc:mysql://localhost/usersdb?serverTimezone=Europe/Moscow&useSSL=false";
    private static String username = "root";
    private static String password = "~WJd5b8VbHvoykC*n";

    // метод получения пользователя по ID
    public static User selectOne(String login) {
        User user = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                String sql = "SELECT * FROM users WHERE login=?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, login);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {

                        String pass = resultSet.getString(2);
                        String email = resultSet.getString(3);
                        user = new User(login, pass, email);
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    // метод добавления в таблицу пользователя
    public static int insert(User user) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                String sql = "INSERT INTO users (login, pass, email) Values (?, ?, ?)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, user.getLogin());
                    preparedStatement.setString(2, user.getPass());
                    preparedStatement.setString(3, user.getEmail());

                    return preparedStatement.executeUpdate();
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    // метод обновления данных пользователя
    public static int update(User user) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                String sql = "UPDATE users SET pass = ?, email = ? WHERE login = ?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, "123456");
                    preparedStatement.setString(2, user.getEmail());
                    preparedStatement.setString(3, user.getLogin());

                    return preparedStatement.executeUpdate();
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public static int delete(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                String sql = "DELETE FROM users WHERE login = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setInt(1, id);

                    return preparedStatement.executeUpdate();
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
