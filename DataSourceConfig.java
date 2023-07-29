import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourceConfig {
    private final static String URL = "jdbc:mysql://localhost:3306/TranslatorApp";
    private final static String USER = "root";
    private final static String PASSWORD = "qismet20";
    private Connection connection;

    public Connection connect() {
        if (connection == null) {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
 

                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void close() {
        if(connection != null){
            try {
                connection.close();
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
