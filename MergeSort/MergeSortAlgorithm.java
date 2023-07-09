package MergeSort;

public class MergeSortAlgorithm {
    
    //Recursively splits the array size to n/2 to isolate single element in its own array
    public static void sort(int[] inputarray, int startIndex, int endIndex){
        //checks if value is greater than 0 or 1
        if(startIndex < endIndex)
        {
            int middle = Math.floorDiv( startIndex + endIndex, 2);

            //Split Left
            sort(inputarray, startIndex, middle);

            //Split Right
            sort(inputarray, middle + 1, endIndex);

            //Combine
            merge(inputarray, startIndex, middle, endIndex);
        }
    }

    //This method is incharge of combining the array values comparing left array to right array
    // and ensuring it adds the smaller one first and then the larger value. It traverses through 
    //all the elements in left and right.
    //In case on the the arrays becomes empty it uses values from the full array to fill up the 
    //remaining slots in sorted array. 
    public static int[] merge(int[] mainArray, int startIdx, int mid, int lastIdx)
    {
        int n1 = mid - startIdx + 1;
        int n2 = lastIdx - mid;

        //Subarray for left/right with n+1th spot to add the max value
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];

        for(int i = 0; i < n1 ; i++)
            L[i] = mainArray[startIdx + i];

        for (int j = 0; j < n2; j++)
            R[j] = mainArray[mid + j + 1];

        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE; 

        int i = 0;
        int j = 0;

        //checks which side value is smaller and adds to the sorted array accordingly
        for(int k = startIdx; k <= lastIdx; k++)
        {
            if(L[i] <= R[j])
                mainArray[k] = L[i++];
            else
                mainArray[k] = R[j++];
            

        }
        return mainArray;
    }
}
