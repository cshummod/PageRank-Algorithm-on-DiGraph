import java.util.LinkedList;

/**
 * @author Mohammed
 */

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


    public void addLink(int src, int dest) {
        this.webpages[src].add(dest);
    }

    public void printLinks() {
        System.out.println("----------------------------------");
        System.out.println("-----------Server Graph-----------");
        System.out.println("----------------------------------");
        for (int i = 0; i < this.numberOfWebpages; i++) {
            System.out.print("Webpage[" + i + "]");
            for (Integer webpageLinks : this.webpages[i]) {
                System.out.print("->" + webpageLinks);
            }
            System.out.println();
        }
    }


}
