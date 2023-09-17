import java.util.ArrayList;
import java.util.logging.Logger;

public class TranslatorApp {
    private static final Logger LOGGER = Logger.getLogger("TranslatorApp");
    private DataSourceConfig config;
    private TranslatorService trs;

    public TranslatorApp() {
        config = new DataSourceConfig();
        TranslateRepostiry repo = new TranslateRepostiry(config);
        GoogleTranslatorApiClient client = new GoogleTranslatorApiClient();
        trs = new TranslatorServiceimpl(repo, client);

    }

    public static void main(String[] args) {
        TranslatorApp app = new TranslatorApp();
        String text = null;
        String translatedText = null;
        if (args.length == 0) {
            app.readFromFileAndTranslate();
        }

        if (args.length == 1) {
            translatedText = app.trsWord(args[0]);
        }

        if (args.length == 2) {
            translatedText = app.trgtLang(args);

        }

        if (args.length == 3) {
            translatedText = app.srclang(args);

        }
    }

    public void readFromFileAndTranslate() {
        ArrayList<String> words = FileReader.read();
        for (String word : words) {
            trs.translate(word);
        }
    }

    public String trsWord(String text) {
        return trs.translate(text);
    }

    public String trgtLang(String[] args) {
        String tlang = null;
        String text = null;
        for (String arg : args) {
            String[] options = arg.split("=");
            if (options[0].equals("tlang")) {
                tlang = options[1];
            }
            if (options[0].equals("text")) {
                text = options[1];
            }

        }
        return trs.translate(tlang, text);
    }

    public String srclang(String[] args) {
        String slang = null;
        String tlang = null;
        String text = null;
        for (String arg : args) {
            String[] options = arg.split("=");
            if (options[0].equals("slang")) {
                slang = options[1];

            }
            if (options[0].equals("tlang")) {
                tlang = options[1];

            }
            if (options[0].equals("text")) {
                text = options[1];

            }
        }
        return trs.translate(slang, tlang, text);
    }

}
