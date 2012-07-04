package students;

import java.util.ArrayList;
import java.util.Iterator;

public class Class extends Descriptor {

    protected ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<Distance> distances;

    public Class(int id) {
        this.id = id;
    }

    public void assign(Student student) throws EnoughException {
        if (students.contains(student)) {
            throw new EnoughException(this);
        }
        students.add(student);
    }

    public String getStudents() {
        StringBuilder stringbuilder = new StringBuilder();
        for (Iterator<Student> it = students.iterator(); it.hasNext();) {
            Student student = it.next();
            StringBuilder append = stringbuilder.append(student.toString()).append("\n");
        }
        return stringbuilder.toString();
    }

    public int getWeight() {
        int totalizator = 0;
        for (Iterator<Student> it = students.iterator(); it.hasNext();) {
            Student student = it.next();
            totalizator += student.getId();
        }
        try {
            return totalizator / students.size();
        } catch (ArithmeticException ae) {
            //System.out.println(ae.getMessage());
            return 0;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringbuilder = new StringBuilder("Class ");
        if (this.descriptor != null) {
            stringbuilder.append(String.format("%s "));
        }
        stringbuilder.append(String.format("with id %2d", id));
        return stringbuilder.toString();
    }
}
