import java.util.Arrays;
import Sorting.*;
import java.util.Random;
import java.util.*;

import PriorityQueue.MaxPriorityQueue;
import PriorityQueue.Task;
import Search.BiTree;
import Search.LCS;
import Search.LongestPalindrome;
import Search.Node;
import Search.TopN;
import Sorting.Heap;

public class PriorityQueueTest {

    public static void main(String[] args) {
        int[] A = new int[]{1, 10, 2, 7, 3, 8, 9, 99, 100, 4, 5, 6, 11, 12};
        //Heap.Sort(A);
        QuickSort.Sort(A, 0, A.length-1);

        String[] sarr = Arrays.stream(A).mapToObj(String::valueOf).toArray(String[]::new);
        String result = String.join(" ", sarr);
        System.out.println(result);

        Random ran = new Random();
        MaxPriorityQueue maxQueue = new MaxPriorityQueue();
        for(int i = 0; i < 20; i++)
        {
            Task task = new Task("TASK-"+i);
            task.Priority = ran.nextInt(40);
            maxQueue.Add(task);
        }

        maxQueue.UpdatePriority("TASK-5", 50);
        maxQueue.UpdatePriority("TASK-7", 1);

        while (!maxQueue.IsEmpty()) {
            Task task = maxQueue.Dequeue();
            // System.out.println(task.Name + " : " + task.Priority);
        }

        int[] a = new int[25];
        for(int i = 0; i < 25; i++)
        {
            a[i] = ran.nextInt(100)*ran.nextInt(100);
        }

        //int[] top5 = TopN.FindByLoopOver(a, 5);
        int[] top52 = TopN.FindByPartition(a, 5);

        BiTree tree = new BiTree();

        for(int i = 0; i < 20; i++)
        {
            Node node = new Node();
            node.Key = ran.nextInt(100);
            tree.Insert(node);
        }

        System.out.println(tree.Maximum().Key);
        System.out.println(tree.Minimum().Key);

        tree.InorderWark(tree.Root);


        int[] ai = new int[]{7, 1, 5, 1, 2, 3, 6, 3, 3, 8, 9, 5, 10};
        int[] bi = new int[]{9,1, 7, 9, 1, 5, 3, 7, 6,7, 8, 7, 9, 6, 10};

        int[] r = LCS.FindLCS(ai, bi);
        System.out.println();
        for (int i : r) {
            System.out.print("-" + i);
        }

        String s = "qwertabcdefghgfedcbacharacterqwertyuiopoiuytrewq123aaabbbccddeddccbbbaaa";
        String ps = LongestPalindrome.search(s);
        System.out.println(ps);
    }
}