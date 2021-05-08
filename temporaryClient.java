package Client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class temporaryClient {
    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getByName("localhost");
            Socket socket = new Socket(ip, 888);
            System.out.println("Client requested for connection");
        } catch (UnknownHostException ex) {
            Logger.getLogger(temporaryClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(temporaryClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
