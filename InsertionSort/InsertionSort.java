package InsertionSort;

public class InsertionSort {

    public static int[] sort(int[] inputarray)
    {
        //looks at each element, starting at second element in the array 
        for (int currentIndex=1; currentIndex < inputarray.length; currentIndex++)
        {
            int currentValue = inputarray[currentIndex];
            int prevIndex = currentIndex - 1;

            //Compares all values to the left of the array to check if they are greater,
            //if yes, then move the bigger value to its repective index + 1 then once the current element spot is discovered then 
            //assign th spot to current elements index
            //if not, then keep checking until element at index 0 is reached.
            while (prevIndex > -1 && inputarray[prevIndex] > currentValue)
            {
                inputarray[prevIndex + 1] = inputarray[prevIndex];
                prevIndex = prevIndex - 1;
            }
            inputarray[prevIndex + 1] = currentValue;
        }
        return inputarray;
    }
}