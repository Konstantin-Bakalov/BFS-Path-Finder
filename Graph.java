import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Graph {
    ArrayList<Node> nodes;
    ArrayList<Node>[] adj;

    public void setNodes() {
        nodes = new ArrayList<>();
        for(int i = 0; i < 900; i++) {
            nodes.add(new Node(i));
        }
    }

    public Node getNode(int number) {
        return nodes.get(number);
    }

    public void setAdj() {
        adj = new ArrayList[900];
        for (int i = 0; i < 900; i++) adj[i] = new ArrayList<Node>();
    }

    public void addEdge(Node v, Node w) {
        adj[v.number].add(w);
    }

    public void addAllEdges() {
        for(int i = 0; i < Frame.buttons.length; i++) {
                if(Frame.buttons[i].isEnabled()) {
                    if((i % 30) + 1 < Frame.buttonNumber && Frame.buttons[i + 1].isEnabled())
                        addEdge(nodes.get(i), nodes.get(i + 1));
                    if((i % 30) - 1 >= 0 && Frame.buttons[i - 1].isEnabled())
                        addEdge(nodes.get(i), nodes.get(i - 1));
                    if((i / 30) + 1 < Frame.buttonNumber && Frame.buttons[i + 30].isEnabled())
                        addEdge(nodes.get(i), nodes.get(i + 30));
                    if((i / 30) - 1 >= 0 && Frame.buttons[i - 30].isEnabled())
                        addEdge(nodes.get(i), nodes.get(i - 30));
                }
            }
        }

    public void printAdj() {
        for(int i = 0; i < adj.length; i++) {
            for(int j = 0; j < adj[i].size(); j++) {
                System.out.print(adj[i].get(j).number + " ");
            }
            System.out.println();
        }
    }

    public void printDistances() {
        for(int i = 0; i < nodes.size(); i++) {
            System.out.println("Node " + i + " distance " + nodes.get(i).d);
        }
    }

    public void printTrace(int number) {
        Node n = nodes.get(number);
        while(n != null) {
            Frame.buttons[n.number].setBackground(Frame.green);
            n = n.parent;
        }
    }

    public Node path(int number) {
        Node n = nodes.get(number);
        while(n.parent != null) {
            n = n.parent;
        }
        return n;
    }

    public Node findStartNode(int number) {
        for(int i = 0; i < nodes.size(); i++) {
            if(number == nodes.get(i).number) return nodes.get(i);
        }
        return null;
    }

    public void bfs(int number) {
        Node s = findStartNode(number);
        s.color = Color.GRAY;
        s.d = 0;
        s.parent = null;

        ArrayDeque<Node> Q = new ArrayDeque<>();
        Q.add(s);

        while(!Q.isEmpty()) {
            Node u = Q.poll();
            for(Node v : adj[u.number]) {
                if(v.color == Color.WHITE) {
                    v.color = Color.GRAY;
                    v.d = u.d + 1;
                    v.parent = u;
                    Q.addLast(v);
                }
            }
            u.color = Color.BLACK;
        }
    }
}