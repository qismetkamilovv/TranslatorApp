import minimaljson.JsonObject;

public class TranslateRequest {
   
    private String text ;
    private String target ;
    private String source ;

    public TranslateRequest (String text , String target, String source){
        this.target = target ;
        this.source = source ;
        this.text = text ;
    }

    public String gettext() {
        return text;
    }

    public void settext(String text) {
        this.text = text;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
    
    public String toJson (){
        JsonObject json = new JsonObject() ;
        json.add("q", text).
            add("source", source).
            add("target", target);
        return json.toString() ;
    }
    
    
}
