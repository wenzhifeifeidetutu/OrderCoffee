package com.mycompany.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int numberOfCoffees = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view){
       switch (view.getId()){
           case R.id.increment:
               numberOfCoffees++;
               break;
           case R.id.decrement:
               numberOfCoffees--;
               if (numberOfCoffees <0 ) {
                   numberOfCoffees = 0;
                   Toast.makeText(this,"Prices is not < 0", Toast.LENGTH_SHORT).show();
               }
               break;
           default:
               break;
       }
        display(numberOfCoffees);
        displayPrice(numberOfCoffees *5);
    }

    private void display(int i) {
        TextView textview = (TextView)findViewById(R.id.quantity_text_view);
        textview.setText(i+"");
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}
