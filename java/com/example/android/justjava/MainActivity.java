/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p>
 * package com.example.android.justjava;
 */
package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;
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



    /**
     * MAIN LINE
     * This method is called when the order button is clicked.
     *
     */
    public void submitOrder(View view) {
        int price = calculatePrice();  // taking the output of this method and passing into next method below
        displayMessage(createOrderSummary(price));
        // above is shorthand for ...
       // String priceMessage = createOrderSummary(price);
        //displayMessage(priceMessage);
    }





    /**
     * gives a summary of the order
     * @param price this is the price fed in from previous method
     *  returns text summary
     */
    private String createOrderSummary(int price) {
        String priceMessage = "Name: Adam McMurchie";
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
        orderSummaryTextView.setText(message);
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     ********** redundant***********
     * This method displays the given price on the screen.

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }


     */

}