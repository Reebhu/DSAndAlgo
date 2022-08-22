import java.util.Arrays;

//Longest increasing subsequence
public class SolutionLIS {

    public static int findLIS(int [] arr, int len)
    {
        int lis[]= new int[len];
        Arrays.fill(lis,1);

        for(int i=0;i<len;i++)
        {
            int comp = arr[i];
            for(int j=0;j<i;j++)
            {
                if(comp>arr[j] && lis[i]<lis[j]+1)
                {
                        lis[i]+=1;
                }
            }
        }
        return max(lis);
    }

    static int  max (int... values )
    {
        int maxi = values[0];
        for(int i : values)
        {
            if(maxi<i)
                maxi = i;
        }
        return maxi;
    }

    public static void main(String[] args) {
        int arr[] =  { 0,1,0,3,2,3 };
        System.out.println(findLIS(arr, arr.length));
    }
}

