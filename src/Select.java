import java.sql.*;

public class Select {
    public static void main( String args[] ) {
        Connection c=null;
        Statement stmt=null;

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/client",
                            "postgres", "root");
            System.out.println("Opened database successfully");
            c.setAutoCommit(false);
           try{ stmt = c.createStatement();
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
               c.commit();
               rs.close();
           }catch (SQLException e){
               c.rollback();
               e.printStackTrace();
           }
            System.out.println("Operation done successfully");



        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }finally {
            if (stmt!=null){
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

