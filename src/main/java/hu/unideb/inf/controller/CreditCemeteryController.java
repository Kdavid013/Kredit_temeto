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
import java.util.ResourceBundle;
import java.util.Scanner;

import hu.unideb.inf.model.Cemetery.TemetkezesiVallalkozo;
import hu.unideb.inf.model.Customer.CustomerDAO;
import hu.unideb.inf.model.Customer.JPACustomerDAO;
import hu.unideb.inf.model.Sirkovek.JPASirkovekDAO;
import hu.unideb.inf.model.Sirkovek.Kovek;
import hu.unideb.inf.model.Sirkovek.SirkovekDAO;
import hu.unideb.inf.model.Sirkovek.Urnak;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
    @FXML private TextField urnakNev;
    @FXML private TextField urnakAr;
    @FXML private TextField kovekNev;
    @FXML private TextField kovekAr;

    @FXML
    private TableView keresCustomerTable;

    @FXML
    void handleRockButtonPushted(ActionEvent actionEvent) {
        try (SirkovekDAO kDAO = new JPASirkovekDAO()) {
            handleData3(kDAO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    void handleButtonPushed(ActionEvent event) {
        try (SirkovekDAO sDAO = new JPASirkovekDAO()) {
            handleData2(sDAO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
            System.out.println(temetValNev.getText());
            System.out.println(temetValTipBox.getSelectionModel().getSelectedItem().toString());
            System.out.println(temetValCim.getText());
            System.out.println(temetValEler.getText());
            cDAO.saveTemetkezesiVallalkozo(new TemetkezesiVallalkozo(temetValNev.getText(),temetValEler.getText(),temetValCim.getText(),temetValTipBox.getSelectionModel().getSelectedItem().toString()));
        }
    }

    private void handleData2(SirkovekDAO sDAO) {
        if(multiple.isSelected()){
            try{
                File f = new File(multipleFile.getText());
                Scanner sc = new Scanner(f);
                while(sc.hasNextLine()){
                    String data = sc.nextLine();
                    Urnak urVal = new Urnak(data.split(",")[0], Integer.parseInt(data.split(",")[1]) );
                    sDAO.saveUrnak(urVal);
                }
            }
            catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Az adatok felvéve");
            sDAO.saveUrnak(new Urnak(urnakNev.getText(),Integer.parseInt(urnakAr.getText())));
        }
    }
    private void handleData3(SirkovekDAO sDAO) {
        if(multiple.isSelected()){
            try{
                File f = new File(multipleFile.getText());
                Scanner sc = new Scanner(f);
                while(sc.hasNextLine()){
                    String data = sc.nextLine();
                    Kovek koVal = new Kovek(data.split(",")[0], Integer.parseInt(data.split(",")[1]) );
                    sDAO.saveKovek(koVal);
                }
            }
            catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Az adatok felvéve");
            sDAO.saveKovek(new Kovek(kovekNev.getText(),Integer.parseInt(kovekAr.getText())));
        }
    }

    /*
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        temetValTipBox.setItems(temetesitipus);
    }

}
