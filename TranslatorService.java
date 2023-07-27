public interface TranslatorService {

    String translate(String word);

    String translate(String word, String targetLang);

    String translate(String word, String sourceLang, String targetLang);
}

