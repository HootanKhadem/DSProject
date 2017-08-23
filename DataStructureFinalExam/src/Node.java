import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Nader on 8/17/2017.
 */
public class Node
{
    private Course course;
    private ArrayList<Node> adjacencyList;

    public Node(Course course)
    {
        adjacencyList = new ArrayList<>();
        this.course = course;
    }


    public ArrayList<Node> getAdjacencyList()
    {
        return adjacencyList;
    }

    public void setAdjacencyList(ArrayList<Node> adjacencyList)
    {
        this.adjacencyList = adjacencyList;
    }

    public Course getCourse()
    {
        return course;
    }

    public void setCourse(Course course)
    {
        this.course = course;
    }



}
