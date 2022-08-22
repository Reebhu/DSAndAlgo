import java.util.ArrayList;

public class LargestSumSubArray {

    //Kadane's Algo(Sliding window?)
    public static void main(String[] args) {
        int [] arr = {-2,1,-3,4,-1,2,1,-5,4};
        ArrayList<Integer> subarray = new ArrayList<>();
        int size = findLargestSumSubArray(arr,subarray);
        for(int i = subarray.get(0);i<=subarray.get(1);i++)
        {
            System.out.print(arr[i]+" ");
        }
    }

    private static int findLargestSumSubArray(int[] arr, ArrayList<Integer> subarray) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxEnd = 0; //max sum ending at ith index
        int s=0;
        for(int i=0;i< arr.length ;i++)
        {
            maxEnd += arr[i];
            if(maxSoFar<maxEnd)
            {
                subarray.clear();
                maxSoFar = maxEnd;
                subarray.add(s);
                subarray.add(i);
            }
            if(maxEnd<0)
            {
                maxEnd =0;
                s=i+1;
            }
        }
        return maxSoFar;
    }
}
