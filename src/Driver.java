import java.util.ArrayList;

public class Driver {
    public static ArrayList<Character> ans;
    
    public static void main(String[] args) {
        // driver code

        Node.nodes.add(new Node('A', new Node[] {}));
        Node.nodes.add(new Node('B', new Node[] { Node.nodes.get(0) }));
        Node.nodes.add(new Node('C', new Node[] { Node.nodes.get(0) }));
        Node.nodes.add(new Node('D', new Node[] { Node.nodes.get(1) }));
        Node.nodes.add(new Node('E', new Node[] { Node.nodes.get(1) }));
        Node.nodes.add(new Node('F', new Node[] { Node.nodes.get(2) }));
        Node.nodes.add(new Node('G', new Node[] { Node.nodes.get(2) }));
        Node.nodes.add(new Node('H', new Node[] { Node.nodes.get(3) }));
        Node.nodes.add(new Node('I', new Node[] { Node.nodes.get(7), Node.nodes.get(4), Node.nodes.get(6) }));

        bfs.start = 'A';
        bfs.goal = 'I';

        Node.connections();
        ans = bfs.solve();
        System.out.println(ans);

        new Pyramid();

    }
}