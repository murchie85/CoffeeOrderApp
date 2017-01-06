/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p>
 * package com.example.android.justjava;
 */
package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import java.text.NumberFormat;

import static com.example.android.justjava.R.id.checkbox;
import static com.example.android.justjava.R.id.quantity_text_view;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity =1;

    /**
     * START UP CODE.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public  boolean onCreateOptionsMenu(Menu menu){
        // inflate the menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * MAIN LINE
     * This method is called when the order button is clicked.
     *
     */
    public void submitOrder(View view) {
        // CHECK TOPPINGS
        CheckBox WhippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = WhippedCreamCheckBox.isChecked();

        CheckBox ChocolateCheckBox = (CheckBox) findViewById(R.id.Chocolate_Checkbox);
        boolean hasChocolate = ChocolateCheckBox.isChecked();
        // PRINT TOPINGS TO LOG
        Log.v("MainActivity","Has Whipped Cream: " + hasWhippedCream);
        Log.v("MainActivity","Has Whipped Cream: " + hasChocolate);

        int price = calculatePrice();  // taking the output of this method and passing into next method below
        displayMessage(createOrderSummary(price, hasWhippedCream, hasChocolate));
        // above is shorthand for ...
       // String priceMessage = createOrderSummary(price);
        //displayMessage(priceMessage);
    }





    /**
     * gives a summary of the order
     * @param price this is the price fed in from previous method
     * @param addWhippedCream this is if the checkbox is ticked or not
     *  returns text summary
     */
    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate) {
        String priceMessage = "Name: Adam McMurchie";
        priceMessage += "\nAdd whipped Cream? " + addWhippedCream;
        priceMessage += "\nAdd Chocolate? " + addChocolate;
        priceMessage = priceMessage + "\nQuantity: " + quantity;
        priceMessage += "\nTotal: " + "£" + price;    // += shorthand for pm = pm
        priceMessage += "\nThank you!";
        return priceMessage;
    }


    /**
     * This method is incrememnts the quantity.
     */
    public void increment(View view) {
        quantity = quantity +1;
        displayQuantity(quantity);
    }

    /**
     * This method decrements the quantity.
     */
    public void decrement(View view) {
        quantity = quantity -1;
        displayQuantity(quantity);

    }


    /**
     * Calculates the price of the order.
     *
     */
    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message); // use ordersumm.. object and call settext method
    }


    /**
     * This method displays the given quantity value on the screen.
     * each line explained
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(quantity_text_view);
        /* what is happening is it finds quantity_text_view and (Textview) just says
            I am a text view. passes it to working storage QuantityTextView that is also declared as
            Textview. The rhs (TextView) is casting it as a text view
         */
        quantityTextView.setText("" + number);  // use quantitytextview object and call set text method
    }




}