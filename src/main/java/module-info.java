module com.example.week10_lab9_10_javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.week10_lab9_10_javafx to javafx.fxml;
    exports com.example.week10_lab9_10_javafx;
    opens com.example.week10_lab9_10_javafx.controller.form to javafx.fxml;
    exports com.example.week10_lab9_10_javafx.controller.form;
}