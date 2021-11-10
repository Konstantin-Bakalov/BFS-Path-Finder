import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Frame.startButton) {
            Frame.draw = false;

            Graph g = new Graph();
            g.setNodes();
            g.setAdj();
            g.addAllEdges();
            g.bfs(0);
            Node n = g.path(899);
            if(n != g.getNode(0)) {
                Frame.changeLabelTextToNoPath();
            }
            else g.printTrace(899);
        }
    }
}