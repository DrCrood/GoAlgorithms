package Search;

import Sorting.QuickSort;

public class TopN {
    public static int[] FindByLoopOver(int[]A, int n)
    {
        int[] top = new int[n];

        int j = 0;
        int max = Integer.MIN_VALUE;
        int index = 0;
        for(int l = 0; l < n; l++)
        {
            for(int i=l; i<A.length; i++)
            {
                if(A[i] > max)
                {
                    max = A[i];
                    index = i;
                }
            }

            int t = A[l];
            A[l] = A[index];
            A[index] = t;
            top[l] = A[l];
            max = Integer.MIN_VALUE;
        }

        return top;
    }

    public static int[] FindByPartition(int[] A, int n)
    {
        int[] top = new int[n];
        int toBeFound = n;

        int first = 0;
        int last = A.length - 1;
        while (toBeFound > 0) 
        {
            int p = QuickSort.PartitionDec(A, first, last);
            if(p-first+1 == toBeFound)
            {
                break;
            }
            else if(p-first+1 > toBeFound)
            {
                last = p - 1;
            }
            else
            {
                for(int k=first; k<=p; k++)
                {
                    toBeFound --;
                }
                first = p + 1;                
            }
        }

        for(int i = 0; i<n; i++)
        {
            top[i] = A[i];
        }
        return top;
    }


    
}
