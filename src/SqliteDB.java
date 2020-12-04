import java.sql.*;

public class SqliteDB {

    Connection c = null;
    Statement stat = null;

    // constructor
    public SqliteDB(){
        // try connect to DB
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:Students.db");
            System.out.println("Connected to DB OK!!");

        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void  listStudents(){

        try {
            this.stat = c.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM Student");
            while (rs.next()){
                // while the result has a next record we run this
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println(" Student ID: " + id + ", Student Name: " + name + ", Student Age: " + age);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void closeConnection(){
        try {
            c.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void executeQuery(String query){

        try {
            this.stat = c.createStatement();
            stat.executeQuery(query);

        } catch (SQLException throwables) {
//            throwables.printStackTrace();

        }

    }

}
