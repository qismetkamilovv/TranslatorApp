import java.util.logging.Logger;
import java.util.Arrays;
import java.util.logging.Level;

public class TranslatorServiceimpl implements TranslatorService {

    private static final Logger LOGGER = Logger.getLogger(TranslatorServiceimpl.class.getName());

    public final static String SOURCE_LANG = "en";
    public final static String TARGET_LANG = "az";

    private GoogleTranslatorApiClient googleTranslatorApiClient;
    private TranslateRepostiry translateRepostiry;

    public TranslatorServiceimpl(TranslateRepostiry repo, GoogleTranslatorApiClient client) { 
        this.googleTranslatorApiClient = client ;
        this.translateRepostiry = repo ;
    }

    @Override
    public String translate(String text) {
        return this.translate(text, SOURCE_LANG, TARGET_LANG);
    }

    @Override
    public String translate(String text, String targetLang) {
        return this.translate(text, SOURCE_LANG, targetLang);
    }

    @Override
    public String translate(String text, String sourceLang, String targetLang) {
        LOGGER.log(Level.INFO, "Text: {0}, Source lang: {1}, Target lang: {2}",
                new Object[] { text, sourceLang, targetLang });
        String translatedText = translateRepostiry.findByWord(text);
        if (translatedText == null) {
            translatedText = googleTranslatorApiClient.translate(sourceLang, targetLang, text);
            translateRepostiry.save(text, translatedText, sourceLang, targetLang);
        }
        LOGGER.log(Level.INFO, "Translated text: {0}", translatedText);
        return translatedText;
    }
}
