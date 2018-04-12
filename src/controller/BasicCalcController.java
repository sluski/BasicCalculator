package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Sluski
 */
public class BasicCalcController implements Initializable {
    
    private static List<String> operations;
    private boolean isOperator;
    
    @FXML
    public TextArea output;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        operations = new ArrayList();
    }
    
    @FXML
    public void num_zero(ActionEvent event){
        operations.add("0");
        updateOutput();
        isOperator = false;
    }
    
    @FXML
    public void num_one(ActionEvent event){
        operations.add("1");
        updateOutput();
        isOperator = false;
    }
    
    @FXML
    public void num_two(ActionEvent event){
        operations.add("2");
        updateOutput();
        isOperator = false;
    }
    
    @FXML
    public void num_three(ActionEvent event){
        operations.add("3");
        updateOutput();
        isOperator = false;
    }
    
    @FXML
    public void num_four(ActionEvent event){
        operations.add("4");
        updateOutput();
        isOperator = false;
    }
    
    @FXML
    public void num_five(ActionEvent event){
        operations.add("5");
        updateOutput();
        isOperator = false;
    }
    
    @FXML
    public void num_six(ActionEvent event){
        operations.add("6");
        updateOutput();
        isOperator = false;
    }
    
    @FXML
    public void num_seven(ActionEvent event){
        operations.add("7");
        updateOutput();
        isOperator = false;
    }
    
    @FXML
    public void num_eight(ActionEvent event){
        operations.add("8");
        updateOutput();
        isOperator = false;
    }
    
    @FXML
    public void num_nine(ActionEvent event){
        operations.add("9");
        updateOutput();
        isOperator = false;
    }
    
    @FXML
    public void char_dot(ActionEvent event){
        operations.add(".");
        updateOutput();
        isOperator = true;
    }
    
    @FXML
    public void func_removeOne(ActionEvent event){
        if(!operations.isEmpty()) operations.remove(operations.size()-1);
        updateOutput();
        if(operations.get(operations.size()-1).startsWith("?")) isOperator = true;
    }
    
    @FXML 
    public void func_plus(ActionEvent event){
        if(!isOperator) operations.add("?+?");
        else operations.set(operations.size()-1, "?+?");
        updateOutput();
        isOperator = true;
    }
    
    @FXML
    public void func_equal(ActionEvent event){
        String operationsString = "";
        for(String e : operations){
            operationsString = operationsString + e;
        }
        
        String[] elements = operationsString.split("\\?");
        List<String> elementsList = new ArrayList();
        for(String e : elements){
            elementsList.add(e);
        }
        double num1 = 0.0;
        double num2;
        
        boolean added = true;
        while(added){
            added = false;
        for(int i = 0; i < elementsList.size(); i++){
            if(i%2 != 0 && elementsList.get(i).equals("*") || elementsList.get(i).equals("/")){
                num1 = Double.parseDouble(elementsList.get(i-1));
                num2 = Double.parseDouble(elementsList.get(i+1));
                num1 = doOperations(elementsList.get(i), num1, num2);
                elementsList.set(i+1, num1 + "");
                elementsList.remove(i);
                elementsList.remove(i-1);
                added = true;
            }
        }
        }
        
        added = true;
        while(added){
            added = false;
        for(int i = 0; i < elementsList.size(); i++){
            if(i%2 != 0){
                num1 = Double.parseDouble(elementsList.get(i-1));
                num2 = Double.parseDouble(elementsList.get(i+1));
                num1 = doOperations(elementsList.get(i), num1, num2);
                elementsList.set(i+1, num1 + "");
                elementsList.remove(i);
                elementsList.remove(i-1);
                added = true;
            }
        }
        }
        
        operations.add("?=" + num1);
        updateOutput();
        
    }
    
    @FXML
    public void func_minus(ActionEvent event){
        if(!isOperator) operations.add("?-?");
        else operations.set(operations.size()-1, "?-?");
        updateOutput();
        isOperator = true;
    }
    
    @FXML
    public void func_multi(ActionEvent event){
        if(!isOperator) operations.add("?*?");
        else operations.set(operations.size()-1, "?*?");
        updateOutput();
        isOperator = true;
    }
    
    @FXML
    public void func_invert(ActionEvent event){
      
    }
    
    @FXML
    public void func_div(ActionEvent event){
      if(!isOperator) operations.add("?/?");
      else operations.set(operations.size()-1, "?/?");
      updateOutput();
      isOperator = true;
    }
    
    @FXML
    public void func_root(ActionEvent event){
        if(!isOperator){
            operations.add(Math.sqrt(Double.parseDouble(operations.get(operations.size()-1))) + "");
            operations.remove(operations.size()-2);
            updateOutput();
        }
        
    }
    
    @FXML
    public void func_changeChar(ActionEvent event){
        
    }
    
    @FXML
    public  void func_removeAll(ActionEvent event){
        operations = new ArrayList<>();
        output.clear();
        
    }
    
    @FXML
    public  void func_removeLine(ActionEvent event){
        operations = new ArrayList<>();
        output.clear();
        
    }
    
    private void updateOutput(){
        String toPrint = "";
        for(String e : operations){
            if(e.startsWith("?")){
                e = e.replace("?", "");
            }
            toPrint = toPrint + e;
        }
        output.setText(toPrint);
    }
    
    private double doOperations(String operator, double num1, double num2){
        switch (operator){
            case "+": return num1 + num2;
            case "*": return num1 * num2;
            case "/": return num1 / num2;
            case "-": return num1 - num2;
            default: return 0.0;
        }
    }
}
