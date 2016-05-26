package com.crooks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Post> parseFile(String fileName) throws FileNotFoundException {
        ArrayList<Post> posts = new ArrayList<Post>();
        File f = new File(fileName);
        Scanner fileScanner = new Scanner(f);
        while  (fileScanner.hasNext()){
            String line = fileScanner.nextLine(); // store each line into a variable
            String[] columns = line.split("\\|"); //split the line into an array of columns
            System.out.println( " ");
            Post post = new Post(Integer.valueOf(columns[0]),columns[1],columns[2]);  //Create Class object with freshly seperated variables
            posts.add(post);
        }
        return posts;
    }

    public static void printPosts(ArrayList<Post> posts, int currentpost){
        //print out replies to the current post
        int postID = 0;
        for (Post post : posts){
            if (post.replyID== currentpost){
                System.out.printf("[%s] %s by %s.\n",postID,post.text,post.author);
            }
            postID++;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        //Parse file
        ArrayList<Post> posts = parseFile("posts.txt");

        //Start Main Loop
        Scanner consoleScanner = new Scanner(System.in);
        int currentpost = -1;
        while (true) {

            printPosts(posts, currentpost);
            // ask for new ID
            System.out.println("Type id you want to see replies to: ");
            currentpost = Integer.valueOf(consoleScanner.nextLine());
        }



    }
}
