module com.example.fxmlassignnment {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.fxmlassignnment to javafx.fxml;
    exports com.example.fxmlassignnment;
}