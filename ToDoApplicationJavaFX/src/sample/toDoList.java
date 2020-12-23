package sample;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class toDoList
{
    // Field
    Map<Integer, List<Task>> toDoMap;


    // Constructor
    public toDoList( )
    {
        this.toDoMap = new TreeMap<Integer, List<Task>>();
    }

    public toDoList(  Map<Integer, List<Task>> toDoMap )
    {
        this.toDoMap = toDoMap;
    }

    // Methods
    // Setters and getters
}
