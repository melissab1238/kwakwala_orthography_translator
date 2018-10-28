package ui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static work.Translator.translateWord;

public class SmallTranslator extends SceneLayout{

    public static void display(Stage window) {
        window.setTitle("Single Word Translator");

        VBox vBox= new VBox(10);
        vBox.setAlignment(Pos.CENTER);

        //TODO: add option of trasnlating from Napa or To napa (to/from either)
        Label inputLabel = new Label("Input word: ");
        TextField inputField = new TextField("");
        inputField.autosize();
        Button translateToUmistaButton = new Button("Translate word to Umista");

        Button translateToNapaButton = new Button("Translate word to NAPA");

        Label outputLabel = new Label("");

        translateToUmistaButton.setOnAction(e -> {
            outputLabel.setText(translateWord(inputField.getText(), "Umista"));
        });
        translateToNapaButton.setOnAction(e -> {
            outputLabel.setText(translateWord(inputField.getText(), "NAPA"));
        });

        Button copyToClipBoardButton = new Button("Copy to clipboard");
        copyToClipBoardButton.setOnAction(e -> {
            //TODO copyto clipboard function
            // //outputLabel.getText().______
            System.out.println("clipboard button");
        });

        vBox.getChildren().addAll(inputLabel, inputField, translateToNapaButton, translateToUmistaButton, outputLabel);

        setScene(vBox, window);
    }
}
