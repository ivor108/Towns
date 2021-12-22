package com.example.zadanie5;
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DBJsonParser {
    public DBJsonParser() {
    }

    JSONObject loadData() throws Exception {
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader("C:\\Users\\User\\Desktop\\Учёба\\Алена\\4 курс\\Java\\zadanie5\\src\\main\\java\\myJson.json"));
        JSONObject jsonObj = (JSONObject)obj;
        System.out.println(jsonObj);
        return jsonObj;
    }
}

