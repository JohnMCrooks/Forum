package com.crooks;

/**
 * Created by johncrooks on 5/26/16.
 */
public class Post {
    int replyID;
    String author;
    String text;

    public Post(int replyID, String author, String text) {
        this.replyID = replyID;
        this.author = author;
        this.text = text;
    }

    public int getReplyID() {
        return replyID;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }
}
