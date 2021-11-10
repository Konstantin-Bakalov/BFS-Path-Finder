import java.awt.*;

public class Node {
    int d;
    int number;
    Node parent;
    Color color;

    Node(int number) {
        d = Integer.MAX_VALUE;
        this.number = number;
        parent = null;
        color = Color.WHITE;
    }
}