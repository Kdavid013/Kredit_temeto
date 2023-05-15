/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import hu.unideb.inf.CemeteryDAO;
import hu.unideb.inf.JPACemeteryDAO;
import hu.unideb.inf.model.Kovek;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import hu.unideb.inf.model.TemetkezesiVallalkozo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * FXML Controller class
 *
 * @author kocsisg
 */
public class CreditCemeteryController implements Initializable {

    ObservableList<String> temetesitipus = FXCollections.observableArrayList("Koporso","Urna");
    @FXML
    private Button addTV,addSK,addCustomer,addKo,addUrna;
    @FXML
    private RadioButton multiple;
    @FXML
    private TextField multipleFile;
    @FXML
    private TextField temetValNev;
    @FXML private TextField temetValEler;
    @FXML private TextField temetValCim;
    @FXML
    private ChoiceBox<String> temetValTipBox;
    @FXML
    void handleButtonPushed(ActionEvent event) {

    }

    @FXML
    void handleAddButtonPushed(ActionEvent event){

        try (CemeteryDAO cDAO = new JPACemeteryDAO()) {
            handleData(cDAO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void handleData(CemeteryDAO cDAO) {
        if(multiple.isSelected()){
            try{
                File f = new File(multipleFile.getText());
                Scanner sc = new Scanner(f);
                while(sc.hasNextLine()){
                    String data = sc.nextLine();
                    TemetkezesiVallalkozo temetVal = new TemetkezesiVallalkozo(data.split(",")[0],data.split(",")[1],data.split(",")[2],data.split(",")[3]);
                    cDAO.saveTemetkezesiVallalkozo(temetVal);
                }
            }
            catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        else {
            TemetkezesiVallalkozo temetVal2 = new TemetkezesiVallalkozo(temetValNev.getText(),temetValEler.getText(),temetValCim.getText(),temetValTipBox.getSelectionModel().getSelectedItem());
            cDAO.saveTemetkezesiVallalkozo(temetVal2);
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        temetValTipBox.setItems(temetesitipus);
    }

}
