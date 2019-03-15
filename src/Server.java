import java.util.LinkedList;

public class Server {
    int numberOfWebpages;
    LinkedList<Integer> webpages[];

    Server(int numberOfWebpages) {
        this.numberOfWebpages = numberOfWebpages;

        webpages = new LinkedList[numberOfWebpages];

        for (int i = 0; i < numberOfWebpages; i++) {
            webpages[i] = new LinkedList<>();
        }
    }


    public void addEdge(int src, int dest) {
        this.webpages[src].add(dest);
    }

}
