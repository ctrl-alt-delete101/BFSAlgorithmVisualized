import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class Shapes extends JComponent
{
    //creating an ArrayList within an ArrayList 
    public static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    //creating a subarray of arr
    public static ArrayList<Integer> subArr = new ArrayList<>();

    //creating another arrayList for storing the coordinates
    public static ArrayList<Integer> coordinates = new ArrayList<Integer>();
    
    private static int x = 0;
    private static int y = 0;

    public void paint(Graphics g)
    {
        //creating counter
        int count = 0;
        //looping through the size of the chars ArrayList
        for(int i = 0; i < Pyramid.chars.size(); i++)
        {
            //looping through i
            for(int j = 0; j < i; j++)
            {
                //checking if count is less than the size of chars
                if(count < Pyramid.chars.size())
                {
                    //adding the the positioning of the oval to coordinates
                    coordinates.add(((j * 50) + 195) + 20);
                    coordinates.add(((i * 50) + 110) + 20);
                    //drawing the oval 
                    g.drawOval((j * 50) + 195, (i * 50) + 110, 40, 40);
                    count++;
                }
            }
        }   

        //creating an ArrayList that stores all the conntected nodes
        ArrayList<ArrayList<Integer>> connections = new ArrayList<>();
        //creating an ArrayList that stores the answer of the connected node 
        ArrayList<ArrayList<Integer>> ans_connection = new ArrayList<>();

        //looping through every character in new_node_connections 
        for(char letter : Node.new_node_connections)
        {
            //getting the coordinates of letter and adding that to connections
            connections.add(getCoordinates(letter));
        }

        //looping through the size of new_node_connections
        for(int i = 1; i < Node.new_node_connections.size(); i++)
        {
            //drawing all the lines that are connected by each node
            g.drawLine(coordinates.get(connections.get(x).get(y)),coordinates.get(connections.get(x).get(y+1)),coordinates.get(connections.get(x+1).get(y)),coordinates.get(connections.get(x+1).get(y+1)));
            x++;
        }

        //resetting the variables back to 0
        x = 0;
        y = 0;

        //looping through the answer 
        for(char letter : Driver.ans)
        {
            //getting the coordinates of each letter in answer and appending it to ans_connection
            ans_connection.add(getCoordinates(letter));
        }
        
        //looping through the size of Driver.ans
        for(int i = 1; i < Driver.ans.size(); i++)
        {
            //setting the color of the lines to red to distinguish what the answer connections are
            g.setColor(Color.RED);
            //drawing the connection lines
            g.drawLine(coordinates.get(ans_connection.get(x).get(y)),coordinates.get(ans_connection.get(x).get(y+1)),coordinates.get(ans_connection.get(x+1).get(y)),coordinates.get(ans_connection.get(x+1).get(y+1)));
            x++;
        }
    }  
    
    //gets coordinates of a particular station
    /*
    -----Basic principle of what this function does----
    converts [0,1,2,3,4,5,6,7,8 .....] to
    [0,1],[2,3],[4,5],[6,7],[8,9]....
    so when we call a specific character, it will return an array acting as coordinates
    */
    public ArrayList<Integer> getCoordinates(char stationame)
    {
        //loops through the size of coordinates
        for (int i = 0; i < coordinates.size(); i++) 
        {
            //adds i to subArr
            subArr.add(i);
            //checks if subArr reaches 2
            if (subArr.size() == 2) 
            {
                //adds subArr to arr
                arr.add(subArr);
                //resets subArr back to an empty arrayList
                subArr = new ArrayList<>();
            }
        }
        //returns the cooridnates 
        return (arr.get(Node.getIndex(stationame)));
    }
} 