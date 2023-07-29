package main;
//Server.java
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class PrimeServer extends Application {

 @Override
 public void start(Stage primaryStage) {
     new Thread(() -> {
         try (ServerSocket serverSocket = new ServerSocket(5555)) {
             System.out.println("Server started and listening on port 5555...");

             while (true) {
                 Socket clientSocket = serverSocket.accept();
                 System.out.println("Connected to a client.");

                 ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());
                 ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());

                 // Read the number from the client
                 int number = inputStream.readInt();

                 // Compute whether the number is prime
                 boolean isPrime = isPrime(number);

                 // Respond to the client
                 outputStream.writeBoolean(isPrime);
                 outputStream.flush();

                 clientSocket.close();
             }
         } catch (IOException e) {
             e.printStackTrace();
         }
     }).start();
 }

 // Method to check if a number is prime
 private boolean isPrime(int number) {
     if (number <= 1) return false;
     for (int i = 2; i <= Math.sqrt(number); i++) {
         if (number % i == 0) return false;
     }
     return true;
 }

 public static void main(String[] args) {
     launch(args);
 }
}
