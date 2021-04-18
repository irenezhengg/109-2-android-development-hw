package android.example.a107590061_hw7_2;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private final LinkedList<String> mRecipeNames = new LinkedList<>();
    private final LinkedList<String> mRecipeDesc = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readFile(getResources().openRawResource(R.raw.recipe_names), mRecipeNames);
        readFile(getResources().openRawResource(R.raw.recipe_desc), mRecipeDesc);
        RecyclerView mRecyclerView = findViewById(R.id.recycle_view);
        RecipeListAdapter mAdapter = new RecipeListAdapter(this, mRecipeNames, mRecipeDesc);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void readFile(InputStream ins, LinkedList<String> list) {
        String contents = null;
        String [] contents_array = null;
        int i;
        try{
            contents = IOUtils.toString(ins);
            System.out.println(contents);
            IOUtils.closeQuietly(ins);
        }
        catch (Exception e){
            Log.e(TAG, Log.getStackTraceString(e));
        }

        if (contents != null) {
            contents_array = contents.split("\\r?\\n");
        }
        if (contents_array != null) {
            for (i = 0; i < contents_array.length ; i++){
                list.add(i, contents_array[i]);
                Log.d("ARRAY CONTENTS", contents_array[i]);

            }
        }
    }
}
