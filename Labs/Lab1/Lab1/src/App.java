import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<String> names = new ArrayList<>();
        File myFile = new File("U:\\Term222{ICS202-SWE206-ISE291-MATH208-GS332}\\SWE206\\Labs\\Lab1\\List.txt");
        Scanner input = new Scanner(myFile);

        while(input.hasNext()){
            names.add(input.next());
        }
        System.out.println(fixedSizeGroups(names, 5));
        System.out.println(fixedNumberOfGroups(names, 3));
    }
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

