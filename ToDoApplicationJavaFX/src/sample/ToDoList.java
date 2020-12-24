package sample;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ToDoList
{
    // Field
    List<Task> toDoList;

    // Constructor
    public ToDoList( )
    {
        this.toDoList = new LinkedList<Task>();
    }

    public ToDoList( List<Task> toDoList )
    {
        this.toDoList = toDoList;
    }

    // Methods
    // Setters and getters
    public List<Task> getToDoList()
    {
        return toDoList;
    }

    public void setToDoList(List<Task> toDoList)
    {
        this.toDoList = toDoList;
    }

    @Override
    public String toString()
    {
        return "ToDoList{" +
                "toDoList=" + toDoList +
                '}';
    }
}
