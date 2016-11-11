// Steven Hernandez.
// Assignment 3.

import java.io.*; // imported for testing
import java.util.*;

public class cmsc401 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);

        // pass `file=true` to pull in data from a file instead of inputting the values by hand.
        if (args.length > 0 && args[0].equals("file=true")) {
            File file = new File("example_input.txt");
            in = new Scanner(file);
        }

        int sizeS = in.nextInt();
        int sizeW = in.nextInt();

        // locations of sentence ends
        int[] S = new int[sizeS];

        // location of words
        int[] W = new int[sizeW];

        for (int i = 0; i < sizeS; i++) {
            S[i] = in.nextInt();
        }

        for (int i = 0; i < sizeW; i++) {
            W[i] = in.nextInt();
        }

        // build the tree
        RedBlackTree tree = new RedBlackTree();

        for (int S_value : S) {
            tree.insert(S_value);
        }

        // start actual searching here
        ArrayList<int[]> sentences = new ArrayList<int[]>();

        for (int W_value : W) {
            sentences.add(tree.findRange(W_value));
        }
        
        // Now just print out the values
        // he had mentioned that this part doesn't matter so much
        // we can repeatedly output the same sentences (if it contains the word multiple times),
        // though the project description doesn't mention what we should do in those cases.
        System.out.println(sentences.size());

        for (int[] bounds : sentences) {
            System.out.println(bounds[0] + " " + bounds[1]);
        }
    }
}
