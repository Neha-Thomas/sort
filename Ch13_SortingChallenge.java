/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch13_sortingchallenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 *
 * @author thoma
 */
public class Ch13_SortingChallenge {

    static ArrayList<Integer> trackRecord= new ArrayList<>();
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        long startTime = System.nanoTime();
        PrintWriter writer = new PrintWriter("C:\\Users\\thoma\\Documents\\NetBeansProjects\\sortedList.txt");
        writer.print("");
        writer.close();
        File f = new File("C:\\Users\\thoma\\Documents\\NetBeansProjects\\random1.txt"); 
        BufferedReader b = new BufferedReader(new FileReader(f));
        String readLine=b.readLine();
        while(readLine !=null){
            systemConvert(readLine);
            readLine=b.readLine();
        }
        int[]sortList=new int[trackRecord.size()];
        for (int i = 0; i < trackRecord.size(); i++) {
            sortList[i]=trackRecord.get(i);
        }
        
        BubbleSort sortData=new BubbleSort(); //counting sort initilization 
        //RadixSort sortData=new RadixSort(); //radix sort initilization
        //MergeSort sortData=new MergeSort(); //radix sort initilization
       //  SelectionSort sortData=new SelectionSort(); //radix sort initilization
       // int[] sortedListsort = new int[trackRecord.size()];
       // sortedListsort= sortData.sort(sortList,78); //counting sort, sort method call 
        //  sortData.sortAscending(sortList); //selection sort, sort method call 
        sortData.bubbleSort(sortList);
           //sortData.quickSort(sortList,0,100000); //radix sort, sort method call 
        Writer wr = new FileWriter("C:\\Users\\thoma\\Documents\\NetBeansProjects\\sortedList.txt");
          for (int i = 0; i < sortList.length; i++) {
            wr.write(new Integer(sortList[i]).toString());
            wr.write(System.getProperty( "line.separator" ));
        }
        wr.close(); 
       // System.out.println(Arrays.toString(sortedListsort));
        //IntStream.range(0, trackRecord.size()).forEach(i -> System.out.println(trackRecord.get(i)));// (takes longer).
        long totalTime = System.nanoTime() - startTime;
        System.out.println("time taken:" + " " + totalTime/1000000 + " " + "milliseconds");

    }

    private static void systemConvert(String readLine) {
        int read=Integer.parseInt(readLine);
        trackRecord.add(read);
    }

    
}
