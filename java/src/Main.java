import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        String line = "";
        String splitBy = ",";

        Student[] students = new Student[100001];

        try{
            BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\TEMP\\Desktop\\random_data.csv"));
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

        //Checking students array to avoid exceptions.

        for(int i= 0; students[i] != null; i++){
            System.out.println(students[i].getId());
            System.out.println(students[i].getName());
            System.out.println(students[i].getSurname());
            System.out.println(students[i].getAge());
            System.out.println(students[i].getGpa());
        }

        TreeInt treeInt = new TreeInt();
        TreeString treeString = new TreeString();


        //Inserting all id's to idBST namesurname's to namesurnameBST
        //I used Name first and Surname second for ordering.

        for(int i = 0; students[i] != null; i++){
            treeInt.recursiveInsert(new TreeNodeInt(students[i].getId()));
            String nameSurname = students[i].getName() + students[i].getSurname();
            treeString.recursiveInsert(new TreeNodeString(nameSurname));
        }

        treeInt.intervalSearch(797774 ,'>');
        treeInt.intervalSearch(797781, '<');

        treeString.intervalSearch("BrendaMooreTodd",'<');//I used Name first and Surname second for ordering.
        treeString.intervalSearch("LoriJordanDavis", '>');//I used Name first and Surname second for ordering.

        treeInt.delete(989577);
        treeInt.inorder();

        System.out.println(treeInt.exactSearch(405824).getData());

        System.out.println(treeString.exactSearch("TaylorParrishMacias").getData());
        treeString.delete("TaylorParrishMacias");
        System.out.println(treeString.exactSearch("TaylorParrishMacias").getData()); //THIS CODE GIVES NULL POINTER EXCEPTION BECAUSE WE ARE DELETING THIS NAME ABOVE.
    }
}