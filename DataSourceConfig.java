import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSourceConfig {

     public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/TranslatorApp"; 
        String user = "root"; 
        String password = "qismet20"; 

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            
            Connection connection = DriverManager.getConnection(url, user, password);
                        
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        

        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            Connection connection = DriverManager.getConnection(url, user, password);

            
            String createTableQuery = "CREATE TABLE translations (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "source_language VARCHAR(50) NOT NULL," +
                    "target_language VARCHAR(50) NOT NULL," +
                    "source_text TEXT NOT NULL," +
                    "translated_text TEXT," +
                    "date_added TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                    ")";

           
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(createTableQuery);
                System.out.println("Tablo oluşturuldu: translations");
            }

            
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
     * create DB connection with Singleton Pattern and returns it
     * what is Singleton Pattern? you can read it her < https://www.baeldung.com/java-singleton >
     * 
     * return Connection
     */
    public void connect (){
                    

    }

    /*
     * Closes DB connection
     */
    public void close (){
        
    }
}
