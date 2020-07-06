import javax.swing.*;
import java.awt.*;
import java.util.*;
public class Pyramid
{
    public static ArrayList<Character> chars = new ArrayList<Character>();
    private static JFrame frame = new JFrame("BFS ALGORITHM");
    private static JPanel panel = new JPanel();
    private static JLabel title = new JLabel("BFS ALGORITHM VISUALIZED");
    private static JLabel info = new JLabel("The red lines are the shortest path");
    private static String ans = "";
    // This is where the actual pyramid structure is made inside the constructor
    public Pyramid()
    {
        //setting panel layout to null
        panel.setLayout(null);

        //gets all the node stations and puts that in chars
        getChar();

        // defining loop variables
        int i,j,count = 0;
        
        //looping through the size of the chars array
        for(i = 0; i < chars.size(); i++)
        {
            //loops through i
            for(j = 0; j < i; j++)
            {
                //checks if count is less than the size of chars
                if(count < chars.size())
                {
                    //creating a new jLabel and casting chars.get(count) to a string
                    JLabel label = new JLabel(Character.toString(chars.get(count)));
                    //setting the bounds of the label 
                    label.setBounds((j*50) + 210, (i*50) - 170, 600,600);
                    // settting font and label size
                    label.setFont(new Font("Arial", Font.BOLD, 20));
                    //adding label to frame
                    frame.add(label);
                    count++;
                }
            }
        }

        //looping through every letter in Driver.ans
        for(char letter: Driver.ans)
        {
            //casting letter to ans and adding a space to it 
            ans = ans + Character.toString(letter) + " ";
        }

        //makes a label that displays the answer
        JLabel answer = new JLabel("Shortest path: " + ans);

        //setting bounds of answer
        answer.setBounds(150,400,500,100);
        //setting the font and size of answer
        answer.setFont(new Font("Arial", Font.ITALIC, 20));


        //creating a shape object called s
        Shapes s = new Shapes();
        //setting bounds of title
        title.setBounds(120,20,500,100);
        //setting font and size of title
        title.setFont(new Font("Arial", Font.ITALIC, 20));
        //setting bounds of info
        info.setBounds(150,50,500,100);
        //setting font and size of info
        info.setFont(new Font("Arial", Font.ITALIC, 15));
        //adding title,info, answer and s to the frame
        frame.add(answer);
        frame.add(title);
        frame.add(info);
        frame.add(s);
        //setting the panel background to white
        panel.setBackground(Color.WHITE);
        //setting border of the panel
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //making the frame not resizable
        frame.setResizable(false);
        //setting title of the frame
        frame.setTitle("BFS ALGORITHM");
        //setting the size of the frame
        frame.setSize(600,600);
        //making the frame visible
        frame.setVisible(true);
    } 
    
    //return an arraylist of all the station names
    private static ArrayList<Character> getChar()
    {
        //looping through the nodes arrayList
        for(Node n : Node.nodes)
        {
            //adding the station to chars
            chars.add(n.station);
        }
        //returning arrayList
        return chars;
    }
}