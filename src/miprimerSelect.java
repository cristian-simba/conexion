import java.sql.*;
public class miprimerSelect {
    static final String DB_URL =  "jdbc:mysql://localhost/universidad";
    static final String USER  = "root";
    static final String PASS = "root_bas3";
    static final String QUERY = "SELECT *from estudiantes";

    public static void main(String[] args) {
        try(
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(QUERY);

                ){
            while(rs.next()){
                System.out.println("ID:"+rs.getInt("ID"));
                System.out.println("Nombre:"+rs.getString("Nombre"));
                System.out.println("Edad" +rs.getInt("Edad"));
                System.out.println("Ciudad"+rs.getString("Ciudad"));
                System.out.println("Cedula"+rs.getInt("Cedula"));
            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
