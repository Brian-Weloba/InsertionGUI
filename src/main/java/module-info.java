module com.srathmore.gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;

    requires org.controlsfx.controls;

    opens com.srathmore.gui to javafx.fxml;
    exports com.srathmore.gui;
}