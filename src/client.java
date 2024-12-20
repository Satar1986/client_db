import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLOutput;


public class client {
    public static void main(String[] args) {

        Connection c ;
        try{
            Class.forName("org.postgresql.Driver");
            c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/client","postgres","root");
            System.out.println("Opened database successfully");
        }  catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }

    }

}