import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        int webpages = 5;
        Server server = new Server(webpages);

        createGraph(server);
        printGraph(server);

    }

    public static void createGraph(Server server) {
        Random random = new Random();
        int r, size = server.numberOfWebpages;
        boolean check = false;
        Set<Integer> tempLinks = new HashSet<Integer>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                r = random.nextInt(size);
                if (!tempLinks.contains(r)) {
                    tempLinks.add(r);
                    check = true;
                }
                if (r != i && check == true && !server.webpages[i].contains(r)) {
                    server.addEdge(i, r);
                    check = false;
                }
            }
            tempLinks.clear();
        }

    }

    public static void printGraph(Server server) {
        for (int i = 0; i < server.numberOfWebpages; i++) {
            System.out.print("[v" + i + "]");
            for (Integer webpageLinks : server.webpages[i]) {
                System.out.print(" -> " + webpageLinks);
            }
            System.out.println("");
        }
    }


}
