import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CinemaFunc {
    public static int lugares[] = new int[41], //lugares disponíveis
     i, qtde, rep, asc //assentos
     ,j=0, k=0;

    public static String nome, email,  datanasc;

    public void cadastrocliente() throws SQLException{
        Conexaocinema cn=new Conexaocinema();
        cn.criarConexao();
        String SQL="INSERT INTO cadastro (nome_cadastro,email_cadastro,anonasc_cadastro) VALUES(?,?,?)";
        PreparedStatement inclusao = cn.conexao.prepareStatement(SQL);
        int ndata;
        System.out.println("\nCADASTRO");
        k++;
        Scanner tc = new Scanner(System.in);
        System.out.print("Nome: ");
        nome=tc.nextLine();
        System.out.print("Email: ");
        email=tc.nextLine();
        System.out.print("Data de nascimento (DD/MM/AAAA): ");
        datanasc=tc.nextLine();
        System.out.println();
        ndata= Integer.parseInt(datanasc.substring(6,10)+datanasc.substring(3,5)+datanasc.substring(0,2));

        inclusao.setString(1,nome);
        inclusao.setString(2,email);
        inclusao.setInt(3,ndata);
        inclusao.execute();
    }
    public void escLugares()throws SQLException{
        CinemaFunc cinema=new CinemaFunc();
        Conexaocinema c=new Conexaocinema();
        c.criarConexao();
        String SQL="INSERT INTO bilheteria (num_assento) VALUES(?)";
        PreparedStatement inclusao = c.conexao.prepareStatement(SQL);

        if(k!=0){
                Scanner tc = new Scanner(System.in);

                //mostra os assentos disponíveis
                System.out.println("\n-OPÇÃO 1: \nLUGARES DISPONÍVEIS:");
                for (i = j; i <= 40; i++) {
                    if (i == 0) {
                        i++;
                    }if (lugares[i] == 1) {
                        System.out.print(" ASSENTO RESERVADO  |  ");
                    } else {
                        System.out.print(i + "  |  ");
                    }
                }
                //quantos assentos o usuário deseja reservar
                System.out.print("\n\nQuantos Lugares deseja reservar? ");
                qtde = tc.nextInt();
                rep = 0;
                int ar = 0;

                while (rep < qtde) {
                    //escolha dos assentos
                    System.out.print("\nEscolha um assento (1 a 40): ");
                    asc = tc.nextInt();

                    if (asc < 0 || asc >= 40) {
                        System.out.println("Assento inválido! Escolha um assento entre 0 e 39.");
                        continue;
                    }
                    if (lugares[asc] == 1) {
                        System.out.println("Assento já reservado! Escolha outro.");
                        continue;
                    }
                    lugares[asc] = 1;
                    System.out.println("Assento " + asc + " reservado com sucesso!");

                    System.out.println("\nLUGARES DISPONÍVEIS:");
                    for (i = 0; i <= 40; i++) {
                        if (i == 0) {
                            i++;
                        }
                        if (lugares[i] == 1) {
                            System.out.print(" ASSENTO RESERVADO  |  ");
                        }else {
                            System.out.print(i + "  |  ");
                        }
                    }
                    rep++;
                }
                System.out.println("\nReserva concluída. Obrigado!\n");
        } else{
            System.out.println("Cadastre-se, primeiramente!\n");
            cinema.cadastrocliente();
        }
        inclusao.setInt(1,asc);
        inclusao.execute();
    }
}
