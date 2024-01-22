module fr.tp.tpnoterattrapage {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.tp.tpnoterattrapage to javafx.fxml;
    exports fr.tp.tpnoterattrapage;
}