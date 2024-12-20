import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Insert {
    public static void main(String args[]) {
        Connection c;
        Statement stmt;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/client",
                            "postgres", "root");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "insert into client (id,name,age) "
                    + "values (1, 'Tom', 20 );";
            stmt.executeUpdate(sql);

            sql = "insert into client (id,name,age) "
                    + "values (2, 'Bob', 26 );";
            stmt.executeUpdate(sql);

            sql = "insert into client (id,name,age) "
                    + "values (3, 'Teddy', 23 );";
            stmt.executeUpdate(sql);

            sql = "insert into client (id,name,age) "
                    + "values (4, 'Mark', 40 );";
            stmt.executeUpdate(sql);
            System.out.println("Records created successfully");
            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }

    }
}

