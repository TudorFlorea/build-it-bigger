package com.andev.tudor.javajoker;

import java.util.ArrayList;
import java.util.Random;

public class JavaJoker {

    private ArrayList<String> mJokes;
    private Random randomGenerator;

    public JavaJoker() {

        mJokes = new ArrayList<>();

        mJokes.add("Some people, when confronted with a problem, think, 'I know, I'll use threads' - and then two they hav erpoblesms.");
        mJokes.add("Try moving some of your processing client side; it should reduce your latency.");
        mJokes.add("A programmer is told to \"go to hell\", he finds the worst part of that statement is the \"go to\"");
        mJokes.add("Q: How many programmers does it take to screw in a light bulb? A: None. It's a hardware problem.");
        mJokes.add("The IT guy says, \"First we should all try getting out of the car, shutting all the doors, then getting back in again.\"");
        mJokes.add("A programmer puts two glasses on his bedside table before going to sleep. A full one, in case he gets thirsty, and an empty one, in case he doesn’t.");
        mJokes.add("Java and C were telling jokes. It was C's turn, so he writes something on the wall, points to it and says \"Do you get the reference?\" But Java didn't.");

        randomGenerator = new Random();

    }

    public String getJoke() {

        int jokeIndex = randomGenerator.nextInt(mJokes.size());

        return mJokes.get(jokeIndex);
    }

}
