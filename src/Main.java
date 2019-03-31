import java.util.*;

public class Main {

    public static void main(String[] args) {
        int before = (int) System.currentTimeMillis();

        int webpages = 1000;
        Server server = new Server(webpages);

        createGraph(server);
        server.printLinks();

        PageRank pageRank = new PageRank(server);
        pageRank.initializRanks();
        pageRank.updateRanks();
        pageRank.printRanks();

        //Project Example
        //testAlg(server);

        int after = (int) System.currentTimeMillis();
        System.out.println("\nCompleted on: " + (after - before) + "ms.");

    }


    //Single Link
    public static void createGraph(Server server) {
        Random random = new Random();
        int r, size = server.numberOfWebpages;
        Set<Integer> tempLinks = new HashSet<Integer>();
        int i = 0;
        while (true) {
            r = random.nextInt(size);
            if (r != i && !tempLinks.contains(r)) {
                tempLinks.add(r);
                server.addLink(i, r);
                i++;
                if (i == size)
                    break;
            }
            tempLinks.clear();
        }

    }


    //Multiple Links
    /*public static void createGraph(Server server) {
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
                    server.addLink(i, r);
                    check = false;
                }
            }
            tempLinks.clear();
        }
    }*/
    private static void testAlg(Server server) {
        server.addLink(0, 1);
        server.addLink(0, 2);
        server.addLink(0, 3);
        server.addLink(1, 0);
        server.addLink(2, 0);
        server.addLink(3, 0);


        server.printLinks();
        PageRank pageRank = new PageRank(server);
        pageRank.initializRanks();
        pageRank.updateRanks();
        pageRank.printRanks();


    }

}

