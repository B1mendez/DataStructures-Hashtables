/**
 * TODO: Complete the solution for Course
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import javax.print.DocFlavor.STRING;

public class Course {
    HashSet<Student> enrolled;
    private final int capacity;
    private final String department;
    private final String number;
    private final String description;

    public Course(String department, String number, String description, 
        int capacity){
            if (department == null || number == null || description == null){
                throw new IllegalArgumentException(); 
            }
            if (capacity < 0){
                throw new IllegalArgumentException(); 
            }

            this.department = department; 
            this.number = number; 
            this.description = description; 
            this.capacity = capacity; 
        }

    public String getDepartment(){
        return this.department;
    }

    public String getNumber(){
        return this.number;
    }

    public String getDescription(){
        return this.description;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public boolean enroll(Student student) {
        if (student == null){
            throw new IllegalArgumentException(); 
        }

        if (getCapacity() != 0 && !enrolled.contains(student)){
            enrolled.add(student);
            return true;
        }

        return false;
    }

    public boolean unenroll(Student student) {
        if (student == null){
            throw new IllegalArgumentException(); 
        }

        if(enrolled.contains(student)){
            enrolled.remove(student);
            return true; 
        }

        return false;
    }

    public void cancel() {
        enrolled.clear(); 
    }

    public boolean isFull() {
        return enrolled.size() == this.capacity;
    }

    public int getEnrolledCount() {
        return enrolled.size();
    }

    public int getAvailableSeats() {
        return enrolled.size() - this.capacity;
    }

    public HashSet<Student> getStudents() {
        return (HashSet<Student>) enrolled.clone();
    }

    public ArrayList<Student> getRoster() {
        ArrayList<Student> roster = new ArrayList<>();

        for (Student list: enrolled){
            roster.add(list); 
        }
        Collections.sort(roster); 

        return roster;
    }

    public String toString() {
        return this.department + " " + this.number + " " +
            "[" + this.capacity + "]" + "\n" + this.description;
    }
}

