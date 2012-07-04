package students;

public class Student extends Descriptor {

    private final int CLASSES = 20;
    private Class[] classes = new Class[CLASSES];
    private int i = 0;

    public Student(int id) {
        this.id = id;
    }

    public void setClass(Class lesson) throws EnoughException {
        if (getI() == CLASSES) {
            throw new EnoughException(this);
        }
        classes[i++] = lesson;
        lesson.assign(this);
    }

    public boolean checkIfExists(Class classT) {
        for (int j = 0; j < i; j++) {
            if (classes[j].equals(classT)) {
                return true;
            }
        }
        return false;
    }

    public int getI() {
        return i;
    }
    
    public String getClasses() {
        StringBuilder stringbuilder = new StringBuilder();
        for (Class cl : classes) {
            StringBuilder append = stringbuilder.append(cl.toString()).append("\n");
        }
        return stringbuilder.toString();
    }

    @Override
    public String toString() {
        StringBuilder stringbuilder = new StringBuilder("Student ");
        if (this.descriptor != null) {
            stringbuilder.append(String.format("%s "));
        }
        stringbuilder.append(String.format("with am %d", id));
        return stringbuilder.toString();
    }
}
