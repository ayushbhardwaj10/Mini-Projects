package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Doctor_Visualize_Graphs implements Initializable {
    @FXML
    private BarChart<?,?> barChart;

    @FXML
    private PieChart pieChart;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        XYChart.Series set1 = new XYChart.Series<>();
        int y1=0,y2=0,y3=0,y4=0,y5=0,y6=0,y7=0,y8=0,y9=0,y10=0,y11=0,y12=0;


        // Pie chart
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:doctorsDB.sqlite");
            Statement statement = conn.createStatement();

            String query = "select patientID from patients where Cancer_Level==2 ;";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                y11=y11+1;
            }
            query = "select patientID from patients where Cancer_Level==4 ;";
            resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                y12=y12+1;
            }

        }catch(Exception e) {
            System.out.println("EX:"+e);
        }
        ObservableList<PieChart.Data> pieChartData= FXCollections.observableArrayList(
         new PieChart.Data("Stage 2(Healthy)",y11),
         new PieChart.Data("Stage 4(Un-Healthy",y12)
        );
        pieChart.setData(pieChartData);

        //Bar graph
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:doctorsDB.sqlite");
            Statement statement = conn.createStatement();

            String query = "select patientID from patients where age>=0 and age<=9;";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                y1=y1+1;
            }
            query = "select patientID from patients where age>=10 and age<=19;";
            resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                y2=y2+1;
            }
            query = "select patientID from patients where age>=20 and age<=29;";
            resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                y3=y3+1;
            }
            query = "select patientID from patients where age>=30 and age<=39;";
            resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                y4=y4+1;
            }
            query = "select patientID from patients where age>=40 and age<=49;";
            resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                y5=y5+1;
            }
            query = "select patientID from patients where age>=50 and age<=59;";
            resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                y6=y6+1;
            }
            query = "select patientID from patients where age>=60 and age<=69;";
            resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                y7=y7+1;
            }
            query = "select patientID from patients where age>=70 and age<=79;";
            resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                y8=y8+1;
            }
            query = "select patientID from patients where age>=80 and age<=89;";
            resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                y9=y9+1;
            }
            query = "select patientID from patients where age>=90 and age<=100";
            resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                y10=y10+1;
            }


        } catch(Exception e) {
            System.out.println("Ex :"+e);
        }

        set1.getData().add(new XYChart.Data("0-10",y1));
        set1.getData().add(new XYChart.Data("10-20",y2));
        set1.getData().add(new XYChart.Data("20-30",y3));
        set1.getData().add(new XYChart.Data("30-40",y4));
        set1.getData().add(new XYChart.Data("40-50",y5));
        set1.getData().add(new XYChart.Data("50-60",y6));
        set1.getData().add(new XYChart.Data("60-70",y7));
        set1.getData().add(new XYChart.Data("70-80",y8));
        set1.getData().add(new XYChart.Data("80-90",y9));
        set1.getData().add(new XYChart.Data("90-100",y10));


        barChart.getData().addAll(set1);
    }
}
