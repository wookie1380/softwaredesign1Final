package main;

import javafx.stage.Stage;



//Main Java Class
public class MultipleMain {
 public static void main(String[] args) throws Exception {
     // Launch the JavaFX applications by calling launch()
     javafx.application.Application.launch(PrimeServer.class);
     javafx.application.Application.launch(JavaFXApp2.class);

     // Create instances of JavaFX classes
     PrimeServer app1 = new PrimeServer();
     PrimeClient app2 = new PrimeClient();

     // Start the JavaFX applications (optional, depending on the use case)
     Stage stage1 = new Stage();
     Stage stage2 = new Stage();
     app1.start(stage1);
     app2.start(stage2);

     // Extract outputs from JavaFX classes (assuming they have methods to provide outputs)
     String output1 = app1.start(); // Replace 'getOutput()' with the actual method in JavaFXApp1
     String output2 = app2.start(); // Replace 'getOutput()' with the actual method in JavaFXApp2

     // Use or display the outputs
     System.out.println("Combined Output:");
     System.out.println(output1);
     System.out.println(output2);

     // ... Other logic using the outputs
 }
 
//JavaFX Class 1
public class PrimeServer extends javafx.application.Application {

@Override
public String start() {
    // JavaFX component setup and output generation
    String output1 = "Output from JavaFXApp1";
    System.out.println(output1);
    // ... Other JavaFX component setup and logic
}

@Override
public void start(Stage arg0) throws Exception {
	// TODO Auto-generated method stub
	
}

// Other methods as needed
}

//JavaFX Class 2
private class JavaFXApp2 extends javafx.application.Application {

@Override
public void start(Stage primaryStage) {
    // JavaFX component setup and output generation
    String output2 = "Output from JavaFXApp2";
    System.out.println(output2);
    // ... Other JavaFX component setup and logic
}

// Other methods as needed
}
}

