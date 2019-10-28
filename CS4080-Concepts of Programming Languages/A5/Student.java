
public class Student {

    private String name;
    private String grade;

    public Student(String n, String g) {
        setName(n);
        setGrade(g);
    }

    public Student(Student s) {
        setName(s.getName());
        setGrade(s.getGrade());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    void print() {
        System.out.println(name + " : " + grade + "%");
    }
}