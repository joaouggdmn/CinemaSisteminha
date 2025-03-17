import java.sql.SQLException;
import java.util.Scanner;

public class CinemaMenu {
    public static void main(String[] args) throws SQLException {
        Conexaocinema bd =new Conexaocinema();
        CinemaFunc cin=new CinemaFunc();
        Scanner tc = new Scanner(System.in);
        int opc;
        boolean cont = true;
        bd.criarConexao();
        while (cont) {
            System.out.println("---MENU CINEMA---");
            System.out.println("1- Cadastre-se");
            System.out.println("2- Escolher assentos");
            System.out.println("3- SAIR");
            System.out.print("ESCOLHA UMA OPÇÃO: ");
            opc = tc.nextInt();

            switch (opc) {
                case 2:
                    cin.escLugares();
                    break;
                case 1:
                    cin.cadastrocliente();
                    break;
                case 3:
                    cont = false;
                    break;
                default:
                    System.out.print("\nESOCOLHA UMA OPÇÃO VÁLIDA\n");
            }
        }
    }
}