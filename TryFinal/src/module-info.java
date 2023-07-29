module TryFinal {
	requires javafx.controls;
	requires javafx.fxml;
	requires org.jsoup;
	requires javafx.graphics;
	
	opens main to javafx.graphics, javafx.fxml;
}
