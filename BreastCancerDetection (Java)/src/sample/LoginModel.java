package sample;

import java.sql.*;

public class LoginModel {

    //Creating object for Connection Class
    Connection connection;

    public LoginModel() {  // To establish the connection the database
        connection= Sqlite_Login.Connector();

        //Handling Null condition
        if(connection == null)
        { System.out.println("Connection is not Successful");
            System.exit(1);    //close application
        }
    }

    public boolean isDbConnected() {
        try {
            return !connection.isClosed(); // If connection is not closed then we are connected.
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }

    }

    public boolean isLogin(String user,String pass) throws SQLException {
        PreparedStatement preparedstatement=null ;
        ResultSet resultset=null;
        String query = "select * from doctors where username= ? and password= ?";
        try {
            preparedstatement= connection.prepareStatement(query);
            preparedstatement.setString(1, user);
            preparedstatement.setString(2, pass);

            resultset= preparedstatement.executeQuery();

             if(resultset.next()) {
                return true;
            }
            else {
                return false;
            }

        }catch(Exception e) {
            return false;
        }finally {                    // A good practice to write this, this code always executes under exception occurrence
            if (preparedstatement != null) {
                preparedstatement.close();
            }
            if(resultset != null){
                resultset.close();
            }

        }
    }
}


