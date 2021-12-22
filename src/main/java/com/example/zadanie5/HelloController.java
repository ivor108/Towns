package com.example.zadanie5;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import org.json.simple.JSONObject;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HelloController implements Initializable{
    @FXML
    private Label welcomeText;
    @FXML
    private TextField top;
    @FXML
    private Button btn;

    @FXML
    TableView<town> my;
    @FXML
    public TableColumn<town, String> nameTown;
    @FXML
    public TableColumn<town, String>  monday;
    @FXML
    public TableColumn<town, String> tuesday;
    @FXML
    public TableColumn<town, String> wednesday;
    @FXML
    public TableColumn<town, String> thursday;
    @FXML
    public TableColumn<town, String> friday;
    @FXML
    public TableColumn<town, String> saturday;
    @FXML
    public TableColumn<town, String> sunday;
    JSONObject jsonObj;
    String townName;
    String t_monday;
    String t_tuesday;
    String t_wednesday;
    String t_thursday;
    String t_friday;
    String t_saturday;
    String t_sunday;
    String [] days;
    @FXML
    protected void onHelloButtonClick()
    {
        String townkey = top.getText();
        DBJsonParser dbJsonParser = new DBJsonParser();

        try {
            this.jsonObj = dbJsonParser.loadData();
        } catch (Exception var11) {
            Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, (String)null, var11);
        }
        Set var5 = this.jsonObj.keySet();
        if(var5.contains(townkey))
        {
            JSONObject jsonObjectValue = (JSONObject)this.jsonObj.get(townkey);
            this.t_monday = (String)jsonObjectValue.get("monday");
            this.t_tuesday = (String)jsonObjectValue.get("tuesday");
            this.t_wednesday = (String)jsonObjectValue.get("wednesday");
            this.t_thursday = (String)jsonObjectValue.get("thursday");
            this.t_friday = (String)jsonObjectValue.get("friday");
            this.t_saturday = (String)jsonObjectValue.get("saturday");
            this.t_sunday = (String)jsonObjectValue.get("sunday");
            this.townName = townkey;
            ArrayList<town> townList = new ArrayList();
            town twn = new town(this.townName, this.t_monday, this.t_tuesday, this.t_wednesday, this.t_thursday, this.t_friday, this.t_saturday, this.t_sunday);
            townList.add(twn);
            ObservableList<town> townModels = FXCollections.observableArrayList();
            Iterator var7 = townList.iterator();
            while(var7.hasNext()) {
                town t = (town)var7.next();
                townModels.add(t);
            }
            this.my.setItems(townModels);
        }
        else
        {
            welcomeText.setText("CHECK YOU REQUEST!");
            welcomeText.setTextFill(Color.RED);
        }


    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        welcomeText.setLayoutY(180);
        welcomeText.setText("Choose town...");
        this.nameTown.setCellValueFactory(new PropertyValueFactory("nameTown"));
        this.monday.setCellValueFactory(new PropertyValueFactory("monday"));
        this.tuesday.setCellValueFactory(new PropertyValueFactory("tuesday"));
        this.wednesday.setCellValueFactory(new PropertyValueFactory("wednesday"));
        this.thursday.setCellValueFactory(new PropertyValueFactory("thursday"));
        this.friday.setCellValueFactory(new PropertyValueFactory("friday"));
        this.saturday.setCellValueFactory(new PropertyValueFactory("saturday"));
        this.sunday.setCellValueFactory(new PropertyValueFactory("sunday"));

        DBJsonParser dbJsonParser = new DBJsonParser();

        try {
            this.jsonObj = dbJsonParser.loadData();
        } catch (Exception var11) {
            Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, (String)null, var11);
        }
//        welcomeText.setText(jsonObj.toString());
        ArrayList<town> townList = new ArrayList();
        Iterator var5 = this.jsonObj.keySet().iterator();

        while(var5.hasNext())
        {
            Object key = var5.next();
            JSONObject jsonObjectValue = (JSONObject)this.jsonObj.get(key);
            Iterator var9 = jsonObjectValue.keySet().iterator();
            while(var9.hasNext()) {
                Object keyZ = var9.next();
                if (keyZ.equals("monday")) {
                    this.t_monday = (String)jsonObjectValue.get(keyZ);
                }
                if (keyZ.equals("tuesday")) {
                    this.t_tuesday = (String)jsonObjectValue.get(keyZ);
                }
                if (keyZ.equals("wednesday")) {
                    this.t_wednesday = (String)jsonObjectValue.get(keyZ);
                }
                if (keyZ.equals("thursday")) {
                    this.t_thursday = (String)jsonObjectValue.get(keyZ);
                }
                if (keyZ.equals("friday")) {
                    this.t_friday = (String)jsonObjectValue.get(keyZ);
                }
                if (keyZ.equals("saturday")) {
                    this.t_saturday = (String)jsonObjectValue.get(keyZ);
                }
                if (keyZ.equals("sunday")) {
                    this.t_sunday = (String)jsonObjectValue.get(keyZ);
                }
                this.townName = key.toString();
            }
            town twn = new town(this.townName, this.t_monday, this.t_tuesday, this.t_wednesday, this.t_thursday, this.t_friday, this.t_saturday, this.t_sunday);
            townList.add(twn);
        }
        ObservableList<town> townModels = FXCollections.observableArrayList();
        Iterator var7 = townList.iterator();

        while(var7.hasNext()) {
//            System.out.println(var7.next());
            town t = (town)var7.next();
            townModels.add(t);
        }

        this.my.setItems(townModels);

    }


}