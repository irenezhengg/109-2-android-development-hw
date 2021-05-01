package android.example.a108590056_hw8_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView image;
    private int imageLevel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.battery_image);
        image.setImageLevel(imageLevel);
    }

    public void changeBatteryLevel(View view) {
        switch (view.getId()){
            case R.id.button:
                if (imageLevel > 0){
                    imageLevel --;
                    image.setImageLevel(imageLevel);
                }
                break;
            case R.id.button2:
                if (imageLevel < 6){
                    imageLevel ++;
                    image.setImageLevel(imageLevel);
                }
                break;
            default: break;
        }
    }
}
