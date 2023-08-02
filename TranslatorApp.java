
public class TranslatorApp {


    public static void main(String[] args) {
        String text = args[0];
       
        TranslatorService s = new TranslatorServiceimpl();
        String translatedWord = s.translate(text);
        System.out.println(translatedWord);
    }
}
