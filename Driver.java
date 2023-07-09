import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import InsertionSort.InsertionSort;
import MergeSort.MergeSortAlgorithm;

public class Driver {
    public static String sortCalled = "";

    public static void main(String[] args){
         System.out.println("What sorting Algorithm are you calling? Type the numerical value:");
         System.out.println("Insertion: 1\n"
                        + "Merge: 2");
   
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

        switch(userInput)
        {
            case "1":
                System.out.println("Welcome to Insertion Sort Algorithm!");
                break;
            case "2":
                System.out.println("Welcome to Merge Sort Algorithm!");
                break;
             default:
                System.out.println("Invalid Input. Please run the code again!");
                return;
        }

        callingFileOpenAndSort(userInput);
        input.close();
    
    }

    public static void callingFileOpenAndSort(String sortType)
    {        
        String maindir = System.getProperty("user.dir");
        File directoryWithData = new File(maindir + "\\Data" );
        File dataFiles[] = directoryWithData.listFiles();
        for(File file: dataFiles)   {
            String fileName = file.getName();
            try{
                Scanner reader = new Scanner(file);
                String tempStringValue="";
                while (reader.hasNextLine())
                {
                    tempStringValue += reader.nextLine();
                }
                reader.close();
                
                String elementsInString[] = tempStringValue.split(",");
                int elements[] = Arrays.stream(elementsInString).mapToInt(Integer::parseInt).toArray();

                long startTime = System.currentTimeMillis();
                System.out.println("Starting " + fileName + " at " + startTime);

                if(sortType.equals("1"))
                    InsertionSort.sort(elements);
                else 
                    MergeSortAlgorithm.sort(elements, 0, elements.length -1);
                    

                long endTime = System.currentTimeMillis();
                System.out.println("Ending " + fileName + " at " + endTime);

                System.out.println("Execution time for " + fileName + " was " + (endTime - startTime));
                System.out.println("\n");

            }
            catch(FileNotFoundException e)
            {
                System.out.println("An error ocurred trying to access " + fileName);
            } 
            
        }   
    }
    
}