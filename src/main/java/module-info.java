module org.example.hotelmanager {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.hotelmanager to javafx.fxml;
    exports org.example.hotelmanager;
    exports Backend;
    opens Backend to javafx.fxml;
}