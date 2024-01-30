public class Student {

    protected int id;
    protected String name;
    protected String surname;
    protected int age;
    protected float gpa;

    /**
     * Constructor of our student as in given pdf.
     * @param id
     * @param name
     * @param surname
     * @param age
     * @param gpa
     */
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

    //All getters and setters for students attributes.
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