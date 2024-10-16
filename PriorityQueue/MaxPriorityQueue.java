package PriorityQueue;

import java.util.Dictionary;
import java.util.Hashtable;

public class MaxPriorityQueue {
    private Task[] Tasks;
    private Dictionary<String, Integer> TaskMap = new Hashtable<String,Integer>();
    private int taskCount;

    public MaxPriorityQueue()
    {
        Tasks = new Task[5];
        taskCount = 0;
    }

    public Boolean IsEmpty()
    {
        return taskCount < 1;
    }

    public void UpdatePriority(String Name, int priority)
    {
        int index = TaskMap.get(Name);
        if(Tasks[index].Priority == priority)
        {
            return;
        }
        else if(priority > Tasks[index].Priority)
        {
            Tasks[index].Priority = priority;
            Maxify(Tasks[index]);
        }
        else
        {
            Tasks[index].Priority = priority;
            MaxHeapify(Tasks, taskCount, index);
        }
    }

    public void DecreasePriority()
    {

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
        TaskMap.put(task.Name, task.Index);
        taskCount++;
        Maxify(task);
    }

    public Task Dequeue()
    {
        Task task = Tasks[0];
        Tasks[0] = Tasks[taskCount-1];
        Tasks[0].Index = 0;
        TaskMap.put(Tasks[0].Name, 0);
        taskCount--;
        MaxHeapify(Tasks, taskCount, 0);
        return task;
    }

     private void Maxify(Task task)
     {
        //bottom up
        int i = task.Index;
        int j = Parent(i);
        while (i > 0 && Tasks[j].Priority < Tasks[i].Priority) 
        {
            Task tmp = Tasks[i];
            Tasks[i] = Tasks[j];
            Tasks[i].Index = i;
            Tasks[j] = tmp;
            Tasks[j].Index = j;
            TaskMap.put(Tasks[i].Name, i);
            TaskMap.put(Tasks[j].Name, j);
            i = j;
            j = Parent(i);
        }
     }

     private int Parent(int i)
     {
         return (int)Math.floor(i/2);
     }
 
     private void MaxHeapify(Task[] A, int heapSize, int index)
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
             A[index].Index = index;
             A[maxIndex].Index = maxIndex;
             TaskMap.put(A[index].Name, index);
             TaskMap.put(A[maxIndex].Name, maxIndex);
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
