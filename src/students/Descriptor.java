package students;

public abstract class Descriptor {

    protected int id;
    protected String descriptor;

    public int getId() {
        return id;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }
}

class EnoughException extends Exception {

    public EnoughException(Object obj) {
        super(obj.getClass().getName() + " is complete");
    }
}