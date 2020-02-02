import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {

    private int student_ID;
    private String firstName;
    private String lastName;
    private String email;
    private List<String> modules = new ArrayList<>();

    public Student(int student_ID, String firstName, String lastName, String email, String[] modules) {
        this.student_ID = student_ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        if(modules != null) {
            for (String module : modules) {
                this.modules.add(module);
            }
        }
    }

    @Override
    public String toString() {
        return "\nID: " + this.student_ID + " name: " + this.firstName + " " + this.lastName + " email: " + this.email + " modules: " + this.modules;
    }

}
