package com.ilyap.scrambling;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

public class ScramblingController {

    @FXML
    private TextField defaultDescramblerField;

    @FXML
    private TextField defaultScramblerField;

    @FXML
    private TextField enhancedDescramblerField;

    @FXML
    private TextField enhancedScramblerField;

    @FXML
    private Button scramblingButton;

    @FXML
    private TextField sourceField;

    @FXML
    void initialize() {
        scramblingButton.setOnAction(actionEvent -> setResults(sourceField.getText()));
        sourceField.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                setResults(sourceField.getText());
            }
        });
    }

    public void setResults(String sourceCode) {
        defaultScramblerField.setText(DefaultScrambler.scramble(sourceCode));
        defaultDescramblerField.setText(DefaultScrambler.descramble(defaultScramblerField.getText()));
        enhancedScramblerField.setText(EnhancedScrambler.scramble(sourceCode));
        enhancedDescramblerField.setText(EnhancedScrambler.descramble(enhancedScramblerField.getText()));
    }
}
