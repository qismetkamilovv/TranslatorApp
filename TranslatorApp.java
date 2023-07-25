public class TranslatorApp {

    public static void main(String[] args) {
        //todo read word from args
        //than translatorservice call service.translate
        //than output result 
        TranslatorServiceimpl translatorService = new TranslatorServiceimpl() ;
        translatorService.translate();
        translatorService.test();
            
        

        
    }
}