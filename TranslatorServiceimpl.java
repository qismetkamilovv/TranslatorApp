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
        String translatedText = translateRepostiry.findByWord(text);
        if (translatedText == null) {
            translatedText = googleTranslatorApiClient.translate(SOURCE_LANG, TARGET_LANG, text);
            translateRepostiry.save(text, translatedText, SOURCE_LANG, TARGET_LANG);
        }

        return translatedText;
    }

    @Override
    public String translate(String word, String targetLang) {
        return null;
    }

    @Override
    public String translate(String word, String sourceLang, String targetLang) {
        return null;
    }

}
