import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class DenseGraph {
    public ArrayList<ArrayList<Integer>> adjacencyMatrix;
    public ArrayList<ArrayList<ArrayList<Integer>>> cliqueOdd;
    public ArrayList<ArrayList<ArrayList<Integer>>> cliqueEven;
    public int n;

    public DenseGraph(String inputFilePath) throws FileNotFoundException {
        adjacencyMatrix = new ArrayList<ArrayList<Integer>>();

        // create file object
        File file = new File(inputFilePath);

        Scanner scannedFile = new Scanner(file);

        // skip the first line since it contains the vertex number
        //scannedFile.nextLine();

        while (scannedFile.hasNextLine()) {
            String currentLine = scannedFile.nextLine();
            ArrayList<Integer> temp = new ArrayList<>();

            for (int i = 0; i < currentLine.length(); i++)
                temp.add((currentLine.charAt(i) - '0'));
            adjacencyMatrix.add(temp);
        }

        // close the scanner
        scannedFile.close();
        n = adjacencyMatrix.size();

        cliqueEven= new ArrayList<ArrayList<ArrayList<Integer>>>();
        cliqueOdd= new ArrayList<ArrayList<ArrayList<Integer>>>();
        for(int i = 0; i <n; ++i){
            cliqueEven.add(new ArrayList<ArrayList<Integer>>());
            cliqueOdd.add(new ArrayList<ArrayList<Integer>>());
            for(int j = 0; j <n; ++j){
                cliqueEven.get(i).add(new ArrayList<Integer>());
                cliqueOdd.get(i).add(new ArrayList<Integer>());
                for(int k = 0; k < n; ++k){
                    cliqueEven.get(i).get(j).add(0);
                    cliqueOdd.get(i).get(j).add(0);
                }
            }
        }
    }


    public boolean isNeighbor(int i, int j) {
        // returns "true" if vertex i and j are neighbors, otherwise, returns "false".
        int isConnected = adjacencyMatrix.get(i).get(j);
        if (isConnected == 1)
            return true;
        else
            return false;

    }


    public ArrayList<Integer> neighborList(int i) {
        // returns the neighbors of vertex i as an ArrayList.
        ArrayList<Integer> neighborsList = new ArrayList<>();
        for (int j = 0; j < adjacencyMatrix.get(i).size(); j++) {
            if (adjacencyMatrix.get(i).get(j) == 1)
                neighborsList.add(j);
        }
        return neighborsList;
    }

    public void PrintDataStructure(){
        for (int i = 0; i < adjacencyMatrix.size(); i++) {
            for (int j = 0; j < adjacencyMatrix.get(i).size(); j++) {
                System.out.print(adjacencyMatrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }


    public void printOdd(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                System.out.println(i+" "+j);
                for(int k = 0; k< n; ++k) {
                    System.out.print(cliqueOdd.get(i).get(j).get(k)+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    public void printEven(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                System.out.println(i+" "+j);
                for(int k = 0; k< n; ++k) {
                    System.out.print(cliqueEven.get(i).get(j).get(k)+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public void printOddEven(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                System.out.println(i+" "+j);
                for(int k = 0; k< n; ++k) {
                    System.out.print(cliqueOdd.get(i).get(j).get(k)+" ");
                }
                System.out.println();
                for(int k = 0; k< n; ++k) {
                    System.out.print(cliqueEven.get(i).get(j).get(k)+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }


    public void clique3(){
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                if(adjacencyMatrix.get(i).get(j) == 1){
                    for(int k = 0; k < n; ++k){
                        if(i != k && j != k && adjacencyMatrix.get(i).get(k) == 1 && adjacencyMatrix.get(j).get(k) == 1){
                            cliqueOdd.get(i).get(j).add(k, 1);
                        }
                    }
                }
            }
        }

    }

    public void clique4(){
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                if(adjacencyMatrix.get(i).get(j) == 1){

                    for(int k = 0; k < n; ++k){
                        if(k!=i && k!=j && cliqueOdd.get(i).get(j).get(k) == 1 && cliqueEven.get(i).get(j).get(k) == 0){

                            for(int l = 0; l < n; ++l){
                                if(l!=k && l!=i && l!=j && cliqueOdd.get(i).get(j).get(l) == 1 &&  adjacencyMatrix.get(k).get(l) == 1){
                                    cliqueEven.get(i).get(j).add(k, 1);
                                    break;
                                }

                            }
                        }

                    }

                }
            }
        }
    }


}
