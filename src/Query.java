import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Query {
    private JPanel query;
    private JButton queryButton;
    private JTextArea datos;
    static final String DB_URL =  "jdbc:mysql://localhost/universidad";
    static final String USER  = "root";
    static final String PASS = "root_bas3";
    static final String QUERY = "SELECT *from estudiantes";
    public Query() {
    queryButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
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
                    datos.append(
                            "ID: " + rs.getInt("ID") + "\n" +
                            "Nombre: " + rs.getString("Nombre")+ "\n" +
                            "Edad: " + rs.getInt("Edad") + "\n";

                }

            }catch (Exception ex){
                throw new RuntimeException(ex);
            }
        }
    });
}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Query");
        frame.setContentPane(new Query().query);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
