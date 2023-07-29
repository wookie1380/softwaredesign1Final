package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;



		


		public class scrape extends Application {

		    public static void main(String[] args) {
		        launch(args);
		    }

		    @Override
		    public void start(Stage primaryStage) {
		        String url = "https://www.gutenberg.org/files/1065/1065-h/1065-h.htm";
		        Document doc;
		        try {
		            doc = Jsoup.connect(url).get();
		        } catch (IOException e) {
		            e.printStackTrace();
		            return;
		        }

		        Element targetDiv = doc.selectFirst("div.chapter");
		        String content = targetDiv.text();
		        String[] words = content.split("\\s+");
		        Map<String, Integer> wordCounts = new TreeMap<>();
		        for (String word : words) {
		            wordCounts.merge(word, 1, Integer::sum);
		        }

		        // Create a TextArea to display the output
		        TextArea textArea = new TextArea();
		        textArea.setEditable(false); // Make the TextArea read-only

		        // Create the output text
		        StringBuilder outputText = new StringBuilder();
		        outputText.append("Word\\tCount\n");
		        wordCounts.entrySet().stream()
		                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
		                .forEach(entry -> outputText.append(entry.getKey()).append(" : ").append(entry.getValue()).append("\n"));

		        // Set the output text to the TextArea
		        textArea.setText(outputText.toString());

		        // Create the scene and add the TextArea to it
		        StackPane root = new StackPane(textArea);
		        Scene scene = new Scene(root, 800, 600);

		        primaryStage.setTitle("Word Count Scraper");
		        primaryStage.setScene(scene);
		        primaryStage.show();
		    }
		

		
		
	}


