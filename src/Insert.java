import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
    public static void main(String args[]) {
        Connection c = null;
        Statement stmt=null;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/client",
                            "postgres", "root");
            System.out.println("Opened database successfully");
            c.setAutoCommit(false);
            try{stmt = c.createStatement();
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


            c.commit();

            }catch (SQLException e){
                c.rollback();
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
           System.exit(0);
        }
finally {
            if(stmt!=null){
                try {
                    stmt.close();
                    System.out.println("Statement it's cloused");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }if (c!=null){
                try {
                    c.close();
                    System.out.println("Connection it's cloused");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

