package com.crooks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Post> posts = new ArrayList<Post>();

        //Parse file
        File f = new File("posts.txt");
        Scanner fileScanner = new Scanner(f);
        while  (fileScanner.hasNext()){
            String line = fileScanner.nextLine(); // store each line into a variable
            String[] columns = line.split("\\|"); //split the line into an array of columns
            System.out.println( " ");
            Post post = new Post(Integer.valueOf(columns[0]),columns[1],columns[2]);  //Create Class object with freshly seperated variables
            posts.add(post);

        }

        //Start Main Loop
        Scanner consoleScanner = new Scanner(System.in);
        int currentpost = -1;
        while (true) {
            System.out.printf("Current Post: %s \n", currentpost);
            System.out.println("Type id you want to see replies to: ");
            currentpost = Integer.valueOf(consoleScanner.nextLine());
        }



    }
}
