package service;

import entity.Driver;
import entity.Route;
import main.Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class RouteService {
    public static String ROUTE_FILE = "route.txt";
    private static ArrayList<Route> routeArrayList;
    public RouteService(){
        routeArrayList = new ArrayList<Route>();
    }

    public static void addRouteToLinkedList() throws IOException {
        System.out.println("Nhập số tuyến: ");
        do {
            int numberRoute = -1;
            Route route = null;
            try {
                numberRoute = new Scanner(System.in).nextInt();
            } catch (Exception ex) {
                System.out.println("Mời nhập lại ");
            }
            for (int i = 0; i < numberRoute; i++) {
                route = new Route();
                route.inputInformation();
                routeArrayList.add(route);
            }
            Main.initializeData.writeArrayListToFile(ROUTE_FILE,routeArrayList);
            if (route != null) {
                break;
            }
        } while (true);
        System.out.println("---------");
        showAllRouteFromArrayList();
        System.out.println("---------");
    }
    public static void showAllRouteFromArrayList() {
        for (Route route : routeArrayList) {
            System.out.println(route.toString());
        }
    }
    public static Route findRouteToArraylist(int idRoute){
        for (Route route: routeArrayList) {
            if(route != null && route.getId() == idRoute){
                System.out.println(route);
                return route;
            }
        }
        return null;
    }
}
