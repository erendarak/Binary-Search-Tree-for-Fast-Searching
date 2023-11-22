import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        String line = "";
        String splitBy = ",";
        Student[] students = new Student[50];

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Eren Darak\\Desktop\\demo.csv"));
            int counter = 0;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(splitBy);
                String id = data[1].replaceAll("\\s","");
                String name = data[2].replaceAll("\\s","");
                String surname = data[3].replaceAll("\\s","");
                String age = data[4].replaceAll("\\s","");
                String gpa = data[5].replaceAll("\\s","");
                students[counter] = new Student(Integer.parseInt(id), name, surname, Integer.parseInt(age), Float.parseFloat(gpa));
                counter++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        TreeInt treeInt = new TreeInt();
        TreeString treeString = new TreeString();

        for(int i = 0; students[i] != null; i++){
            treeInt.recursiveInsert(new TreeNodeInt(students[i].getId()));
            String nameSurname = students[i].getName() + students[i].getSurname();
            treeString.recursiveInsert(new TreeNodeString(nameSurname));
        }

        treeInt.inorder();
        treeString.inorder();

        /*
        for(int i = 0; students[i] != null; i++){
            System.out.println(students[i].getId());
            System.out.println(students[i].getName());
            System.out.println(students[i].getSurname());
            System.out.println(students[i].getAge());
            System.out.println(students[i].getGpa());
        }*/
    }
}
