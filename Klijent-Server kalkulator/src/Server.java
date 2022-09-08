import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8000);
            System.out.println("Connected...");
            Socket client = server.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
            String client_message = "";
            do {
                client_message = reader.readLine();

                    System.out.println("Preparing to send !CALC");
                    writer.println("!CALC");
                    System.out.println("Sent !CALC");
                    int a = Integer.parseInt(reader.readLine());
                    System.out.println("Received a.");
                    int b = Integer.parseInt(reader.readLine());
                    System.out.println("Received b.");
                    writer.println(a + b);
                    System.out.println("Sent a + b.");


            } while (!client_message.equals("!END"));
            reader.close();
            writer.close();
            client.close();
            server.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
