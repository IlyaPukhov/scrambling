module com.ilyap.scrambling {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ilyap.scrambling to javafx.fxml;
    exports com.ilyap.scrambling;
}