module com.polytechnique.tpfinalpoo2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires jdk.management;
    requires com.fasterxml.jackson.databind;

    opens com.polytechnique.tpfinalpoo2 to javafx.fxml;
    exports com.polytechnique.tpfinalpoo2;
    exports com.polytechnique.tpfinalpoo2.views to javafx.graphics;
    exports com.polytechnique.tpfinalpoo2.views.vParticipant to javafx.graphics;
    exports com.polytechnique.tpfinalpoo2.sauvegarde;
    opens com.polytechnique.tpfinalpoo2.sauvegarde to javafx.fxml;
}