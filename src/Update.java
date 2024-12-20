import java.sql.*;

public class Update {
    public static void main( String args[] ) {
        Connection c =null;
        Statement stmt=null;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/client",
                            "postgres", "root");
            System.out.println("Opened database successfully");
            c.setAutoCommit(false);
            try{stmt = c.createStatement();
            String sql = "UPDATE client set age = 76 where ID=3;";
            stmt.executeUpdate(sql);


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
                c.commit();
            }catch (SQLException e){
                c.rollback();
                e.printStackTrace();
            }



        } catch ( Exception e ) {
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
