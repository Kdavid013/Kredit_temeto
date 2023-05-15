/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import hu.unideb.inf.model.Cemetery.CemeteryDAO;
import hu.unideb.inf.model.Cemetery.JPACemeteryDAO;
import hu.unideb.inf.model.Customer.Customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import hu.unideb.inf.model.Cemetery.TemetkezesiVallalkozo;
import hu.unideb.inf.model.Customer.CustomerDAO;
import hu.unideb.inf.model.Customer.JPACustomerDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;

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
    private TableView keresCustomerTable;

    @FXML
    private ChoiceBox<String> temetValchoicebox;



    @FXML
    void handleAddButtonPushed(ActionEvent event){
        try (CemeteryDAO cDAO = new JPACemeteryDAO()) {
            handleData(cDAO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void handleSearchButtonPushed(ActionEvent event){
        try (CustomerDAO cDAO = new JPACustomerDAO()) {
            writeData(cDAO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @FXML
    void customerSelected(){
        try (CemeteryDAO cDAO = new JPACemeteryDAO()) {
            getData(cDAO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void getData(CemeteryDAO cDAO){
        List<TemetkezesiVallalkozo> tvs = cDAO.getTV();
        ObservableList<String> tvsnev = FXCollections.observableArrayList();
        for (TemetkezesiVallalkozo e : tvs){
            tvsnev.add(e.getNev());
        }
        temetValchoicebox.setItems(tvsnev);
    }



//    void getTemetkezesiVallalkozoData(){
//        CemeteryDAO tvDAO = new JPACemeteryDAO();
//        for (TemetkezesiVallalkozo p : tvDAO.getTV()) {
//            temetkezesivallalkozocustomer.getItems().add(p.getNev());
//        }
//    }
    private void writeData(CustomerDAO cDAO) {
        TableColumn<Customer, Integer> ID = new TableColumn<>("ID");
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Customer, String> NEV = new TableColumn<>("NEV");
        NEV.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNev()));

        TableColumn<Customer, String> SZULETESI_HELY = new TableColumn<>("Szuletesi hely");
        SZULETESI_HELY.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getSzuletesiHely()));
        keresCustomerTable.getColumns().addAll(ID, NEV, SZULETESI_HELY);

        keresCustomerTable.setItems(cDAO.getCustomer());

    }



    private void handleData(CemeteryDAO cDAO) {
        if(multiple.isSelected()){
            try{
                File f = new File(multipleFile.getText());
                Scanner sc = new Scanner(f);
                while(sc.hasNextLine()){
                    String data = sc.nextLine();
                    TemetkezesiVallalkozo temetVal = new TemetkezesiVallalkozo();
                    temetVal.setNev(data.split(",")[0]);
                    temetVal.setCim(data.split(",")[1]);
                    temetVal.setTemetesitipus(data.split(",")[3]);
                    temetVal.setElerhetoseg(data.split(",")[2]);

                    cDAO.saveTemetkezesiVallalkozo(temetVal);
                }
            }
            catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        else {
            System.out.println(temetValNev.getText());
            System.out.println(temetValTipBox.getSelectionModel().getSelectedItem().toString());
            System.out.println(temetValCim.getText());
            System.out.println(temetValEler.getText());
            TemetkezesiVallalkozo tvnew = new TemetkezesiVallalkozo();
            tvnew.setCim(temetValCim.getText());
            tvnew.setElerhetoseg(temetValEler.getText());
            tvnew.setNev(temetValNev.getText());
            tvnew.setTemetesitipus(temetValTipBox.getSelectionModel().getSelectedItem().toString());

            cDAO.saveTemetkezesiVallalkozo(tvnew);
        }
    }

    /*
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        temetValTipBox.setItems(temetesitipus);
        //getTemetkezesiVallalkozoData();

    }

}