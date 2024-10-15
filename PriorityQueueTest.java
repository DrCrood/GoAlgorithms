import java.util.Arrays;
import Sorting.*;
import java.util.Random;
import java.util.UUID;
import PriorityQueue.MaxPriorityQueue;
import Sorting.Heap;

public class PriorityQueueTest {

    public static void main(String[] args) {
        int[] A = new int[]{1, 10, 2, 7, 3, 8, 9, 99, 100, 4, 5, 6, 11, 12};
        Heap.Sort(A);

        String[] sarr = Arrays.stream(A).mapToObj(String::valueOf).toArray(String[]::new);
        String result = String.join(" ", sarr);
        System.out.println(result);

        Random ran = new Random();
        MaxPriorityQueue maxQueue = new MaxPriorityQueue();
        for(int i = 0; i < 20; i++)
        {
            Task task = new Task("TASK-"+i);
            task.Priority = ran.nextInt(100);
            maxQueue.Add(task);
        }

        maxQueue.UpdatePriority("TASK-5", 50);
        maxQueue.UpdatePriority("TASK-10", 50);
        maxQueue.UpdatePriority("TASK-7", 1);
        maxQueue.UpdatePriority("TASK-17", 1);

        while (!maxQueue.IsEmpty()) {
            Task task = maxQueue.Dequeue();
            System.out.println(task.Name + " : " + task.Priority + " - " + task.Index);
        }

    }
}