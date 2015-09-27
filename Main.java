import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;




public class Main extends Application {

    private ArrayList<String> usern = new ArrayList<>(100);
    private ArrayList<String> passwd = new ArrayList<>(100);
    private String leaderName = "";
    private String countryName= "";
    private Country country;
    private ArrayList<Country> AI = new ArrayList<>(5);
    private EventRandomizer ele = new EventRandomizer();
    private Event e;
    final NumberAxis xAxis = new NumberAxis();
    final NumberAxis yAxis = new NumberAxis();
    final LineChart<Number,Number> lineChart =
            new LineChart<Number,Number>(xAxis,yAxis);
    private XYChart.Series series = new XYChart.Series();
    private XYChart.Series series1 = new XYChart.Series();
    private XYChart.Series series2 = new XYChart.Series();
    private XYChart.Series series3 = new XYChart.Series();
    private XYChart.Series series4 = new XYChart.Series();
    private XYChart.Series series5 = new XYChart.Series();
    private Country emeraldia;
    private Country johnCena;
    private Country rickroll;
    private Country imouto;
    private Country steam;
    private Popularity popularity;
    private float popNum;
    private int env;
    private int wel;
    private int def;

    public boolean login(String username, String password, Label label, Button login, Stage stage) {
        if (!usern.contains(username) || !passwd.contains(password)) {
            label.setText("ERROR: Username/Password was Incorrect!\nPlease register if you have not!");
        } else {
            //MOVE TO THE NEXT SCENE//
            label.setText("Login Successful!");
            countryNameScene(stage);
        }
        return usern.contains(username) && password.contains(password);
    }

    public boolean createAccount(String username, String password, Label label) {
        if (!(usern.contains(username)) && !username.equals("") && !password.equals("")) {
            usern.add(username);
            passwd.add(password);
            label.setText("Registration Successful!");
            return  true;
        } else {
            label.setText("Registration Unsuccessful!");
            return false;
        }
    }

