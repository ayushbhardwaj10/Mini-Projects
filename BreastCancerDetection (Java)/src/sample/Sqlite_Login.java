package sample;

import java.sql.*;

    public class Sqlite_Login {

        public static Connection Connector() {   //Return type is of Connection type
            try {
                Class.forName("org.sqlite.JDBC");  // step1 : Loading and registering oracle driver for DB connection
                Connection conn= DriverManager.getConnection("jdbc:sqlite:doctorsDB.sqlite"); //Step2:Establish the connection
                return conn;
            }catch(Exception e) {
                System.out.println(e);
                return null;
            }
        }

    }


