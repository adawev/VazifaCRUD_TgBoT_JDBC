package diyor.adashev.Database;

import java.sql.*;

public class MyDatabase {
    String url = "jdbc:postgresql://localhost:5432/sinf11a24";
    String username = "postgres";
    String password = "root";


    public void addVazifa(Vazifa vazifa ) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String query = "insert into vazifa(id, name, sana, status) values("+vazifa.getId()+",'"+vazifa.getName()+"','"+vazifa.getSana()+"','"+vazifa.getStatus()+"')";
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public String readVazifa(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "select * from vazifa";
            ResultSet resultSet = statement.executeQuery(query);
            StringBuilder result = new StringBuilder();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String sana = resultSet.getString(3);
                String status = resultSet.getString(4);
                result.append("Id: ").append(id).append("\n");
                result.append("Name: ").append(name).append("\n");
                result.append("Sana: ").append(sana).append("\n");
                result.append("Status: ").append(status).append("\n\n");
            }
            return result.toString();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteVazifa(int id){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String query = "delete from vazifa where id="+id;
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateVazifa(int id, String name){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query="update vazifa set name='"+name+"' where id="+id;

            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
