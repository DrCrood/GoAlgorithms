package Sorting;

public class Heapsort
{
    private static void BuildMaxHeap(int[] A)
    {
        int heapSize = A.length;
        int start = (int)Math.floor(A.length/2);
        for(int i= start; i>=0; i--)
        {
            MaxHeapify(A, heapSize, i);
        }
    }

    private static void MaxHeapify(int[] A, int heapSize, int index)
    {
        int left = Left(index);
        int right = Right(index);
        int maxIndex = 0;
        if(left < heapSize && A[left] > A[index])
        {
            maxIndex = left;
        }
        else
        {
            maxIndex = index;
        }

        if(right < heapSize && A[right] > A[maxIndex])
        {
            maxIndex = right;
        }

        if(maxIndex != index)
        {
            int t = A[maxIndex];
            A[maxIndex] = A[index];
            A[index] = t;
            MaxHeapify(A, heapSize, maxIndex);
        }
    }


    public static void Sort(int[] A)
    {
        int heapSize = A.length;
        BuildMaxHeap(A);
        for(int i = A.length-1; i>0; i--)
        {
            int t = A[i];
            A[i] = A[0];
            A[0] = t;
            heapSize--;
            MaxHeapify(A, heapSize, 0);
        }
    }

    private static int Parent(int i)
    {
        return (int)Math.floor(i/2);
    }

    private static int Left(int i)
    {
        return 2*i;
    }

    private static int Right(int i)
    {
        return 2*i + 1;
    }
}