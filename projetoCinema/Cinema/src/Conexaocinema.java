import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexaocinema{
    public Connection conexao=null;
    final String DRIVER = "com.mysql.cj.jdbc.Driver";
    final String DBNAME = "cinema";
    final String URL = "jdbc:mysql://localhost:3306/"+DBNAME;
    final String LOGIN = "root";
    final String SENHA = "";

    public boolean criarConexao() {
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            //JOptionPane.showMessageDialog(null, "Conexão com sucesso");
            return true;
        } catch (ClassNotFoundException erro) {
            JOptionPane.showMessageDialog(null, erro);
            return false;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
            return false;
        }
    }
}