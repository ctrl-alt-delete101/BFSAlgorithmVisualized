import java.util.*;

public class Node 
{
    // declaration of station
    public char station;
    //Array of nodes(a single node can have mutiple parents)
    Node[] parent;
    //ArrayList of nodes
    public static ArrayList<Node> nodes = new ArrayList<Node>();
    //Constructor declaration of what a node is
    public static ArrayList<Character> node_connections = new ArrayList<Character>();
    
    public static ArrayList<Character> new_node_connections = new ArrayList<>();
    public Node(char station, Node[] parent) 
    {
        this.station = station;
        this.parent = parent;
    }

    //Gives you parent node(s) of specified node
    public static ArrayList<Character> getParentNode(int index) 
    {
        // Arraylist of characters
        ArrayList<Character> newChars = new ArrayList<Character>();
        // looping through all of the parents of the given index
        for (Node n : nodes.get(index).parent) 
        {
            //adding the statiotn name of the parents into newchars
            newChars.add(n.station);
        }

        // returning the arrayList
        return newChars;
    }

    //gives you child node(s) of specified node
    public static ArrayList<Character> getChildNode(int index)
    {
        //ArrayList of characters
        ArrayList<Character> newChars = new ArrayList<Character>();
    
        //looping through the size of the arrayList
        for(int i = 0; i < nodes.size(); i++)
        {
            //looping through every parent node
            for(Node node : nodes.get(i).parent)
            {
                //checking if the specified node matches up with node
                if(nodes.get(index) == node)
                {
                    //adding child of specified node to newChars
                   newChars.add(nodes.get(i).station);
                }
            }
        }

        //return the arrayList
        return newChars;
    }

    //Gives you the index of the station
    public static int getIndex(char stationName)
    {
        int i = 0; 
        int ans = 0;
        for(Node n: nodes)
        {
            if(stationName == n.station)
            {
                ans = i;
            }
            i++;
        }
        return ans;
    }

    //gets connections of each node
    public static void connections()
    {
        //loops through the size of the node
        for(int i = 0; i < nodes.size(); i++)
        {
            //adds alls the children of i to node_connections
            node_connections.addAll(getChildNode(i));
        }

        // loops through every character in node_connections
        for(char children : node_connections)
        {
            //loops through the parents(if there are multiple) of the child 
            for(char parent : getParentNode(getIndex(children)))
            {
                //adds parent to new_node_connections
                new_node_connections.add(parent);
                //adds children to new_node_connections
                new_node_connections.add(children);
            }

        }
    }

}