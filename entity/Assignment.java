package entity;

//import comaprator.MyComaprator;
import entity.detail.DetailRoute;
import main.Main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;



public class Assignment{

    static Map<Driver, ArrayList<DetailRoute>> linkedHashMap;
    static final int ALPHA_ZULU = 0;

    public Assignment() {
        linkedHashMap = new LinkedHashMap<Driver, ArrayList<DetailRoute>>();
    }

    public void addAssignmentToMap(Driver driver, ArrayList<DetailRoute> detailRouteArrayList) {
        linkedHashMap.put(driver, detailRouteArrayList);
    }

    public void showAssignmentMap() {
        for (Map.Entry<Driver, ArrayList<DetailRoute>> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue() + "\n");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assignment that = (Assignment) o;
        return Objects.equals(linkedHashMap, that.linkedHashMap);
    }

    public void sortNameDriver() {
        Set<Map.Entry<Driver, ArrayList<DetailRoute>>> entrySet = linkedHashMap.entrySet();

        List<Map.Entry<Driver, ArrayList<DetailRoute>>> list = new ArrayList<>(entrySet);

        Collections.sort(list, (o1, o2) -> o1.getKey().getFullName().compareTo(o2.getKey().getFullName()));

        list.forEach(s->{
            System.out.println(s.getKey()+"\t"+s.getValue());
        });
        showAssignmentMap();
    }
    public void sortNumberRoute(){
        Set<Map.Entry<Driver, ArrayList<DetailRoute>>> entrySet = linkedHashMap.entrySet();

        List<Map.Entry<Driver, ArrayList<DetailRoute>>> list = new ArrayList<>(entrySet);

        Collections.sort(list, new Comparator<Map.Entry<Driver, ArrayList<DetailRoute>>>() {
            @Override
            public int compare(Map.Entry<Driver, ArrayList<DetailRoute>> o1, Map.Entry<Driver, ArrayList<DetailRoute>> o2) {
//                return (o1.getValue());
                return 0;
            }
        });
    }


    public static void writeMapToFile(String fileName) throws IOException {
        File file = null;
        BufferedWriter bufferedWriter = null;
        try {
            file = new File(fileName);
            bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            for (Map.Entry<Driver, ArrayList<DetailRoute>> entry : linkedHashMap.entrySet()) {
                bufferedWriter.write(entry.getKey() + ":" + entry.getValue());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            System.out.println("Error Write file");
        } finally {
            bufferedWriter.close();
        }
    }

}
