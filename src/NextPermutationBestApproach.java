import java.util.Arrays;
import java.util.ArrayList;

public class NextPermutationBestApproach {
    public static void main(String[] args) {
        ArrayList<Integer> inputList =new ArrayList<>(Arrays.asList(3,2,1));
        ArrayList<Integer> outputList = getNextPermutation(inputList);
        System.out.println(outputList);

    }

    private static ArrayList<Integer> getNextPermutation(ArrayList<Integer> inputList) {
        int len = inputList.size();
        int indexFirst = len-2;
        int l = 0;
        while(indexFirst>=0)
        {
            if(inputList.get(indexFirst)<inputList.get(indexFirst+1))
            {
                break;
            }
            indexFirst--;
        }
        if(indexFirst<0) // The input is greatest number
        {
            reverse(inputList,0,len-1);
        }
        else
        {
            for(l=len-1;l>=indexFirst;l--)
            {
                if(inputList.get(indexFirst)<inputList.get(l))
                {
                    swap(inputList,indexFirst,l);
                    break;
                }
            }
            reverse(inputList,indexFirst+1,len-1);
        }
        return inputList;
    }

    static void reverse(ArrayList<Integer> arr, int i, int j)
    {
        while(i<j)
        {
            swap(arr,i,j);
            i++;j--;
        }
    }

    private static void swap(ArrayList<Integer> arr, int i, int j) {
        int t = arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,t);
    }
}
