/*
 * 
 * Auto pou briskoumai einai to clustering
 * stis epiloges twn ma8htwn.
 * Dhladh to euros to protimhsevn
 * Se poia ma8hmata uparxei mikro euros ma8htwn kai poio 
 * einai auto ab 8eloume
 * kai se poia uparxei megalo euros.
 * 
 */
package students;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Clustering {

    private static final int STUDENTS = 12;
    private static final int CLASSES = 100;
    private static final int CHOICES = 5;
    private static final int AMRANGE = 3000;
    private static final int AMSTART = 1000;
    private static Class[] classes = new Class[CLASSES];
    private static Student[] students = new Student[STUDENTS];
    private static ArrayList<Class> classess = new ArrayList<Class>();
    private static ArrayList<Distance> distances = new ArrayList<Distance>();

    private static void fillClasses() {
        for (int i = 0; i < classes.length; i++) {
            classes[i] = new Class(i);
        }
    }

    private static void fillStudents() {
        Random random = new Random();
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(random.nextInt(AMRANGE) + AMSTART);
        }
    }

    private static void setClasses() {
        Random random = new Random();
        for (Student student : students) {
            int j = 0;
            while (j < CHOICES) {

                Class sClass = classes[ random.nextInt(CLASSES)];
                if (!student.checkIfExists(sClass)) {
                    try {
                        student.setClass(sClass);
                        j++;

                    } catch (EnoughException ex) {
                        ex.printStackTrace();
                        break;
                    }
                }
            }
        }
    }

    private static void appearStudents() {
        for (Student student : students) {
            System.out.println(student);
            System.out.println(student.getClasses());
        }
    }

    private static void appearClasses() {
        for (Class cl : classes) {
            if (cl.students.size() > 0) {
                System.out.println(cl);
                System.out.println(cl.getStudents());
            }

        }
    }

    private static void getWeights() {
        for (Class cl : classes) {
            int weight = cl.getWeight();
            if (weight > 0) {
                // System.out.printf("%s has weight %4d\n", cl, weight);
                classess.add(cl);
            }
        }
    }

    private static void getDistances() {
        for (Class cl : classess) {
            for (Class cls : classess) {
                if (!cl.equals(cls)) {
                    Distance dist = new Distance(Math.abs(cl.getWeight() - cls.getWeight()), cl, cls);
                    if (!distances.contains(dist)) {
                        distances.add(dist);
                    }
                }
            }
        }
    }

    private static void seeDistances() {
        Collections.sort(distances);
        for (Distance distance : distances) {
            System.out.println(distance);
        }
    }


    public static void main(String[] args) {
        fillClasses();
        fillStudents();
        setClasses();
        // appearStudents();
        //appearClasses();
        getWeights();
        getDistances();
        seeDistances();
    }
}
