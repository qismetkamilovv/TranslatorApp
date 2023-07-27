import javax.xml.crypto.dsig.TransformService;

public class TranslatorApp {

    // research how to read values from args in java

    public static void main(String[] args) {  

        // todo read word from args
        // than translatorservice call service.translate
        // than output result
        TranslatorService s = new TranslatorServiceimpl();
        String translatedWord = s.translate(text);
        System.out.println(translatedWord);
    }
}


/*
 * For read
 * inheritance
 * class constructor
 * field default values
 */