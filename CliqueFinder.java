import java.io.FileNotFoundException;

public class CliqueFinder {
    public static void main(String[] args) throws FileNotFoundException {
        //String filePath = "C:\\Users\\haque1\\IdeaProjects\\Hello\\out\\production\\Hello\\in.txt";
        String filePath = "in.txt";
        DenseGraph A = new DenseGraph(filePath);
        A.clique3();
        System.out.println();
        //A.PrintDataStructure();
        System.out.println();
        System.out.println();
        //A.clique3();
        A.clique4();
        //A.printEven();
        //A.printOdd();
        System.out.println();
        A.printOddEven();
        A.PrintDataStructure();

    }

}
