package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class Admin_show implements Initializable {

    @FXML
    private TableView<ModelTable>table;
    @FXML
    private TableColumn<ModelTable,Integer>col_patientID;
    @FXML
    private TableColumn<ModelTable,String>col_name;
    @FXML
    private TableColumn<ModelTable,Integer>col_age;
    @FXML
    private TableColumn<ModelTable,String>col_dob;
    @FXML
    private TableColumn<ModelTable,String>col_email;
    @FXML
    private TableColumn<ModelTable,Long>col_phoneNumber;
    @FXML
    private TableColumn<ModelTable,String>col_extraDetails;
    @FXML
    private TableColumn<ModelTable,Integer>col_cancerLevel;

    ObservableList<ModelTable>oblist = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Database connection
        try {
            Class.forName("org.sqlite.JDBC");  // Loading and registering the driver.

            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:sqlite:doctorsDB.sqlite"); // Setting up the connection.

            ResultSet resultset= conn.createStatement().executeQuery("select * from patients;");
            while(resultset.next()) {
                oblist.add(new ModelTable(resultset.getInt("patientID"),resultset.getString("name"),resultset.getInt("age"),resultset.getString("dob"),
                        resultset.getString("email"),resultset.getLong("phoneNo"),resultset.getString("extra_Details"),resultset.getInt("Cancer_Level")));
            }


        } catch (Exception e) { System.out.println("Ex:"+e);}

        //System.out.println(oblist);

        col_patientID.setCellValueFactory(new PropertyValueFactory<>("patientIDs"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("names"));
        col_age.setCellValueFactory(new PropertyValueFactory<>("ages"));
        col_dob.setCellValueFactory(new PropertyValueFactory<>("dobs"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("emails"));
        col_phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNos"));
        col_extraDetails.setCellValueFactory(new PropertyValueFactory<>("extraDetails"));
        col_cancerLevel.setCellValueFactory(new PropertyValueFactory<>("CancerLevel"));

        table.setItems(oblist);

    }

    public void returnHome(MouseEvent event) throws Exception {
        ((Node) event.getSource()).getScene().getWindow().hide(); // to hide previous window

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AdminWork.fxml"));
        Scene scene = new Scene(root, 1300, 680);
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
