import java.io.FileReader;
import java.util.Scanner;

public class ClientList {

    static int clientLength = 5;

    Client[] clients = new Client[clientLength];

    public void ClientList() throws Exception {
        FileReader fr = new FileReader("clientList.txt");
        Scanner inFile = new Scanner(fr);

        for(int i = 0 ; i < clientLength; i++){
            clients[i].setTitle(inFile.nextLine());
            clients[i].setPayment(Integer.parseInt(inFile.nextLine()));
            clients[i].setHourPay(Integer.parseInt(inFile.nextLine()));
            clients[i].setFlavorText(inFile.nextLine());
        }

        inFile.close(); //Close file
    }

}
