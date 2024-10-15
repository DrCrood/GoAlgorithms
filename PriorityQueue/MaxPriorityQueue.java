package PriorityQueue;

import Sorting.Task;

public class MaxPriorityQueue {
    private Task[] Tasks;
    private int taskCount;

    public MaxPriorityQueue()
    {
        Tasks = new Task[5];
        taskCount = 0;
    }

    public Boolean TaskAvailable()
    {
        return taskCount > 0;
    }

    public void Add(Task task)
    {
        if(taskCount < Tasks.length)
        {
            Tasks[taskCount] = task;
        }
        else
        {
            Task[] newTasks = new Task[Tasks.length * 2];
            for(int i=0; i<Tasks.length; i++)
            {
                newTasks[i] = Tasks[i];
            }
            newTasks[taskCount] = task;
            Tasks = newTasks;
        }

        task.Index = taskCount;
        taskCount++;
        Maxify(task);
    }

    public Task Dequeue()
    {
        Task task = Tasks[0];
        Tasks[0] = Tasks[taskCount-1];
        taskCount--;
        MaxHeapify(Tasks, taskCount, 0);
        return task;
    }

     private void Maxify(Task task)
     {
        //bottom up
        int i = task.Index;
        while (i > 0 && Tasks[Parent(i)].Priority < Tasks[i].Priority) 
        {
            Task tmp = Tasks[i];
            Tasks[i] = Tasks[Parent(i)];
            Tasks[Parent(i)] = tmp;
            i = Parent(i);     
        }
     }

     private int Parent(int i)
     {
         return (int)Math.floor(i/2);
     }
 
     private static void MaxHeapify(Task[] A, int heapSize, int index)
     {
        //top-down
         int left = Left(index);
         int right = Right(index);
         int maxIndex = 0;
         if(left < heapSize && A[left].Priority > A[index].Priority)
         {
             maxIndex = left;
         }
         else
         {
             maxIndex = index;
         }
 
         if(right < heapSize && A[right].Priority > A[maxIndex].Priority)
         {
             maxIndex = right;
         }
 
         if(maxIndex != index)
         {
             Task t = A[maxIndex];
             A[maxIndex] = A[index];
             A[index] = t;
             MaxHeapify(A, heapSize, maxIndex);
         }
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
