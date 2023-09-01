import java.util.ArrayList;
import java.util.logging.Logger;

public class TranslatorApp {
    private static final Logger LOGGER = Logger.getLogger("TranslatorApp");
    static FileReader FileReader;

    public static void main(String[] args) {
        TranslatorServiceimpl trs = new TranslatorServiceimpl();
        String text = null;
        String translatedText = null;
        if (args.length == 0) {
            ArrayList<String> words = FileReader.read();
            // for (int i = 0; i < words.size(); i++) {
            //     translatedText = trs.translate(words.get(i));
            // }
            for(String word : words  ){
                translatedText =trs.translate(word);
            }
        }
        if (args.length == 1) {
            text = args[0];
            translatedText = trs.translate(text);
        }

        if (args.length == 2) {
            String tlang = null;
            for (String arg : args) {
                String[] options = arg.split("=");
                if (options[0].equals("tlang")) {
                    tlang = options[1];
                }
                if (options[0].equals("text")) {
                    text = options[1];
                }

            }
            translatedText = trs.translate(text, tlang);

        }

        if (args.length == 3) {
            String slang = null;
            String tlang = null;
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
            translatedText = trs.translate(text, slang, tlang);
        }
        System.out.println(translatedText);

    }
}
