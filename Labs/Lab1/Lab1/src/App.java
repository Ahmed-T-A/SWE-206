import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        try{
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the path of the list file: "); // Enter the path.
            String fileName = input.next();
            File students = new File(fileName); // "U:\\Term222{ICS202-SWE206-ISE291-MATH208-GS332}\\SWE206\\SWE-206\\Labs\\Lab1\\List.txt"
            Scanner reader = new Scanner(students);
            ArrayList studenList = new ArrayList<>();
            while(reader.hasNext()){
                String student = reader.next();
                studenList.add(student);
            }
            System.out.print("Enter the way of distributing students:\n  1) By a fixed number of groups.\n  2) By a fixed maximum students.\nChoice: ");
            int way = input.nextInt();
            switch (way) {
                case 1 :
                    System.out.print("Enter the number of groups: ");
                    int groupsNumber = input.nextInt();
                    System.out.println(fixedNumberOfGroups(studenList, groupsNumber));
                    break;
                case 2 :
                    System.out.print("Enter the maximum number of students: ");
                    int maxSize = input.nextInt();
                    System.out.println(fixedSizeGroups(studenList, maxSize));
                    break;
            }
        }
        catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        } 
    }

    // Creating groups with a fixed number of students.
    public static ArrayList<ArrayList<String>> fixedSizeGroups( ArrayList<String> names, int size){
        int listSize = names.size();
        ArrayList<ArrayList<String>> groupsArray = new ArrayList<ArrayList<String>>();
        while (!names.isEmpty()){
            ArrayList<String> group = new ArrayList<>();
                for(int z = 0; z < size ; z++){
                    int random = (int)(Math.random() * listSize);
                    group.add(names.get(random));
                    names.remove(random);
                    listSize--;
                    if (names.isEmpty()){
                        break;
                    }
                }
                groupsArray.add(group);
            }   
        return groupsArray;
    }

    // Creating fixed number of groups.
    public static ArrayList<ArrayList<String>> fixedNumberOfGroups( ArrayList<String> names, int numOfGroups){
        int listSize = names.size();
        int numberOfStudentInEachGroup = 0;
        if(listSize % numOfGroups == 0){
            numberOfStudentInEachGroup = listSize / numOfGroups;
        }
        else{
            while(listSize % numOfGroups != 0){
                listSize--;
            }
            numberOfStudentInEachGroup = listSize / numOfGroups;
        }

        ArrayList<ArrayList<String>> groupsArray = new ArrayList<ArrayList<String>>();
        for(int z = 0; z < numOfGroups - 1; z++){
            ArrayList<String> group = new ArrayList<>();
            for(int i = 0; i < numberOfStudentInEachGroup; i++){
                int random = (int)(Math.random() * listSize);
                group.add(names.get(random));
                names.remove(random);
                listSize--;
            }  
            groupsArray.add(group);
        }
        groupsArray.add(names);
        return groupsArray;
    }
}

