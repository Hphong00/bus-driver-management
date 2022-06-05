package service;
import entity.Driver;
import main.Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DriverService {
    public static String DRIVER_FILE = "driver.txt";

    private static ArrayList<Driver> driverArrayList;

    public DriverService() {
        driverArrayList = new ArrayList<Driver>();
    }

    public static void addListDriverToArraylist() throws IOException {
        System.out.println("Nhập số người lái: ");
        do {
            int numberDriver = -1;
            Driver driver = null;
            try {
                numberDriver = new Scanner(System.in).nextInt();
            } catch (Exception ex) {
                System.out.println("Mời nhập lại ");
            }
            for (int i = 0; i < numberDriver; i++) {
                driver = new Driver();
                driver.inputInformation();
                driverArrayList.add(driver);
            }
            Main.initializeData.writeArrayListToFile(DRIVER_FILE,driverArrayList);
            if (driver != null) {
                break;
            }
        } while (true);
        System.out.println("---------");
        showAllDriverFromArrList();
        System.out.println("---------");
    }

    public boolean removeDriverAtLocation(){
        int location = 0;
        try {
            location = new Scanner(System.in).nextInt();
        }catch (Exception ex){
            System.out.println("Mời nhập lại");
        }
        if((location<0) || (location>driverArrayList.size())){
            return false;
        }
        else {
            driverArrayList.remove(location - 1);
            return true;
        }
    }

    public static void showAllDriverFromArrList() {
        for (Driver driver : driverArrayList) {
            System.out.println(driver.toString());
        }
    }
    public static Driver findDriverToArrlist(int idDriver){
        for (Driver driver: driverArrayList) {
            if(driver != null && driver.getId() == idDriver){
                System.out.println(driver);
                return driver;
            }
        }
        return null;
    }
}
