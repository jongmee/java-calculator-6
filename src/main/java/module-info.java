module com.wooteco.calculator {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.wooteco.calculator to javafx.fxml;
    exports com.wooteco.calculator;
}