    public void makeCountry(TextField one, TextField two, Stage stage, RadioButton a, RadioButton b, RadioButton c, RadioButton first, RadioButton second, RadioButton third) {
        this.leaderName = one.getText();
        this.countryName = two.getText();
        this.popNum = 25f;
        float gdp;
        String ans;
        xAxis.setLabel("Number of Years");
        yAxis.setLabel("GDP Per Capita");
        //creating the chart
        lineChart.setTitle("GDP Per Capita Changes");
        //defining a series
        series.setName(this.countryName);
        series1.setName("Emeraldia");
        series2.setName("WWE");
        series3.setName("Musica");
        series4.setName("Japan");
        series5.setName("Steam");
        //populating the series with data
        lineChart.getData().add(series);
        lineChart.getData().add(series1);
        lineChart.getData().add(series2);
        lineChart.getData().add(series3);
        lineChart.getData().add(series4);
        lineChart.getData().add(series5);

        if (a.isSelected()) {
            ans = "small";
        } else if (b.isSelected()) {
            ans = "medium";
        } else if(c.isSelected()) {
            ans = "large";
        } else {
            ans = "colossal";
        }
        if (first.isSelected()) {
            gdp = 750000000000f;
        } else if (second.isSelected()) {
            gdp = 500000000000f;
        } else {
            gdp = 250000000000f;
        }
        this.country = new Country(this.countryName, this.leaderName,ans,gdp);
        this.popularity = new Popularity(this.country);
        this.e = new Event(this.ele.random(), this.country);
        //GO TO THE NEXT SCENE//
        this.emeraldia = new Country("Emeraldia", "Rayquaza", "large", gdp);
        this.johnCena = new Country("WWE", "John Cena", "small", gdp);
        this.rickroll = new Country("Musica", "Rick Roll", "medium", gdp);
        this.imouto = new Country("Japan", "Imouto-Chan", "colossal",gdp);
        this.steam = new Country("Steam", "Richard Deng", "large", gdp);
        this.AI.add(emeraldia);
        this.AI.add(johnCena);
        this.AI.add(rickroll);
        this.AI.add(imouto);
        this.AI.add(steam);
        this.AI.add(this.country);
        this.AI.sort(new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                return o1.comparePerCapita(o1, o2);
            }
        });
        countryDisplayScene(stage);
    }

    public void update(Stage stage) {
        changes(stage);
    }

    public void update(Stage stage, Slider slider) {
        this.country.setTaxRate((float) slider.getValue());
        this.e = new Event(this.ele.random(),this.country);
        for(Country c: AI) {
            c.Update();
        }
        Event e = new Event("", this.country);
        this.AI.sort(new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                return o1.comparePerCapita(o1, o2);
            }
        });
        countryDisplayScene(stage);
    }

    public void updatePopularity(int defense, int environ, int welfare) {
        this.popularity.chooseWelfare(welfare,defense,environ);
        this.popNum = this.popularity.findPopularity();
    }
    @Override public void start(Stage stage)throws Exception{
        StackPane backgroundSettings = new StackPane();

        // load the image
        Image image = new Image("back2.jpg");
        Image title = new Image("Title.png");

        //load the sound(s)//
        String musicFile = "Opening.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();

        //A button with the specified text caption.
        Button play = new Button("Play");
        DropShadow shadow = new DropShadow();

        //Adding the shadow when the mouse cursor is on
        play.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        play.setEffect(shadow);
                    }
                });

        //Removing the shadow when the mouse cursor is off
        play.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        play.setEffect(null);
                    }
                });
        play.setStyle("-fx-font: 22 arial; -fx-base:   #b6e7c9;");

        // simple displays BACKGROUND IMAGEVIEW/BACKGROUND SCENE
        ImageView iv1 = new ImageView();
        iv1.setImage(image);
        ImageView iv2 = new ImageView();
        iv2.setImage(title);
        iv1.fitWidthProperty().bind(stage.widthProperty());
        iv2.fitWidthProperty().bind(stage.widthProperty());
        StackPane.setAlignment(iv2,Pos.TOP_CENTER);
        StackPane.setAlignment(play,Pos.BOTTOM_CENTER);
        backgroundSettings.getChildren().addAll(iv1,iv2,play);
        Scene scene = new Scene(backgroundSettings);
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("Game");
        stage.setScene(scene);
        stage.setWidth(500);
        stage.setHeight(800);
        stage.sizeToScene();
        stage.show();

        //CREATES the SELECTION Stage//
        play.setOnAction(e -> {registrationScene(stage);});
    }
    public static void main(String[] args) {
        Application.launch(args);
    }

    public void registrationScene(Stage stage) {
        //Make Buttons//
        Button login = new Button("Login");
        Button create = new Button("Create new Account");
        Label user = new Label("Username: ");
        Label pass = new Label("Password: ");
        Label temp = new Label();
        TextField userText = new TextField();
        TextField passText = new TextField();
        GridPane grid = new GridPane();
        GridPane.setConstraints(login, 0, 9);
        GridPane.setConstraints(create, 0, 10);
        GridPane.setConstraints(user, 0, 7);
        GridPane.setConstraints(pass, 0, 8);
        GridPane.setConstraints(userText, 1, 7);
        GridPane.setConstraints(passText, 1, 8);
        GridPane.setConstraints(temp, 1, 9);
        grid.getChildren().addAll(login, create, user, pass, userText, passText, temp);
        Scene select = new Scene(grid);
        stage.setTitle("Login");
        stage.setWidth(360);
        stage.setHeight(175);
        stage.setScene(select);
        stage.show();

        //Action Buttons for Login/Create Account//
        login.setOnAction(e -> login(userText.getText(), passText.getText(), temp, login, stage));
        create.setOnAction(e -> createAccount(userText.getText(), passText.getText(), temp));
    }

    public void countryNameScene(Stage stage) {
        Button confirm = new Button("Confirm");
        TextField leader = new TextField();
        TextField country = new TextField();
        Label lName = new Label("Leader Name: ");
        Label cName = new Label("Country Name: ");
        Label popName = new Label("Population Size: ");
        Label gdpName = new Label("GDP (START): ");
        //RadioButtons for Population//
        ToggleGroup swagger = new ToggleGroup();
        RadioButton smallPop = new RadioButton("Small");
        RadioButton mediumPop = new RadioButton("Medium");
        RadioButton largePop = new RadioButton("Large");
        RadioButton colossalPop = new RadioButton("Colossal");
        smallPop.setToggleGroup(swagger);
        smallPop.setSelected(true);
        mediumPop.setToggleGroup(swagger);
        largePop.setToggleGroup(swagger);
        colossalPop.setToggleGroup(swagger);
        VBox buttBox = new VBox(smallPop,mediumPop,largePop,colossalPop);
        //RadioButtons for GDP (START)//
        ToggleGroup nice = new ToggleGroup();
        RadioButton third = new RadioButton("Third World");
        RadioButton second = new RadioButton("Second World");
        RadioButton first = new RadioButton("First World");
        third.setToggleGroup(nice);
        second.setToggleGroup(nice);
        first.setToggleGroup(nice);
        first.setSelected(true);
        VBox assBox = new VBox(first,second,third);
        //Setting where the contents go//
        GridPane grid = new GridPane();
        GridPane.setConstraints(confirm, 6, 9);
        GridPane.setConstraints(leader,6,1);
        GridPane.setConstraints(country,6,2);
        GridPane.setConstraints(buttBox,6,3);
        GridPane.setConstraints(assBox, 6, 4);
        GridPane.setConstraints(lName, 4, 1);
        GridPane.setConstraints(cName, 4, 2);
        GridPane.setConstraints(popName, 4, 3);
        GridPane.setConstraints(gdpName, 4, 4);
        grid.getChildren().addAll(confirm, leader, country, lName, cName, popName, gdpName, buttBox, assBox);
        Scene name = new Scene(grid);
        stage.setTitle("Country Basics!");
        stage.setWidth(500);
        stage.setHeight(300);
        stage.setScene(name);
        stage.show();

        //Button actions//
        confirm.setOnAction(e -> {
            makeCountry(leader, country, stage, smallPop, mediumPop, largePop,first,second,third);
        });
    }

    public void reportCardScene(Stage stage) {
        Button next = new Button("Next Year");
        Label countryName = new Label("Country Name: ");
        Label leaderName = new Label("Leader Name: ");
        Label mainLabel = new Label("Progress Report: ");
        Label gdpLabel = new Label("GDP Rate of Change: ");
        Label popLabel = new Label("Population Rate of Change: ");
        Label taxLabel = new Label("Tax Rate: ");
        Label yearLabel = new Label("Year: ");
        Label rankings = new Label("Rankings (GDP Per Capita): ");
        Label events = new Label("What happened this year?");
        TextField country = new TextField();
        TextField leader = new TextField();
        TextField gdp = new TextField();
        TextField pop = new TextField();
        TextField year = new TextField();
        TextField tax = new TextField();
        TextField event = new TextField();
        ListView<Country> list = new ListView<>();
        ObservableList<Country> ranking = FXCollections.observableArrayList(this.AI);
        list.setItems(ranking);
        VBox vbox = new VBox(list);
        tax.setEditable(false);
        country.setEditable(false);
        leader.setEditable(false);
        gdp.setEditable(false);
        pop.setEditable(false);
        year.setEditable(false);
        event.setEditable(false);
        country.setText(this.countryName);
        leader.setText(this.leaderName);
        float b = this.country.getPopRate();
        float c = this.country.getGDPRate();
        float d = this.country.getTaxRate();
        gdp.setText(Float.toString(c));
        pop.setText(Float.toString(b));
        tax.setText(Float.toString(d));
        year.setText(Integer.toString(this.country.getYear()));
        this.e.eventMessage();
        event.setText("Year " + year.getText() + ": " + this.e.message());
        GridPane grid = new GridPane();
        GridPane.setConstraints(countryName, 0, 1);
        GridPane.setConstraints(leaderName, 0, 2);
        GridPane.setConstraints(gdpLabel, 0, 3);
        GridPane.setConstraints(popLabel, 0, 4);
        GridPane.setConstraints(taxLabel,0, 5);
        GridPane.setConstraints(yearLabel,0, 6);
        GridPane.setConstraints(rankings,0, 7);
        GridPane.setConstraints(country, 2, 1);
        GridPane.setConstraints(leader, 2, 2);
        GridPane.setConstraints(gdp, 2, 3);
        GridPane.setConstraints(pop, 2, 4);
        GridPane.setConstraints(next,2,15);
        GridPane.setConstraints(year,2,6);
        GridPane.setConstraints(tax, 2,5);
        GridPane.setConstraints(vbox,2,8);
        GridPane.setConstraints(events,0,9);
        GridPane.setConstraints(event,2,9);
        //MAKE A GRAPH
        //defining the axes
        //populating the series with data
        series.getData().add(new XYChart.Data(this.country.getYear(),this.country.getPerCapita()));
        series1.getData().add(new XYChart.Data(this.country.getYear(),this.emeraldia.getPerCapita()));
        series2.getData().add(new XYChart.Data(this.country.getYear(),this.johnCena.getPerCapita()));
        series3.getData().add(new XYChart.Data(this.country.getYear(), this.rickroll.getPerCapita()));
        series4.getData().add(new XYChart.Data(this.country.getYear(),this.imouto.getPerCapita()));
        series5.getData().add(new XYChart.Data(this.country.getYear(),this.steam.getPerCapita()));
        VBox graph = new VBox(lineChart);
        GridPane.setConstraints(lineChart,2,10);
        //
        grid.getChildren().addAll(lineChart,event, events, tax, taxLabel, gdp, pop, year, yearLabel, next, countryName, leaderName, mainLabel, gdpLabel, popLabel, country, leader, vbox, rankings);
        Scene now = new Scene(grid);
        stage.setTitle("REPORT CARD");
        stage.setWidth(800);
        stage.setHeight(850);
        stage.setScene(now);
        stage.show();
        next.setOnAction(e -> update(stage));
    }

    public void countryDisplayScene(Stage stage) {
        Button next = new Button("End of Year");
        Label countryName = new Label("Country: ");
        Label leaderName = new Label("Leader Name: ");
        Label popular = new Label("Popularity");
        Label gdpLabel = new Label("GDP: ");
        Label popLabel = new Label("Population: ");
        Label budget = new Label("Budget: ");
        TextField country = new TextField();
        TextField leader = new TextField();
        TextField gdp = new TextField();
        TextField pop = new TextField();
        TextField bud = new TextField();
        TextField poopy = new TextField();
        poopy.setEditable(false);
        country.setEditable(false);
        leader.setEditable(false);
        gdp.setEditable(false);
        pop.setEditable(false);
        country.setText(this.countryName);
        leader.setText(this.leaderName);
        poopy.setText(Float.toString(this.popNum));
        float ba = this.country.getBudget();
        float a = this.country.getGDP();
        float b = this.country.getPop();
        gdp.setText(Float.toString(a));
        pop.setText(Float.toString(b));
        bud.setText(Float.toString(ba));
        GridPane grid = new GridPane();
        GridPane.setConstraints(countryName, 0, 1);
        GridPane.setConstraints(leaderName, 0, 2);
        GridPane.setConstraints(popular,0,3);
        GridPane.setConstraints(gdpLabel, 0, 4);
        GridPane.setConstraints(popLabel, 0, 5);
        GridPane.setConstraints(budget, 0, 6);
        GridPane.setConstraints(country, 2, 1);
        GridPane.setConstraints(leader, 2, 2);
        GridPane.setConstraints(poopy,2,3);
        GridPane.setConstraints(gdp,2,4);
        GridPane.setConstraints(pop,2,5);
        GridPane.setConstraints(bud,2, 6);
        GridPane.setConstraints(next,2,10);
        grid.getChildren().addAll(poopy,popular,bud,budget,next,countryName, leaderName, gdpLabel, popLabel, country, leader,gdp,pop);
        Scene now = new Scene(grid);
        stage.setTitle("Current Progress");
        stage.setWidth(500);
        stage.setHeight(300);
        stage.setScene(now);
        stage.show();
        //Button Actions//
        next.setOnAction(e -> reportCardScene(stage));
    }

    public void changes(Stage stage) {
        Button confirm = new Button("Confirm");
        Label taxRates = new Label("Tax Rate: "); //Slider to change tax rates//
        Label defense = new Label("Defense:\n\t\t");
        Label environment = new Label("\nEnviron:");
        Label welfare = new Label("Welfare:");
        //Spending Power RadioButtons//
        Slider defenseField = new Slider();
        Slider envField = new Slider();
        Slider welField = new Slider();
        defenseField.setMin(0);
        defenseField.setMax(100);
        defenseField.setValue(this.country.getTaxRate());
        defenseField.setShowTickLabels(true);
        defenseField.setShowTickMarks(true);
        defenseField.setMajorTickUnit(20);
        defenseField.setMinorTickCount(2);
        defenseField.setBlockIncrement(10);
        welField.setMin(0);
        welField.setMax(100);
        welField.setValue(this.country.getTaxRate());
        welField.setShowTickLabels(true);
        welField.setShowTickMarks(true);
        welField.setMajorTickUnit(20);
        welField.setMinorTickCount(2);
        welField.setBlockIncrement(10);
        envField.setMin(0);
        envField.setMax(100);
        envField.setValue(this.country.getTaxRate());
        envField.setShowTickLabels(true);
        envField.setShowTickMarks(true);
        envField.setMajorTickUnit(20);
        envField.setMinorTickCount(2);
        envField.setBlockIncrement(10);
        //Tax Rate Slider//
        Slider tax = new Slider();
        tax.setMin(0);
        tax.setMax(100);
        tax.setValue(this.country.getTaxRate());
        tax.setShowTickLabels(true);
        tax.setShowTickMarks(true);
        tax.setMajorTickUnit(20);
        tax.setMinorTickCount(2);
        tax.setBlockIncrement(10);
        ToggleGroup social = new ToggleGroup();
        //VBoxes for Change radiobuttons//
        VBox p = new VBox(defenseField,welField,envField);
        VBox t = new VBox(defense,welfare,environment);
        //GRID PLACEMENTS//
        GridPane grid = new GridPane();
        GridPane.setConstraints(taxRates, 1, 3);
        GridPane.setConstraints(p, 1, 0);
        GridPane.setConstraints(t, 0, 0);
        GridPane.setConstraints(tax, 1, 4);
        GridPane.setConstraints(confirm, 3, 10);
        grid.getChildren().addAll(p, tax, confirm, taxRates, t);
        Scene now = new Scene(grid);
        stage.setTitle("Changes for the Year?");
        stage.setWidth(550);
        stage.setHeight(300);
        stage.setScene(now);
        stage.show();
        int temp1 = (int) defenseField.getValue();
        int temp2 = (int) envField.getValue();
        int temp3 = (int) welField.getValue();
        updatePopularity(temp1,temp2,temp3);
        confirm.setOnAction(e -> update(stage, tax));
    }
}
