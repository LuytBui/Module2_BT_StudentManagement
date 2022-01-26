package Model;

public class Student implements ElementInList {
    private String id;

    private String name;

    private String hometown;

    private String className;

    private double mark;

    public Student() {
    }

    public Student(String id, String name, String hometown, String className, double mark) {
        this.id = id;
        this.name = name;
        this.hometown = hometown;
        this.className = className;
        this.mark = mark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + hometown + ", " + className + ", " + mark;
    }
}
