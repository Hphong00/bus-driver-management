package data;

import java.io.*;
import java.util.ArrayList;

public class InitializeData {
    public void writeArrayListToFile(String file, ArrayList arrayList) throws IOException {
        FileWriter writer = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        try{
            for(Object obj: arrayList) {
                bufferedWriter.write(obj + System.lineSeparator());
            }
        }catch (IOException e) {
            System.out.println(e);
        }finally {
            bufferedWriter.close();
        }
    }
    public void readArrayListFromFile(String file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
            ArrayList<Object> objects = (ArrayList<Object>) ois.readObject();
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            fis.close();
            ois.close();
        }
    }
}
