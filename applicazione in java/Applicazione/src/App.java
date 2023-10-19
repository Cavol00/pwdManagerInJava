import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        FileWriter writer = new FileWriter("passwordManager.txt");
        FileReader reader = new FileReader("passwordManager.txt");

        System.out.println("Questa applicazine è stata creata da Dario.");

        String utente = "cavol00";
        String pwd = "dario";

        String y = " ";
        String x = " ";

        while (!utente.equals(y) || !pwd.equals(x)) {
            System.out.print("Scrivere il nome utente: ");
            y = sc.nextLine();
            System.out.print("Scrivere la password: ");
            x = sc.nextLine();

            if (pwd.equals(x) && utente.equals(y)) {
                System.out.println("Benvenuto " + utente + " cosa vuole fare?");
                System.out.println("Scrivere il numero per accedere al menu");
                System.out.println("1: Visionare le password");
                System.out.println("2: Aggiungere nuova password");
                System.out.println("3: Esci");
                int scelta = sc.nextInt();
                switch (scelta) {
                    case 1:
                        
                        System.out.println("Scrivere per quale applicazione/mail/account sta cercando la password");
                        String input = sc.nextLine();
                        try {
                            BufferedReader bufferedReader = new BufferedReader(reader);

                            String linea;

                            while ((linea = bufferedReader.readLine()) != null) {
                                if (linea.contains(input)) {
                                    System.out.println(linea);
                                }
                            }

                            bufferedReader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        break;
                    case 3:
                        System.out.println("Grazie spero di essere stato utile. Addio frocio.");
                        break;
                    default:
                        System.out.println("Input non valido mettere 1, 2, 3 per favore.");
                        break;
                }

            } else {
                System.out.println("Riprovare nome utente o password non validi");
            }
        }

    }

}
