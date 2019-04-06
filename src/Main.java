import java.util.*;

/**
 * @author Mohammed
 */

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int webpages, choice;
        draw();

        System.out.print("Enter number of webpages: ");
        webpages = input.nextInt();

        System.out.println("1) Graph Enumeration\n2) PageRank Algorithm");
        choice = input.nextInt();

        switch (choice) {
            case 1:
                long before = System.currentTimeMillis();
                NonIsomorphic nonIsomorphic = new NonIsomorphic(webpages);
                System.out.print("\nNon-Isomorphic graphs of " + webpages + " vertices = "
                        + nonIsomorphic.getNumberOfNonIsomorphic());
                long after = System.currentTimeMillis();
                System.out.println("\nCalculation Completed on: " + (after - before) + "ms.");
                break;

            case 2:
                before = System.currentTimeMillis();
                Server server = new Server(webpages);

                createGraph(server);
                server.printLinks();

                PageRank pageRank = new PageRank(server);
                pageRank.initializRanks();
                pageRank.updateRanks();
                pageRank.printRanks();

                after = System.currentTimeMillis();
                System.out.println("\nPageRank Algorithm Completed on: " + (after - before) + "ms.");
                break;

            default:
                System.out.println("Invalid choice !");
        }


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
    public static void createGraphMul(Server server) {
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
    }

    //Test Algorithm on Project Example
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

    public static void draw() {
        System.out.println("\n" +
                "  ____                  ____             _         _    _                  _ _   _               \n" +
                " |  _ \\ __ _  __ _  ___|  _ \\ __ _ _ __ | | __    / \\  | | __ _  ___  _ __(_) |_| |__  _ __ ___  \n" +
                " | |_) / _` |/ _` |/ _ \\ |_) / _` | '_ \\| |/ /   / _ \\ | |/ _` |/ _ \\| '__| | __| '_ \\| '_ ` _ \\ \n" +
                " |  __/ (_| | (_| |  __/  _ < (_| | | | |   <   / ___ \\| | (_| | (_) | |  | | |_| | | | | | | | |\n" +
                " |_|   \\__,_|\\__, |\\___|_| \\_\\__,_|_| |_|_|\\_\\ /_/   \\_\\_|\\__, |\\___/|_|  |_|\\__|_| |_|_| |_| |_| v1.0\n" +
                "             |___/                                        |___/                                  \n");
    }


}

