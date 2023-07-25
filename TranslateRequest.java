public class TranslateRequest {
    // TODO rename to text
    private String q ;
    private String target ;
    private String source ;

    public TranslateRequest (String q , String target, String source){
        this.target = target ;
        this.source = source ;
        this.q = q ;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
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
    

}
