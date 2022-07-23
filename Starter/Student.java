/**
 * TODO: Complete the solution for Student
 */
import java.util.Objects;

public class Student implements Comparable<Student> {
    private final String firstName;
    private final String lastName;
    private final String PID;

    public Student(String firstName, String lastName, String PID) {
        if (firstName == null || lastName == null || PID == null){
            throw new IllegalArgumentException(); 
        }

        this.firstName = firstName; 
        this.lastName = lastName; 
        this.PID = PID; 
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getPID() {
        return this.PID;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null){
            return false; 
        }

        if (o instanceof Student){
            Student s = (Student) o;
            if (this.PID.equals(s.PID)){
                return true; 
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, PID);
    }

    @Override
    public int compareTo(Student o) {
        if (this.getLastName() == o.getLastName()){
            if (this.getFirstName() == o.getFirstName()){
                if (this.getPID() == o.getPID()){
                    return 0; 
                }
                return 1;
            }
            return 1; 
        }

        return -1;
    }
}
