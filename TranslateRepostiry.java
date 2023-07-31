import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TranslateRepostiry {

    private static final String INSERT_QUERY = "INSERT INTO translations (source_language, target_language, source_text, translated_text) VALUES (?, ?, ?, ?)";

    private static final String SELECT_QUERY = "SELECT * FROM translations WHERE source_text = ?";

    private Connection connect;

    public TranslateRepostiry() {
        this.connect = new DataSourceConfig().connect();
    }

    public void save(String text, String translatedText, String sourceLang, String targetLang) {

        try (PreparedStatement preparedStatement = connect.prepareStatement(INSERT_QUERY)) {

            preparedStatement.setString(1, sourceLang);
            preparedStatement.setString(2, targetLang);
            preparedStatement.setString(3, text);
            preparedStatement.setString(4, translatedText);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data saved.");
            }

            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String findByWord(String sourceText) {
        // todo implement this method(SELECT_QUERY)
        String trasnlatedText = null ;
        try (PreparedStatement ps = connect.prepareStatement(SELECT_QUERY)) {

            ps.setString(1, sourceText);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String sText = rs.getString("source_text");
                String tText = rs.getString("translated_text");
                String tLang = rs.getString("target_language");
                String sLang = rs.getString("source_language");
                long id = rs.getInt("id");
                String date = rs.getString("date_added");
                
                trasnlatedText = tText ;
                System.out.println("id: " + id);
                System.out.println("sourcelang: " + sLang);
                System.out.println("targetlang: " + tLang);
                System.out.println("sourcetext: " + sText);
                System.out.println("targettext: " + tText);
                System.out.println("date: " + date);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return trasnlatedText ;
    }

    // todo read how to handle resultSet
    // todo how to select from database

}