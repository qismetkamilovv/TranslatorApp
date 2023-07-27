import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TranslateRepostiry {

    // todo constant string field insert sql saxlayacaq 4 field ucun (INSERT_QUERY)
    private static final String insertQuery = "INSERT INTO translations (source_language, target_language, source_text, translated_text) VALUES (?, ?, ?, ?)";
    // todo tabledan texte gore select elemey ucun sql (SELECT_SQL)

    private Connection connect;

    public TranslateRepostiry() {
        this.connect = new DataSourceConfig().connect();
    }

    public void save(String text, String translatedText, String sourceLang, String targetLang) {

        try (PreparedStatement preparedStatement = connect.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, sourceLang);
            preparedStatement.setString(2, targetLang);
            preparedStatement.setString(3, text);
            preparedStatement.setString(4, translatedText);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Veri başarıyla eklendi.");
            }

            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
