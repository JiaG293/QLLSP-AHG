module com.openjfx.qllspahg {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires com.microsoft.sqlserver.jdbc;

    exports com.openjfx.qllspahg.gui;
    opens com.openjfx.qllspahg.gui to javafx.fxml;
    exports com.openjfx.qllspahg;
    opens com.openjfx.qllspahg to javafx.fxml;

}