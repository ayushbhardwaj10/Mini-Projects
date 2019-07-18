package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Doctor_Visualize implements Initializable {

    @FXML
    private TableView<ModelTable2>table;
    @FXML
    private TableColumn<ModelTable2,Integer>patientID;
    @FXML
    private TableColumn<ModelTable2,String>name;
    @FXML
    private TableColumn<ModelTable2,Integer>age;
    @FXML
    private TableColumn<ModelTable2,String>extraDetails;
    @FXML
    private TableColumn<ModelTable2,Integer>cancerLevel;

    ObservableList<ModelTable2>oblist = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Database connection
        try {
            Class.forName("org.sqlite.JDBC");  // Loading and registering the driver.

            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:sqlite:doctorsDB.sqlite"); // Setting up the connection.

            ResultSet resultset= conn.createStatement().executeQuery("select patientID,name,age,extra_Details,Cancer_Level from patients;");
            while(resultset.next()) {
                oblist.add(new ModelTable2(resultset.getInt("patientID"),resultset.getString("name"),resultset.getInt("age"),
                      resultset.getString("extra_Details"),resultset.getInt("Cancer_Level")));
            }


        } catch (Exception e) { System.out.println("Ex:"+e);}

        //System.out.println(oblist);

        patientID.setCellValueFactory(new PropertyValueFactory<>("patientIDs"));
        name.setCellValueFactory(new PropertyValueFactory<>("names"));
        age.setCellValueFactory(new PropertyValueFactory<>("ages"));
        extraDetails.setCellValueFactory(new PropertyValueFactory<>("extraDetailS"));
        cancerLevel.setCellValueFactory(new PropertyValueFactory<>("CancerLevels"));

        table.setItems(oblist);

    }

    public void visualizeGraphs(ActionEvent event) throws Exception {
        //((Node) event.getSource()).getScene().getWindow().hide(); // to hide previous window

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Doctor_Visualize_Graphs.fxml"));
        Scene scene = new Scene(root, 900, 700);
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void returnHome(MouseEvent event) throws Exception {
        ((Node) event.getSource()).getScene().getWindow().hide(); // to hide previous window

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("DoctorWork.fxml"));
        Scene scene = new Scene(root, 1300, 680);
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
