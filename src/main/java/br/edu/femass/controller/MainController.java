package br.edu.femass.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainController implements Initializable {

    @FXML
    private Label label;
    
    @FXML
    private void handleBtnAlunoAction(ActionEvent event) {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Aluno.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Cadastro de Alunos");
        stage.setScene(scene);
        stage.show();
        }catch(Exception ex){
            ex.printStackTrace();
        }    
    }
    

    @FXML
    private void handleBtnProfessorAction(ActionEvent event) {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Professor.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Criar Professor");
        stage.setScene(scene);
        stage.show();
        }catch(Exception ex){
            ex.printStackTrace();
        }    
    }

    @FXML
    private void handleButtonGeneroAction(ActionEvent event) {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Genero.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Criar Genero");
        stage.setScene(scene);
        stage.show();
        }catch(Exception ex){
            ex.printStackTrace();
        }    
    }

    @FXML
    private void handleButtonAutorAction(ActionEvent event) {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Autor.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Criar Autor");
        stage.setScene(scene);
        stage.show();
        }catch(Exception ex){
            ex.printStackTrace();
        }    
    }

    @FXML
    private void handleButtonLivroAction(ActionEvent event) {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Livro.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Criar Livro");
        stage.setScene(scene);
        stage.show();
        }catch(Exception ex){
            ex.printStackTrace();
        }    
    }

    @FXML
    private void handleButtonEmprestimoAction(ActionEvent event) {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Emprestimo.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Criar Emprestimo");
        stage.setScene(scene);
        stage.show();
        }catch(Exception ex){
            ex.printStackTrace();
        }    
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
}