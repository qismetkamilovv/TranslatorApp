import minimaljson.JsonArray;
import minimaljson.JsonObject;

public class Test2 {
    public static void main(String[] args) {
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
}
