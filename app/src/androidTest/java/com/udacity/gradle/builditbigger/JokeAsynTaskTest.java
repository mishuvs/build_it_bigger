package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import android.util.Log;

import com.example.Jokes;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Vaibhav on 1/7/2018.
 */

@RunWith(AndroidJUnit4.class)
public class JokeAsynTaskTest {
    private String jokeFromBackend;
    private Context context;

    /* how to get the context in unit test
    *  I found this subject in Stack Overflow site */
    @Before
    public void setup() {
        context = InstrumentationRegistry.getContext();
    }

    @Test
    public void getJokeFromBackendTest() throws InterruptedException {
        try {
            jokeFromBackend = new EndpointsAsyncTask().execute(new Pair<Context, String>(context,"useless string")).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        assert TextUtils.isEmpty(jokeFromBackend);
        boolean found = false;
        List<String> jokes = Jokes.getJokesList();
        for (int i = 0; i < jokes.size(); i++){
            if (jokes.get(i).equals(jokeFromBackend)){
                found = true;
                break;
            }
        }
        assertEquals(found , true);
    }
}