package br.edu.femass.controller;

import java.net.URL;
import java.util.ResourceBundle;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import br.edu.femass.dao.Dao;
import br.edu.femass.diversos.DiversosJavaFx;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import br.edu.femass.dao.Dao;
import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoProfessor;
import br.edu.femass.diversos.DiversosJavaFx;
import br.edu.femass.entities.Professor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ProfessorController implements Initializable {
    
    @FXML
    private Label label;

    @FXML
    private TextField TxtNome;

    @FXML
    private TextField TxtTelefone;

    @FXML
    private TextField TxtEmail;

    @FXML
    private TextField TxtFormacao;

    @FXML
    private ListView<Professor> listaProfessor;

    private DaoProfessor professorDao = new DaoProfessor();

    @FXML
    private void listaProfessor_keyPressed(KeyEvent event){
        exibirDados();
    } 

    @FXML
    private void listaProfessor_mouseClicked (MouseEvent event){
        exibirDados();    
    } 

    private void exibirDados(){
        Professor professor = listaProfessor.getSelectionModel().getSelectedItem();
        if (professor==null) return;

        TxtTelefone.setText(professor.getTelefone());
        TxtNome.setText(professor.getNome());
        TxtEmail.setText(professor.getEmail());
        TxtFormacao.setText(professor.getFormacao());
    }    

    @FXML
    private void BtnExcluir_Click(ActionEvent event) {
       Professor professor= listaProfessor.getSelectionModel().getSelectedItem();
        if (professor ==null) return;
       
        try{

        Dao<Professor> daoProfessor = new Dao<>(Professor.class);
        daoProfessor.delete(professor.getId());
        
        limparTela();
        exibirProfessores();
        }catch(Exception ex){
            ex.printStackTrace();
        }   
    }


    @FXML
    private void BtnGravar_Click(ActionEvent event) {

        try{
            Professor professor = new Professor (
            TxtNome.getText(),
            TxtEmail.getText(),
            TxtTelefone.getText(),
            TxtFormacao.getText()
            ); 
        Dao<Professor> daoProfessor = new Dao<>(Professor.class);
        daoProfessor.create(professor);}
    catch(Exception ex){
            ex.printStackTrace();}
        limparTela();
        }

        public void limparTela(){
                     TxtNome.setText("");
                     TxtFormacao.setText("");
                     TxtEmail.setText("");
                     TxtTelefone.setText("");
                     exibirProfessores();

    }
    public void exibirProfessores(){
        try{
       ObservableList<Professor> data = FXCollections.observableArrayList(
       professorDao.findAll()
       );
       listaProfessor.setItems(data);
        }
        catch(Exception ex){
            ex.printStackTrace();
       }
    }
           
    


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        exibirProfessores();
    }    
}