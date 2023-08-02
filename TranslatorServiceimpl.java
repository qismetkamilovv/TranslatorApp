public class TranslatorServiceimpl implements TranslatorService {

    public final static String SOURCE_LANG = "en";
    public final static String TARGET_LANG = "az";

    private GoogleTranslatorApiClient googleTranslatorApiClient;
    private TranslateRepostiry translateRepostiry;

    public TranslatorServiceimpl() {
        this.googleTranslatorApiClient = new GoogleTranslatorApiClient();
        this.translateRepostiry = new TranslateRepostiry();
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
        String translatedText = translateRepostiry.findByWord(text);
        if (translatedText == null) {
            translatedText = googleTranslatorApiClient.translate(sourceLang, targetLang, text);
            translateRepostiry.save(text, translatedText, sourceLang, targetLang);
        }
        return translatedText;
    }
}
