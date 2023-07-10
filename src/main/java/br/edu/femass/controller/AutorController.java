package br.edu.femass.controller;

import java.net.URL;
import java.util.ResourceBundle;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import br.edu.femass.dao.Dao;
import br.edu.femass.dao.DaoAutor;
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
import br.edu.femass.entities.Autor;
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

public class AutorController implements Initializable {
    
    @FXML
    private Label label;

    @FXML
    private TextField TxtNome;

    @FXML
    private TextField TxtSobrenome;

    @FXML
    private ListView<Autor> listaAutor;

    private DaoAutor autorDao = new DaoAutor();

    @FXML
    private void listaAutor_keyPressed(KeyEvent event){
        exibirDados();
    } 

    @FXML
    private void listaAutor_mouseClicked (MouseEvent event){
        exibirDados();    
    } 

    private void exibirDados(){
        Autor autor = listaAutor.getSelectionModel().getSelectedItem();
        if (autor==null) return;

        TxtNome.setText(autor.getNome());
        TxtSobrenome.setText(autor.getSobreNome());

    }    

    @FXML
    private void BtnExcluir_Click(ActionEvent event) {
       Autor autor= listaAutor.getSelectionModel().getSelectedItem();
        if (autor ==null) return;
       
        try{

        Dao<Autor> daoAutor = new Dao<>(Autor.class);
        daoAutor.delete(autor.getId());
        
        limparTela();
        exibirAutores();
        }catch(Exception ex){
            ex.printStackTrace();
        }   
    }


    @FXML
    private void BtnGravar_Click(ActionEvent event) {

        try{
            Autor autor = new Autor (
            TxtNome.getText(),
            TxtSobrenome.getText()
            ); 
        Dao<Autor> daoAutor = new Dao<>(Autor.class);
        daoAutor.create(autor);}
    catch(Exception ex){
            ex.printStackTrace();}
        limparTela();
        }

        public void limparTela(){
                     TxtNome.setText("");
                     TxtSobrenome.setText("");
                     exibirAutores();

    }
    public void exibirAutores(){
        try{
       ObservableList<Autor> data = FXCollections.observableArrayList(
       autorDao.findAll()
       );
       listaAutor.setItems(data);
        }
        catch(Exception ex){
            ex.printStackTrace();
       }
    }
           
    


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        exibirAutores();
    }    
}