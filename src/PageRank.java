import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;

/**
 * @author Mohammed
 */

public class PageRank {
    Server server;
    HashMap<Integer, Double> webpageRank;
    final double decay = 0.85;
    final double threshold = 0.00000000000001;


    public PageRank(Server server) {
        this.server = server;
    }

    public void initializRanks() {
        webpageRank = new HashMap<>();
        for (int i = 0; i < server.numberOfWebpages; i++) {
            webpageRank.put(i, 0.25);
        }
    }

    public int getNumberOfInLinks(int n) {
        int numberOfInLinks = 0;
        for (int i = 0; i < server.webpages.length; i++) {
            if (server.webpages[i].contains(n))
                numberOfInLinks++;
        }
        return numberOfInLinks;
    }

    public void updateRanks() {
        double newPageRank = 0, oldPageRank = 0, tempRank = 0;
        double newSurfers = ((1 - decay) / server.numberOfWebpages);
        double[] tempArray = new double[server.numberOfWebpages];
        int tempElement = 0;
        boolean stop = false;
        while (stop != true) {
            for (int i = 0; i < server.numberOfWebpages; i++) {
                for (int j = 0; j < server.webpages[i].size(); j++) {
                    tempElement = server.webpages[i].get(j);
                    if (tempElement != i) {
                        oldPageRank = webpageRank.get(tempElement);
                        tempRank = tempRank + (decay * (oldPageRank / getNumberOfInLinks(tempElement)));
                    }

                }
                newPageRank = tempRank + newSurfers;
                tempArray[i] = newPageRank;
                tempRank = 0;
                if (Math.abs(tempArray[i] - webpageRank.get(i)) < threshold) {
                    stop = true;
                }
            }

            for (int k = 0; k < tempArray.length; k++) {
                webpageRank.replace(k, tempArray[k]);
            }
        }

    }

    public void printRanks() {
        System.out.println("----------------------------------");
        System.out.println("--------PageRank Algorithm--------");
        System.out.println("----------------------------------");
        NumberFormat formatter = new DecimalFormat("0.00000000000");
        String value;
        for (int i = 0; i < webpageRank.size(); i++) {
            value = formatter.format(webpageRank.get(i));
            System.out.println("Webpage[" + i + "]= " + value);
        }
    }
}
