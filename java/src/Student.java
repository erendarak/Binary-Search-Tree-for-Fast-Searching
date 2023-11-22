public class Student {

    protected int id;
    protected String name;
    protected String surname;
    protected int age;
    protected float gpa;

    public Student(int id, String name, String surname, int age, float gpa) {
        if(id <= 999999 && id >= 100000){
            this.id = id;
        }
        this.name = name;
        this.surname = surname;
        if(age >= 10 && age <= 100){
            this.age = age;
        }
        if(gpa >= 0.0 && gpa <= 4.0){
            this.gpa = gpa;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

}