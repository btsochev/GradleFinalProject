package com.udacity.gradle.builditbigger;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.InstrumentationTestCase;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest extends InstrumentationTestCase {

    @Before
    public void setUp() throws Exception {
        super.setUp();

        // Injecting the Instrumentation instance is required
        // for your test to run with AndroidJUnitRunner.
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());

    }

    @Test
    public void testSomeAsyncTask() throws Throwable {
        final String[] resultString = new String[1];
        final CountDownLatch signal = new CountDownLatch(1);

        final EndpointsAsyncTask myTask = new EndpointsAsyncTask() {

            @Override
            protected void onPostExecute(String result) {
                resultString[0] = result;
                signal.countDown();
            }
        };

        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                myTask.execute(getInstrumentation().getContext());
            }
        });


        signal.await(15, TimeUnit.SECONDS);

        assertFalse(resultString[0].isEmpty());
    }
}
