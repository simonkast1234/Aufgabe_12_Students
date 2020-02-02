import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDataTest {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        // Einlesen der Datei
        try (BufferedReader br = new BufferedReader(new FileReader("src/data.csv"))) {
            String s;
            while((s = br.readLine()) != null) {
                String[] values = s.split(";");
                String[] modules = {};
                if(values.length > 4) {
                    modules = values[4].split(",");
                }
                studentList.add(new Student(Integer.parseInt(values[0]), values[1], values[2], values[3], modules));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Anlegen von zwei neuen Studierenden
        studentList.add(new Student(000000, "name1", "nachname1", "email1", null));
        studentList.add(new Student(000001, "name2", "nachname2", "email2", null));

        // Exportieren mittels Objektserialisierung
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/studentdata.bin"))) {
            oos.writeObject(studentList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Leeren der Liste
        studentList.clear();

        // Einlesen der Liste
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/studentdata.bin"))) {
            studentList = (List<Student>) ois.readObject();
        } catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Konsolenausgabe
        System.out.println(studentList);
    }
}
