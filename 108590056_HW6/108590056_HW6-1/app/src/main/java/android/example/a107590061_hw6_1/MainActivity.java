package android.example.a107590061_hw6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String message = "Toppings: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast (View view){
        select((CheckBox) findViewById(R.id.checkBox),"Chocolate Syrup");
        select((CheckBox) findViewById(R.id.checkBox2),"Sprinkles");
        select((CheckBox) findViewById(R.id.checkBox3),"Crushed Nuts");
        select((CheckBox) findViewById(R.id.checkBox4),"Cherries");
        select((CheckBox) findViewById(R.id.checkBox5),"Oreo Cookies Crumbles");
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void select(CheckBox checkBox , String topping){
        if(checkBox.isChecked()){
            if(!message.contains(topping)){
                message = message + " " + topping;
            }
        }
        else{
            if(message.contains(topping)){
                message = message.replace(" " + topping, " ");
            }
        }
    }




}
