package PriorityQueue;

public class Task
{
    public String Name;
    public int Index;
    public int Priority;

    public Task(String name)
    {
        Name = name;
        Priority = 1;
    }

    public String toString()
    {
        return String.valueOf(Priority);
    }
}