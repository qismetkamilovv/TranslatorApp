import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TranslateRepostiry {

    private static final String INSERT_QUERY = "INSERT INTO translations (source_language, target_language, source_text, translated_text) VALUES (?, ?, ?, ?)";
    private static final String SELECT_QUERY = "SELECT translated_text FROM translations WHERE source_text = ?";

    private Connection connect;

    public TranslateRepostiry(DataSourceConfig config) {
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

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String findByWord(String sourceText) {
        String trasnlatedText = null;
        try (PreparedStatement ps = connect.prepareStatement(SELECT_QUERY)) {
            ps.setString(1, sourceText);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tText = rs.getString("translated_text");
                trasnlatedText = tText;
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trasnlatedText;
    }
}