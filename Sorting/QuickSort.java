package Sorting;

public class QuickSort {
    public static void Sort(int[] A, int start, int end)
    {
        if(start < end)
        {
            int q = Partition(A, start, end);
            Sort(A, start, q-1);
            Sort(A, q+1, end);
        }
    }

    public static int Partition(int[] A, int s, int e)
    {
        int p = A[e];
        int i = s - 1;  //i is the smaller number location tracker

        for(int j = s; j < e; j++)
        {
            if(A[j] <= p)
            {
                i++;
                int t = A[i];
                A[i] = A[j];
                A[j] = t;
            }
        }
        int t = A[i+1];
        A[i+1] = A[e];
        A[e] = t;
        return i + 1;
    }

    public static int PartitionDec(int[] A, int s, int e)
    {
        int p = A[e];
        int i = s - 1;  //i is the smaller number location tracker

        for(int j = s; j < e; j++)
        {
            if(A[j] > p)
            {
                i++;
                int t = A[i];
                A[i] = A[j];
                A[j] = t;
            }
        }
        int t = A[i+1];
        A[i+1] = A[e];
        A[e] = t;
        return i + 1;
    }
}
