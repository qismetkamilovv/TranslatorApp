import javafx.scene.control.MenuItem;
import minimaljson.Json;
import minimaljson.JsonArray;
import minimaljson.JsonObject;
import minimaljson.JsonValue;

public class Test2 {
    public static void main(String[] args) {
        String json = "{\"menu\": { \"id\": \"file\", \"value\": \"File\", \"popup\": { \"menuitem\": [ {\"value\":\"New\", \"onclick\": \"CreateNewDoc()\"}, {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"}, {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"} ] } }}" ;
        JsonValue a = fromJson(json);
        JsonArray name = a.asObject().get("menu").asObject().get("popup" ).asObject().get("menuitem").asArray();//.getJsonValue("menu");//.getString("value", null);
        //System.out.println(name);
        for(JsonValue jsonValue : name ) {

        System.out.println(jsonValue.asObject().get("onclick"));
    }
    }

        public void abc() {
            
        

        JsonObject aa = new JsonObject();
        JsonObject menu = new JsonObject() ;
        menu.add("id", "file")
        .add("value", "file");

        JsonObject popup = new JsonObject();

        JsonArray menuitem = new JsonArray(); 

        JsonObject item1 = new JsonObject();
        JsonObject item2 = new JsonObject();
        JsonObject item3 = new JsonObject();

        item1.add("value", "New")
        .add("OnClick", "CreateNewDoc()");

        item2.add("value", "new")
        .add("OnClick", "CreateNewDoc()");

        item3.add("value", "New")
        .add("OnClick", "CreateNewDoc()");

        menuitem.add(item1);
        menuitem.add(item2); 
        menuitem.add(item3);

        popup.add("menuitem", menuitem);
        menu.add("popup",popup);
        aa.add("menu",menu);

        System.out.println(aa);


    }
    public static JsonValue fromJson(String json) {
        return Json.parse(json); 
     }
}
