import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Update {
    public static void main( String args[] ) {
        Connection c ;
        Statement stmt ;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/client",
                            "postgres", "root");
            System.out.println("Opened database successfully");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "UPDATE client set age = 32 where ID=3;";
            stmt.executeUpdate(sql);
            c.commit();

            ResultSet rs = stmt.executeQuery( "SELECT * FROM client;" );
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String  name = rs.getString("name");
                int age  = rs.getInt("age");

                System.out.println( "id = " + id );
                System.out.println( "name = " + name );
                System.out.println( "age = " + age );

                System.out.println();
            }
            System.out.println("Operation done successfully");
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }

    }
}
