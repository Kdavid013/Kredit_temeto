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
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import hu.unideb.inf.model.Cemetery.TemetkezesiVallalkozo;
import hu.unideb.inf.model.Customer.CustomerDAO;
import hu.unideb.inf.model.Customer.JPACustomerDAO;
import hu.unideb.inf.model.Sirkovek.*;
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

    @FXML private RadioButton multiple;
    @FXML private TextField multipleFile;
    @FXML
    private TextField temetValNev;
    @FXML private TextField temetValEler;
    @FXML private TextField temetValCim;
    @FXML private ChoiceBox<String> temetValTipBox;

    @FXML private TextField urnakNev;
    @FXML private TextField urnakAr;
    @FXML private TextField kovekNev;
    @FXML private TextField kovekAr;

    @FXML
    private TableView keresCustomerTable;
    @FXML private TableView keresTVTable;
    @FXML private TableView keresSKTable;
    @FXML private TableView keresKTable;
    @FXML private TableView keresUTable;



    @FXML
    private ChoiceBox<String> temetValchoicebox;
    @FXML private ChoiceBox skKovekChoiceBox,skUrnakChoiceBox;
    @FXML private ChoiceBox torlesCustomers,torlesTV,torlesSK,torlesK,torlesU;
    @FXML private TextField skNev,skCim,skEler;

    @FXML private TextField cusHalali;
    @FXML private ChoiceBox cusTemetk, cusSirk;



    @FXML
    void handleRockButtonPushed(ActionEvent actionEvent) {
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
    void handleSearchButtonPushedCustomer(ActionEvent event){
        try (CustomerDAO cDAO = new JPACustomerDAO()) {
            writeData(cDAO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        @FXML
    void writeDataTV() {
        keresTVTable.getSelectionModel().clearSelection();
        keresTVTable.getItems().clear();
        keresTVTable.getColumns().clear();

        CemeteryDAO cDAO = new JPACemeteryDAO();
        TableColumn<TemetkezesiVallalkozo, String> NEV = new TableColumn<>("Nev");
        NEV.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNev()));

        TableColumn<TemetkezesiVallalkozo, String> ELERHETOSEG = new TableColumn<>("Elerhetoseg");
        ELERHETOSEG.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getElerhetoseg()));

        TableColumn<TemetkezesiVallalkozo, String> CIM = new TableColumn<>("Cim");
        CIM.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCim()));

        TableColumn<TemetkezesiVallalkozo, String> TEMETESITIPUS = new TableColumn<>("Temetesi tipus");
        TEMETESITIPUS.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTemetesitipus()));

        keresTVTable.getColumns().addAll(NEV,ELERHETOSEG,CIM,TEMETESITIPUS);
        keresTVTable.setItems(cDAO.getTV());
    }

    @FXML
    void writeDataSK(){
        keresSKTable.getSelectionModel().clearSelection();
        keresSKTable.getItems().clear();
        keresSKTable.getColumns().clear();

        SirkovekDAO skDAO = new JPASirkovekDAO();
        TableColumn<SirKoves, String> NEV = new TableColumn<>("Nev");
        NEV.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNev()));

        TableColumn<SirKoves, String> ELERHETOSEG = new TableColumn<>("Elerhetoseg");
        ELERHETOSEG.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getElerhetoseg()));

        TableColumn<SirKoves, String> CIM = new TableColumn<>("Cim");
        CIM.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCim()));

        TableColumn<SirKoves, String> Kovek = new TableColumn<>("Kovek");
        Kovek.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getKovek()));

        TableColumn<SirKoves, String> Urnak = new TableColumn<>("Urnak");
        Kovek.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getUrnak()));

        keresSKTable.getColumns().addAll(NEV,ELERHETOSEG,CIM,Kovek,Urnak);
        keresSKTable.setItems(skDAO.getSK());
    }

    @FXML void writeDataK(){
        keresKTable.getSelectionModel().clearSelection();
        keresKTable.getItems().clear();
        keresKTable.getColumns().clear();

        SirkovekDAO skDAO = new JPASirkovekDAO();
        TableColumn<Kovek, String> NEV = new TableColumn<>("Nev");
        NEV.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNev()));

        TableColumn<Kovek, String> AR = new TableColumn<>("Ar");
        AR.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getAr())));

        keresKTable.getColumns().addAll(NEV,AR);
        keresKTable.setItems(skDAO.getK());
    }
    @FXML void writeDataU(){
        keresUTable.getSelectionModel().clearSelection();
        keresUTable.getItems().clear();
        keresUTable.getColumns().clear();

        SirkovekDAO skDAO = new JPASirkovekDAO();
        TableColumn<Urnak, String> NEV = new TableColumn<>("Nev");
        NEV.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNev()));

        TableColumn<Urnak, String> AR = new TableColumn<>("Ar");
        AR.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getAr())));

        keresUTable.getColumns().addAll(NEV,AR);
        keresUTable.setItems(skDAO.getU());
    }

    @FXML void selectTorles(){
        System.out.println("törlés választva");
        ObservableList<String> cusNev = FXCollections.observableArrayList();
        ObservableList<String> tvNev = FXCollections.observableArrayList();
        ObservableList<String> skNev = FXCollections.observableArrayList();
        ObservableList<String> kNev = FXCollections.observableArrayList();
        ObservableList<String> uNev = FXCollections.observableArrayList();

        CustomerDAO cusDAO = new JPACustomerDAO();
        List<Customer> customers = cusDAO.getCustomer();
        for(Customer e: customers){
            cusNev.add(e.getNev());
        }
        torlesCustomers.setItems(cusNev);

        CemeteryDAO cDAO = new JPACemeteryDAO();
        List<TemetkezesiVallalkozo> tvs = cDAO.getTV();
        for (TemetkezesiVallalkozo e : tvs){
            tvNev.add(e.getNev());
        }
        torlesTV.setItems(tvNev);

        SirkovekDAO sDAO = new JPASirkovekDAO();
        List<SirKoves> sirkovesek = sDAO.getSK();
        for(SirKoves e : sirkovesek){
            skNev.add(e.getNev());
        }
        torlesSK.setItems(skNev);

        List<Kovek> koveks = sDAO.getK();
        for (Kovek e : koveks){
            kNev.add(e.getNev());
        }
        torlesK.setItems(kNev);

        List<Urnak> urnaks = sDAO.getU();
        for (Urnak e : urnaks){
            uNev.add(e.getNev());
        }
        torlesU.setItems(uNev);
    }

    @FXML void deleteCustomer(){
        CustomerDAO cDAO = new JPACustomerDAO();
        ObservableList<Customer> customers = cDAO.getCustomer();
        for(Customer e : customers){
            if(e.getNev().equals(torlesCustomers.getSelectionModel().getSelectedItem())){
                cDAO.deleteCustomer(e);
            }
        }
    }

    @FXML void deleteTV(){
        CemeteryDAO cDAO = new JPACemeteryDAO();
        ObservableList<TemetkezesiVallalkozo> tvs = cDAO.getTV();
        for(TemetkezesiVallalkozo e : tvs){
            if(e.getNev().equals(torlesTV.getSelectionModel().getSelectedItem())){
                cDAO.deleteTemetkezesiVallalkozo(e);
            }
        }
    }
    @FXML void deleteSK(){
        SirkovekDAO sDAO = new JPASirkovekDAO();
        ObservableList<SirKoves> sks = sDAO.getSK();
        for(SirKoves e : sks){
            if(e.getNev().equals(torlesSK.getSelectionModel().getSelectedItem())){
                sDAO.deleteSirkoves(e);
            }
        }
    }
    @FXML void deleteK(){
        SirkovekDAO sDAO = new JPASirkovekDAO();
        ObservableList<Kovek> koveks = sDAO.getK();
        for(Kovek e : koveks){
            if(e.getNev().equals(torlesK.getSelectionModel().getSelectedItem())){
                sDAO.deleteKovek(e);
            }
        }
    }
    @FXML void deleteU(){
        SirkovekDAO sDao = new JPASirkovekDAO();
        ObservableList<Urnak> urnaks = sDao.getU();
        for (Urnak e : urnaks){
            if(e.getNev().equals(torlesU.getSelectionModel().getSelectedItem())){
                sDao.deleteUrnak(e);
            }
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

    private void writeData(CustomerDAO cDAO) {
        keresCustomerTable.getSelectionModel().clearSelection();
        keresCustomerTable.getItems().clear();
        keresCustomerTable.getColumns().clear();

        TableColumn<Customer, Integer> ID = new TableColumn<>("ID");
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Customer, String> NEV = new TableColumn<>("Nev");
        NEV.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNev()));

        TableColumn<Customer, String> SZULETESI_HELY = new TableColumn<>("Szuletesi hely");
        SZULETESI_HELY.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getSzuletesiHely()));

        TableColumn<Customer, String> SZULETESI_IDO = new TableColumn<>("Szuletesi ido");
        SZULETESI_IDO.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getSzuletesiIdo().toString()));

        TableColumn<Customer, String> HALAL_IDOPONTJA = new TableColumn<>("Halal idopontja");
        HALAL_IDOPONTJA.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getHalalIdopontja().toString()));

        TableColumn<Customer, String> TEMETKEZESI_VALALKOZO = new TableColumn<>("Temetkezesi vallalkozo");
        TEMETKEZESI_VALALKOZO.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTemetkezesiVallalkozo().getNev()));

        TableColumn<Customer, String> SIRKOVES = new TableColumn<>("Sirkoves");
        SIRKOVES.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getSirkoves().getNev()));

        keresCustomerTable.getColumns().addAll(ID, NEV, SZULETESI_HELY,SZULETESI_IDO,HALAL_IDOPONTJA,TEMETKEZESI_VALALKOZO,SIRKOVES);
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

    private void handleData2(SirkovekDAO sDAO) {
            Urnak urVal = new Urnak();
            urVal.setNev(urnakNev.getText());
            urVal.setAr(Integer.parseInt(urnakAr.getText()));
            sDAO.saveUrnak(urVal);
            System.out.println("Az adatok felvéve");
    }
    private void handleData3(SirkovekDAO sDAO) {

            Kovek koVal = new Kovek();
            koVal.setNev(kovekNev.getText());
            koVal.setAr(Integer.parseInt(kovekAr.getText()));
            sDAO.saveKovek(koVal);
            System.out.println("Az adatok felvéve");
    }

    @FXML void selectSK(){
        SirkovekDAO skDAO = new JPASirkovekDAO();
        List<Kovek> koveks = skDAO.getK();
        ObservableList<String> kovekNev = FXCollections.observableArrayList();
        for (Kovek e : koveks){
            kovekNev.add(e.getNev());
        }
        skKovekChoiceBox.setItems(kovekNev);

        List<Urnak> urnaks = skDAO.getU();
        ObservableList<String> urnakNev = FXCollections.observableArrayList();
        for(Urnak e : urnaks){
            urnakNev.add(e.getNev());
        }
        skUrnakChoiceBox.setItems(urnakNev);
    }
    @FXML void addSK(){
        SirkovekDAO skDAO = new JPASirkovekDAO();
        SirKoves sk = new SirKoves();
        sk.setNev(skNev.getText());
        sk.setCim(skCim.getText());
        sk.setElerhetoseg(skEler.getText());
        sk.setKovek(skKovekChoiceBox.getSelectionModel().getSelectedItem().toString());
        sk.setUrnak(skUrnakChoiceBox.getSelectionModel().getSelectedItem().toString());

        skDAO.saveSirkove(sk);
    }
    @FXML void addCustomer(){
        CustomerDAO cDAO = new JPACustomerDAO();
        SirkovekDAO skDAO = new JPASirkovekDAO();
        CemeteryDAO cemDAO = new JPACemeteryDAO();

        List<TemetkezesiVallalkozo> temetValList = cemDAO.getTV();
        ObservableList<String> temetvalNev = FXCollections.observableArrayList();
        for(TemetkezesiVallalkozo tv : temetValList){
            temetvalNev.add(tv.getNev());
        }

        List<SirKoves> sirKovesList = skDAO.getSK();
        ObservableList<String> sirkovesNev = FXCollections.observableArrayList();
        for(SirKoves sk : sirKovesList){
            sirkovesNev.add(sk.getNev());
        }


        Customer cus = new Customer();
        cus.setHalalIdopontja(LocalDate.parse(cusHalali.getText()));
        cus.setTemetkezesiVallalkozo(cusTemetk.getSelectionModel().getSelectedItem().toString());
        cus.setSirkoves(cusSirk.getSelectionModel().getSelectedItem().toString());
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
