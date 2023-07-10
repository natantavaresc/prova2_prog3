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
import br.edu.femass.diversos.DiversosJavaFx;
import br.edu.femass.entities.Aluno;
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

public class AlunoController implements Initializable {
    
    @FXML
    private Label label;

    @FXML
    private TextField TxtNome;

    @FXML
    private TextField TxtTelefone;

    @FXML
    private TextField TxtEmail;

    @FXML
    private TextField TxtMatricula;

    @FXML
    private ListView<Aluno> listaAluno;

    private DaoAluno alunoDao = new DaoAluno();

    @FXML
    private void listaAluno_keyPressed(KeyEvent event){
        exibirDados();
    } 

    @FXML
    private void listaAluno_mouseClicked (MouseEvent event){
        exibirDados();    
    } 

    private void exibirDados(){
        Aluno aluno = listaAluno.getSelectionModel().getSelectedItem();
        if (aluno==null) return;

        TxtTelefone.setText(aluno.getTelefone());
        TxtNome.setText(aluno.getNome());
        TxtEmail.setText(aluno.getEmail());
        TxtMatricula.setText(aluno.getMatricula());

    }    

    @FXML
    private void BtnExcluir_Click(ActionEvent event) {
       Aluno aluno= listaAluno.getSelectionModel().getSelectedItem();
        if (aluno ==null) return;
       
        try{

        Dao<Aluno> daoAluno = new Dao<>(Aluno.class);
        daoAluno.delete(aluno.getId());
        
        limparTela();
        exibirAlunos();
        }catch(Exception ex){
            ex.printStackTrace();
        }   
    }


    @FXML
    private void BtnGravar_Click(ActionEvent event) {

        try{
            Aluno aluno = new Aluno (
            TxtNome.getText(),
            TxtEmail.getText(),
            TxtTelefone.getText(),
            TxtMatricula.getText()
            ); 
        Dao<Aluno> daoAluno = new Dao<>(Aluno.class);
        daoAluno.create(aluno);}
    catch(Exception ex){
            ex.printStackTrace();}
        limparTela();
        }

        public void limparTela(){
                     TxtNome.setText("");
                     TxtMatricula.setText("");
                     TxtEmail.setText("");
                     TxtTelefone.setText("");
                     exibirAlunos();

    }
    public void exibirAlunos(){
        try{
       ObservableList<Aluno> data = FXCollections.observableArrayList(
       alunoDao.findAll()
       );
       listaAluno.setItems(data);
        }
        catch(Exception ex){
            ex.printStackTrace();
       }
    }
           
    


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        exibirAlunos();
    }    
}