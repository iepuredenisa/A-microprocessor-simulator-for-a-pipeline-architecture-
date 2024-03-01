module com.example.project_ssc {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.project_ssc to javafx.fxml;
    exports com.example.project_ssc;
}