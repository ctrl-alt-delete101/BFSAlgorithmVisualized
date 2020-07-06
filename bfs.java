import java.util.*;
import java.io.*;

public class bfs 
{
    // start and goal variables
    public static char start;
    public static char goal;
    
    public static ArrayList<Character> solve()
    {
        // explored keeps of explored nodes
        ArrayList<Character> explored = new ArrayList<Character>();
        // keeps track of all paths to be checked
        ArrayList<ArrayList<Character>> queue = new ArrayList<>();
        ArrayList<Character> st = new ArrayList<>();
        ArrayList<Character> pt = new ArrayList<Character>();

        st.add(start);
        queue.add(st);

        //checking if start is equal to the goal
        if(start == goal)
        {
            System.out.println("Cannot do that :/ ");
        }
        
        //keeps looping until all possible paths have been checked
        while(queue.size() > 0)
        {
            //pop the first path from the queue
            ArrayList<Character> path = new ArrayList<>();

            path = queue.remove(0);
            
            //get the last node from the path
            char node = path.get(path.size()-1);
            
            //checks to make sure that the node isn't already explored
            if (!(explored.contains(node)))
            {
                ArrayList<Character> neigbours = Node.getChildNode(Node.getIndex(node));
                //go through all neighbour nodes
                //construct a new path
                //push it into the queue
                for(char neighbour : neigbours)
                {
                    ArrayList<Character> new_path = (ArrayList<Character>) deepCopy(path);
                    new_path.add(neighbour);
                    queue.add(new_path);
                    
                    //return path if neigbour is goal
                    if(neighbour == goal)
                    {
                        pt =  (new_path);
                        return pt;
                    }
                    
                }
                //mark node as explored
                explored.add(node);
            }
        }
        return pt;
    }

    // makes a deepcopy to given object:  credit --> https://www.journaldev.com/17129/java-deep-copy-object
    public static Object deepCopy(Object object) 
    {
        try 
        {
          ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
          ObjectOutputStream outputStrm = new ObjectOutputStream(outputStream);
          outputStrm.writeObject(object);
          ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
          ObjectInputStream objInputStream = new ObjectInputStream(inputStream);
          return objInputStream.readObject();
        }
        catch (Exception e) 
        {
          e.printStackTrace();
          return null;
        }
    }
}