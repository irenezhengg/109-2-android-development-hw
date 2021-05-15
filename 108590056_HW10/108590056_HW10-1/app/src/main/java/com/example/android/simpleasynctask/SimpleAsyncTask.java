/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.simpleasynctask;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void, Integer, String> {

    // The TextView where we will show results
    private WeakReference<TextView> mTextView;
    private WeakReference<ProgressBar> mProgressBar;
    private static final int CHUNK_SIZE = 5;

    // Constructor that provides a reference to the TextView from the MainActivity
    SimpleAsyncTask(TextView tv, ProgressBar bar) {

        mTextView = new WeakReference<>(tv);
        mProgressBar = new WeakReference<>(bar);
    }

    @Override
    protected String doInBackground(Void... voids) {

        // Generate a random number between 0 and 10.
        Random r = new Random();
        int n = r.nextInt(11);

        // Make the task take long enough that we have
        // time to rotate the phone while it is running.
        int s = n * 400;
        int chunkSize = s / CHUNK_SIZE;


        // Sleep for the random amount of time.
        for (int i = 0; i < CHUNK_SIZE; i++) {
            try {
                Thread.sleep(chunkSize);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(((i+1)*100)/CHUNK_SIZE);
        }

        // Return a String result.
        return "It's been ok for " + s + " milliseconds; and now, everything is a chaos";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        mProgressBar.get().setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(String result) {
        mTextView.get().setText(result);
    }
}
