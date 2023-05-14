package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import org.h2.tools.Server;

public class Application {

    public static void main(String[] args) throws SQLException {
        startDatabase();
        try (CemeteryDAO cDAO = new JPACemeteryDAO()) {
            handleData(cDAO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void handleData(CemeteryDAO cDAO){
        Random rand = new Random();


        Urnak urna = new Urnak("test_urna",1232);
        Kovek ko = new Kovek("test_ko",123124);
        List<Kovek> kovek = new ArrayList<>();
        kovek.add(ko);
        List<Urnak> urnak = new ArrayList<>();
        urnak.add(urna);
        SirKoves test_sk = new SirKoves("test_sk","asfaddf","temeto utca 420",kovek,urnak);
        TemetkezesiVallalkozo tv = new TemetkezesiVallalkozo("test tv 1","telefon,fax","teszt utca 9.", TemetkezesiVallalkozo.TemetesiTipus.Urna);
        Customer customer = new Customer("Karacs David", LocalDate.of(2000, 3, 13),"kisvarda",LocalDate.of(2030,3,13),tv,test_sk);

        try {
            File tvList = new File("C:\\Users\\grado\\IdeaProjects\\KreditTemeto\\src\\main\\java\\org\\example\\temetkezesi_vallalatok.txt");
            Scanner sc = new Scanner(tvList);
            while(sc.hasNextLine()){
                String data = sc.nextLine();
                List<TemetkezesiVallalkozo.TemetesiTipus> tipusok = new ArrayList<>();
                tipusok.add(TemetkezesiVallalkozo.TemetesiTipus.Urna);
                tipusok.add(TemetkezesiVallalkozo.TemetesiTipus.Koporso);
                TemetkezesiVallalkozo tv2 = new TemetkezesiVallalkozo(data.split(",")[0],data.split(",")[2],data.split(",")[1], tipusok.get(rand.nextInt(2)));
                cDAO.saveTemetkezesiVallalkozo(tv2);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        List<TemetkezesiVallalkozo> koveks = cDAO.getTV();

        cDAO.saveKovek(ko);
        cDAO.saveUrnak(urna);
        cDAO.saveSirkove(test_sk);
        cDAO.saveTemetkezesiVallalkozo(tv);
        cDAO.saveCustomer(customer);

        try{
            File customerList = new File("C:\\Users\\grado\\IdeaProjects\\KreditTemeto\\src\\main\\java\\org\\example\\customer_list.txt");
            Scanner sc = new Scanner(customerList);
            while(sc.hasNextLine()){
                String data = sc.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
                Customer c = new Customer(data.split(",")[0],LocalDate.parse(data.split(",")[2],formatter),data.split(",")[1],LocalDate.parse(data.split(",")[3],formatter),koveks.get(rand.nextInt(koveks.size())),test_sk);
                cDAO.saveCustomer(c);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        List<Customer> customers = cDAO.getCustomer();
        for(int i = 0; i < 100; i++){
            System.out.println(customers.get(i).toString());
        }
    }
    private static void startDatabase() throws SQLException {
        new Server().runTool("-tcp", "-web", "-ifNotExists");
    }
}
