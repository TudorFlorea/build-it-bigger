package com.udacity.gradle.builditbigger;


import android.content.Context;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;
import java.util.concurrent.TimeUnit;

@RunWith(AndroidJUnit4.class)
public class jokeAsyncTaskTest {

    @Mock
    Context context;
    private EndpointAsyncTask task;
    private String result;

    @Test
    public void testAsyncTask() {
        task = new  EndpointAsyncTask();

        try {
            task.execute(context);
            result = task.get(15, TimeUnit.SECONDS);
            assertNotNull(result);
        } catch (Exception e) {
            fail("Timed out!");
        }

    }


}
