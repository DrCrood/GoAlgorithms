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
        for(int i = 0; i < 50; i++)
        {
            Task task = new Task(UUID.randomUUID().toString());
            task.Priority = ran.nextInt(10);
            maxQueue.Add(task);
        }
        int i = 0;
        while (maxQueue.TaskAvailable()) {
            Task task = maxQueue.Dequeue();
            System.out.println(i++ + " : " + task.Priority);
        }

    }
}