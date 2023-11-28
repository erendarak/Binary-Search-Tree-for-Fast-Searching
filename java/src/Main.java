import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        String line = "";
        String splitBy = ",";

        Student[] students = new Student[100001];

        try{
            BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\Eren Darak\\Desktop\\random_data.csv"));
            int counter = 0;
            while((line = bf.readLine()) != null){
                if(counter == 0){
                    counter++;
                }else{
                    String[] data = line.split(splitBy);
                    String id = data[0].replaceAll("\\s","");
                    String name = data[1].replaceAll("\\s","");
                    String surname = data[2].replaceAll("\\s","");
                    String age = data[3].replaceAll("\\s","");
                    String gpa = data[4].replaceAll("\\s","");
                    students[counter-1] = new Student(Integer.parseInt(id),name,surname,Integer.parseInt(age),Float.parseFloat(gpa));
                    counter++;
                }
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        TreeInt treeInt = new TreeInt();
        TreeString treeString = new TreeString();

        for(int i = 0; students[i] != null; i++){
            treeInt.recursiveInsert(new TreeNodeInt(students[i].getId()));
            String nameSurname = students[i].getName() + students[i].getSurname();
            treeString.recursiveInsert(new TreeNodeString(nameSurname));
        }

        for(int i= 0; students[i] != null; i++){
            System.out.println(students[i].getId());
            System.out.println(students[i].getName());
            System.out.println(students[i].getSurname());
            System.out.println(students[i].getAge());
            System.out.println(students[i].getGpa());
        }

        //treeInt.inorder();
        //treeString.inorder();
        //treeInt.delete(147550);
        //treeInt.inorder();
        //treeString.delete("WhitneyBakerMack");
        //treeString.inorder();
        //TreeNodeInt searchInt = treeInt.exactSearch(600574);
        //Student searchIntStudent;
        /*for(int i = 0; students[i] !=null; i++){
            if(searchInt.getData()==students[i].getId()){
                System.out.println("Result of the search:");
                System.out.println("ID: " +students[i].getId());
                System.out.println("Name: " +students[i].getName());
                System.out.println("Surname: " +students[i].getSurname());
                System.out.println("Age: " +students[i].getAge());
                System.out.println("GPA: " +students[i].getGpa());
                break;
            }
        }*/
        //treeInt.intervalSearch(600574,'>');
        //System.out.println(treeString.exactSearch("ShannonWolfGonzalez").getData());
        //treeString.intervalSearch("AaronHardyPhillips",'>');
    }
}