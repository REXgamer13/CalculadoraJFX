package com.example.calculadorafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    
    @FXML
    private Button bt0;
    @FXML private Button bt1;
    @FXML private Button bt2;
    @FXML private Button bt3;
    @FXML private Button bt4;
    @FXML private Button bt5;
    @FXML private Button bt6;
    @FXML private Button bt7;
    @FXML private Button bt8;
    @FXML private Button bt9;
    @FXML private Button btAns;
    @FXML private Button btC;
    @FXML private Button btDel;
    @FXML private Button btDividir;
    @FXML private Button btMultiplicar;
    @FXML private Button btPorcentaje;
    @FXML private Button btPunto;
    @FXML private Button btRestar;
    @FXML private Button btResultado;
    @FXML private Button btSumar;
    @FXML private TextArea textareaHistory;
    @FXML private TextField textfieldResult;
    
    private boolean operationOn = true;
    private double lastOperation = 0;
    
    public void cleanScreen() {
        textfieldResult.clear();
        operationOn = true;
    }
    
    public void deleteValue() {
        if (textfieldResult.getText().length() > 0) {
            textfieldResult.setText(textfieldResult.getText().substring(0, textfieldResult.getText().length() - 1));
        }
    }
    
    public void getLastResult() {
        if (lastOperation != 0) {
            textfieldResult.appendText(Double.toString(lastOperation));
        }
    }
    
    public void addValue(javafx.event.ActionEvent actionEvent) {
        textfieldResult.appendText(((Button) actionEvent.getSource()).getText());
        operationOn = true;
    }
    
    public void addOperation(javafx.event.ActionEvent actionEvent) {
        if (operationOn) {
            textfieldResult.appendText(((Button) actionEvent.getSource()).getText());
            operationOn = false;
        }
    }
    
    public void makeOperation() {
        String input = textfieldResult.getText(); 
        double result = 0; 
         
        if (input.contains("+")) { 
            result = performOperation(input, "\\+", "+"); 
        } else if (input.contains("-")) { 
            result = performOperation(input, "-", "-"); 
        } else if (input.contains("*")) { 
            result = performOperation(input, "\\*", "*"); 
        } else if (input.contains("/")) { 
            result = performOperation(input, "/", "/"); 
        } else if (input.contains("%")) { 
            result = performOperation(input, "%", "%"); 
        } 
         
        textfieldResult.setText(String.valueOf(result)); 
        lastOperation = result; 
        textareaHistory.appendText(input + " = " + result + "\n"); 
    } 
     
    private double performOperation(String input, String operator, String symbol) { 
        String[] numbers = input.split(operator); 
        double operand1 = Double.parseDouble(numbers[0]); 
        double operand2 = Double.parseDouble(numbers[1]); 
         
        switch (symbol) { 
            case "+": 
                return operand1 + operand2; 
            case "-": 
                return operand1 - operand2; 
            case "*": 
                return operand1 * operand2; 
            case "/": 
                return operand1 / operand2; 
            case "%": 
                return operand1 % operand2; 
            default: 
                return 0; 
        } 
    }
}