package students;

public class Distance implements Comparable<Distance> {

    private int weight;
    private int id;
    private Class firstClass, secondClass;

    public Distance(int wght, Class fEdge, Class sEdge) {
        weight = wght;
        firstClass = fEdge;
        secondClass = sEdge;
        setId(fEdge,sEdge);
    }

    @Override
    public String toString() {
        return String.format(
                "Distance %4d between class %2d and %2d has weight %2d %2d",
                getWeight(), getFirstClass().getId(), getSecondClass().getId(),
                getFirstClass().getWeight(),getSecondClass().getWeight());
    }

    @Override
    public boolean equals(Object other) {
        Distance dis = (Distance) other;
        if (dis.getFirstClass().equals(this.firstClass) && dis.getSecondClass().equals(this.secondClass)) {
            return true;
        }
        if (dis.getFirstClass().equals(this.secondClass) && dis.getSecondClass().equals(this.firstClass)) {
            return true;
        }
        return false;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Class getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(Class firstClass) {
        this.firstClass = firstClass;
    }

    public Class getSecondClass() {
        return secondClass;
    }

    public void setSecondClass(Class secondClass) {
        this.secondClass = secondClass;
    }


    @Override
    public int compareTo(Distance dist) {
         if (weight > dist.getWeight()) {
            return 1;
        } else if (weight < dist.getWeight()) {
            return -1;
        } else {
            return 0;
        }
    }


    public int getId() {
        return id;
    }

    private void setId(Class cl,Class cls) {
        id = (cl.getId() + cls.getId())/2;
    }
}
