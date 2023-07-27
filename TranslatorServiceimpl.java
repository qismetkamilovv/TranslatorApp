public class TranslatorServiceimpl implements TranslatorService {

    public final static String sourceLang = "en";
    public final static String targetLang = "az";

    private GoogleTranslatorApiClient googleTranslatorApiClient;
    private TranslateRepostiry translateRepostiry;

    public TranslatorServiceimpl() {
        this.googleTranslatorApiClient = new GoogleTranslatorApiClient();
        this.translateRepostiry = new TranslateRepostiry();
    }

    @Override
    public String translate(String word) {
        //todo first call googleapi to translate "word" than save the translated text to database 
        
        return null;
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






