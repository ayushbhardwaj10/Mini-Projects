package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.util.Arrays;

public class Doctor_compute {

    @FXML
    private TextField radius ;
    @FXML
    private TextField texture ;
    @FXML
    private TextField perimeter ;
    @FXML
    private TextField area ;
    @FXML
    private TextField smoothness ;
    @FXML
    private TextField compactness ;
    @FXML
    private TextField concavity ;
    @FXML
    private TextField concavePoints ;
    @FXML
    private TextField symmetry ;
    @FXML
    private Label result;




    public void returnHome(MouseEvent event) throws Exception {
        ((Node) event.getSource()).getScene().getWindow().hide(); // to hide previous window

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("DoctorWork.fxml"));
        Scene scene = new Scene(root, 1300, 680);
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void read() throws  Exception {
        // Reading the file and dispaying the result on label

        String fileName = "F:\\eclipse-workspace\\breastCancerDetection_Trial\\Breast cancer detection\\yPred.txt";
        File file = new File(fileName);
        FileReader fr = null;

        fr = new FileReader(file);

        String res = null;
        BufferedReader br = new BufferedReader(fr);

        String line;
        while((line = br.readLine()) != null) {
            res = line;
        }
        result.setText(res);
    }

    public void calculate() throws Exception{


        String s1= radius.getText();
        String s2= texture.getText();
        String s3= perimeter.getText();
        String s4= area.getText();
        String s5= smoothness.getText();
        String s6= compactness.getText();
        String s7= concavity.getText();
        String s8= concavePoints.getText();
        String s9= symmetry.getText();

        Thread writeFile= new Thread(new Runnable() {
            @Override
            public void run() {


                new writeCsv("F:\\eclipse-workspace\\breastCancerDetection_Trial\\Breast cancer detection\\patientTest.csv",s1,s2,s3,s4,s5,s6,s7,s8,s9);
            }
        });

        writeFile.start();
        try {writeFile.join();} catch(Exception e){};

        System.out.println("Calculation FINISHED.....!!!!!!!!!!!!!");

        Thread commandPrompt = new Thread(new Runnable() {
            @Override
            public void run() {
                new cmd();
            }
        });
        commandPrompt.start();
        try {commandPrompt.join();} catch(Exception e){} ;

        //Circular progress bar
        Stage primaryStage = new Stage();
        RingProgressIndicator ringProgressIndicator = new RingProgressIndicator();
        ringProgressIndicator.setRingWidth(200);
        ringProgressIndicator.makeIndeterminate();
        StackPane root = new StackPane();
        root.getChildren().add(ringProgressIndicator);
        Scene scene = new Scene(root,300,250);
        primaryStage.setTitle("Progress...");
        primaryStage.setScene(scene);
        primaryStage.show();
        new WorkThread(ringProgressIndicator).start();

    }

    public void saveResults() throws Exception {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("DoctorWork_saveResults.fxml"));
        Scene scene = new Scene(root, 450, 400);
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();

    }


}

class WorkThread extends Thread {
    RingProgressIndicator rpi;
    int progress=0;

    public WorkThread(RingProgressIndicator rpi) {
        this.rpi=rpi;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(100);
            } catch(InterruptedException ex){};
            Platform.runLater(()->{
                rpi.setProgress(progress);
            });
            progress=progress+1;
            if(progress==100)
                break;
        }
    }
}

