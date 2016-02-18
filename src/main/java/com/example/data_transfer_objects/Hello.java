package com.example.data_transfer_objects;

/**
 * A simple POJO used as a data transfer object.
 *
 * Created by mohamnag on 18/02/16.
 */
public class Hello {

    private String theWord = "Hello, ";

    public String getTheWord() {
        return theWord;
    }

    public void setTheWord(String theWord) {
        this.theWord = theWord;
    }

    @Override
    public String toString() {
        return theWord;
    }
}
