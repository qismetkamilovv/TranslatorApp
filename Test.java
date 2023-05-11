import minimaljson.Json;
import minimaljson.JsonObject;
import minimaljson.JsonValue;

public class Test {
    // { "name":"Qismet", "age":14, "employed": false, "address": { "city": "Baku", "street": "Hasan bay zardabi" } }
    public static void main(String[] args) {
        String  json = "{ \"name\":\"Qismet\", \"age\":14, \"employed\": false, \"address\": { \"city\": \"Baku\", \"street\": \"Hasan bay zardabi\" } }";
        JsonValue a = fromJson(json);
        String name = a.asObject().getString("name", null);

        System.out.println(name);
        
    }
    public void toJson() {
        JsonObject json = new JsonObject() ;
        json.add("name" , "qismet")
        .add("age", 14)
        .add("employed", false) ;

        JsonObject address = new JsonObject() ;
        address.add("city", "Baku")
        .add("street", "Hasan Bay zardabi");

        json.add("address", address) ;
        
        System.out.println(json);
        
    }
    public static JsonValue fromJson(String json) {
       return Json.parse(json); 
        
        
    }
}