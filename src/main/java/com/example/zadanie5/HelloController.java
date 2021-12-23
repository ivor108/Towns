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

//В контроллере реализуется основная логика проги
public class HelloController implements Initializable{
    //Связываем контроллер с fxml файлом
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

    //Создаём локальные переменны в которых будем хранить сам джсон:
    JSONObject jsonObj;
    //И Поля таблицы которые будем получать из джсона
    String townName;
    String t_monday;
    String t_tuesday;
    String t_wednesday;
    String t_thursday;
    String t_friday;
    String t_saturday;
    String t_sunday;
    String [] days;

    //Сначала смотрим на метод initialize
    //Метод обработки нажатия кнопки. По сути делает тоже что и initialize
    @FXML
    protected void onHelloButtonClick()
    {
        //берём значения города из поля ввода
        String townkey = top.getText();
        //Делаем то же что и в initialize. Загружаем json
        DBJsonParser dbJsonParser = new DBJsonParser();

        try {
            this.jsonObj = dbJsonParser.loadData();
        } catch (Exception var11) {
            Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, (String)null, var11);
        }
        Set var5 = this.jsonObj.keySet();

        //Если в json если искомый ключ (город)
        if(var5.contains(townkey))
        {
            //То как и в initialize выводим данные в табличку
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
            //если города нет то выводим ошибку
            welcomeText.setText("CHECK YOU REQUEST!");
            welcomeText.setTextFill(Color.RED);
        }


    }
    //Метод который выполняется при запуске проги
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Задаём размеры и текст
        welcomeText.setLayoutY(180);
        welcomeText.setText("Choose town...");
        //Тут как я понял заполняем первую строку таблицы
        this.nameTown.setCellValueFactory(new PropertyValueFactory("nameTown"));
        this.monday.setCellValueFactory(new PropertyValueFactory("monday"));
        this.tuesday.setCellValueFactory(new PropertyValueFactory("tuesday"));
        this.wednesday.setCellValueFactory(new PropertyValueFactory("wednesday"));
        this.thursday.setCellValueFactory(new PropertyValueFactory("thursday"));
        this.friday.setCellValueFactory(new PropertyValueFactory("friday"));
        this.saturday.setCellValueFactory(new PropertyValueFactory("saturday"));
        this.sunday.setCellValueFactory(new PropertyValueFactory("sunday"));

        //Создаём новый объект класса DBJsonParser. Это класс для работы с дсон фалами. С помощью его можно обращаться
        // к разным блокам и полям json
        DBJsonParser dbJsonParser = new DBJsonParser();

        //Пробуем загрузить json
        try {
            //Кладём в переменную для хранения json объект json который пытаем получить с помощью DBJsonParser
            this.jsonObj = dbJsonParser.loadData();
        } catch (Exception var11) {
            //Если не получилось выводим ошибку
            Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, (String)null, var11);
        }
//        welcomeText.setText(jsonObj.toString());
        //Создаём список городов
        ArrayList<town> townList = new ArrayList();
        //Проходим циклом по всем ключам json
        Iterator var5 = this.jsonObj.keySet().iterator();
        while(var5.hasNext())
        {
            Object key = var5.next();
            JSONObject jsonObjectValue = (JSONObject)this.jsonObj.get(key);
            //Проходим по всем значениям текущего ключа
            Iterator var9 = jsonObjectValue.keySet().iterator();
            while(var9.hasNext()) {
                //Кладём в наши локальные переменные значения из json
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
            //Создаём новый город с параметрами полученными из json
            town twn = new town(this.townName, this.t_monday, this.t_tuesday, this.t_wednesday, this.t_thursday, this.t_friday, this.t_saturday, this.t_sunday);
            //Кладём созданный город в список
            townList.add(twn);
        }
        //Создаём специльный список для хранения город для того что бы его передать в fxml и там всё отобразилось
        ObservableList<town> townModels = FXCollections.observableArrayList();
        Iterator var7 = townList.iterator();

        //Заполняем этот список
        while(var7.hasNext()) {
//            System.out.println(var7.next());
            town t = (town)var7.next();
            townModels.add(t);
        }

        //передаём этот специальный список в fxml
        this.my.setItems(townModels);

    }


}