package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Jokes {

    private static String[] jokes = {"Joke 1", "Joke 2", "Joke 3", "Joke 4", "Joke 5"};
    private static ArrayList<String> jokesList = new ArrayList<String>(Arrays.asList(jokes));

    public static String getJoke() {
        int i = (int) (Math.random() * 5);
        return jokesList.get(i);
    }

    public static ArrayList<String> getJokesList(){
        return jokesList;
    }
}
