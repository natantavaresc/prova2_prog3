package br.edu.femass.controller;

import java.net.URL;
import java.util.ResourceBundle;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import br.edu.femass.dao.Dao;
import br.edu.femass.dao.DaoGenero;
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
import br.edu.femass.diversos.DiversosJavaFx;
import br.edu.femass.entities.Genero;
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

public class GeneroController implements Initializable {
    
    @FXML
    private Label label;

    @FXML
    private TextField TxtNome;

    @FXML
    private ListView<Genero> listaGenero;

    private DaoGenero generoDao = new DaoGenero();

    @FXML
    private void listaGenero_keyPressed(KeyEvent event){
        exibirDados();
    } 

    @FXML
    private void listaGenero_mouseClicked (MouseEvent event){
        exibirDados();    
    } 

    private void exibirDados(){
        Genero genero = listaGenero.getSelectionModel().getSelectedItem();
        if (genero==null) return;

        TxtNome.setText(genero.getNome());

    }    

    @FXML
    private void BtnExcluir_Click(ActionEvent event) {
       Genero genero= listaGenero.getSelectionModel().getSelectedItem();
        if (genero ==null) return;
       
        try{

        Dao<Genero> daoGenero = new Dao<>(Genero.class);
        daoGenero.delete(genero.getId());
        
        limparTela();
        exibirGeneros();
        }catch(Exception ex){
            ex.printStackTrace();
        }   
    }


    @FXML
    private void BtnGravar_Click(ActionEvent event) {

        try{
            Genero genero = new Genero (
            TxtNome.getText()
            ); 
        Dao<Genero> daoGenero = new Dao<>(Genero.class);
        daoGenero.create(genero);}
    catch(Exception ex){
            ex.printStackTrace();}
        limparTela();
        }

        public void limparTela(){
                     TxtNome.setText("");
                     exibirGeneros();

    }
    public void exibirGeneros(){
        try{
       ObservableList<Genero> data = FXCollections.observableArrayList(
       generoDao.findAll()
       );
       listaGenero.setItems(data);
        }
        catch(Exception ex){
            ex.printStackTrace();
       }
    }
           
    


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        exibirGeneros();
    }    
}