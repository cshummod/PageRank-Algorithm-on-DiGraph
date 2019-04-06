
/**
 * @author Abdullah
 */

public class NonIsomorphic {
    private int numberOfNonIsomorphic;

    public NonIsomorphic(int n) {
        numberOfNonIsomorphic = 0;
        printInEdges(n);
    }

    public void printadjacencyList(int G[], int n, int j) {
        System.out.println("Graph Number " + j);
        for (int i = 0; i < n; i++) {
            System.out.print(G[i] + " E" + " -> ");
            System.out.print("[v" + i + "]");

            System.out.println();

        }

    }

    public void printInEdges(int n) {
        int[] G = new int[n];
        int k = 0;
        G[k] = n;
        int j = 0;

        while (true) {

            if (G[0] != n) {
                printadjacencyList(G, k + 1, j);
            }

            int rem_val = 0;
            while (k >= 0 && G[k] == 1) {
                rem_val += G[k];
                k--;
            }

            if (k < 0) return;

            G[k]--;
            rem_val++;


            while (rem_val > G[k]) {
                G[k + 1] = G[k];
                rem_val = rem_val - G[k];
                k++;
            }

            G[k + 1] = rem_val;
            k++;
            System.out.println();
            j++;
            numberOfNonIsomorphic++;
        }


    }

    public int getNumberOfNonIsomorphic() {
        return numberOfNonIsomorphic;
    }

}