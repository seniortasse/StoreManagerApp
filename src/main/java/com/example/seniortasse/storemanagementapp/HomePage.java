package com.example.seniortasse.storemanagementapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;

public class HomePage extends Activity implements View.OnClickListener{

    /* Declare the buttons "Inventory Check",
     * "Add Inventory" and "Log Out" */
    Button buttonInventoryCheck;
    Button buttonAddInventory;
    Button buttonLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        /*Get references to the widgets*/
        buttonInventoryCheck = findViewById(R.id.buttonInventoryCheck);
        buttonAddInventory = findViewById(R.id.buttonAddInventory);
        buttonLogOut = findViewById(R.id.buttonLogOut);

        //Make buttons listening to clicks
        buttonInventoryCheck.setOnClickListener(this);
        buttonAddInventory.setOnClickListener(this);
        buttonLogOut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        // In we click on "InventoryCheck" button, then...
        // we should land on Inventory Check page
        if (v == buttonInventoryCheck) {
            Intent intentInventoryCheck = new Intent(this, InventoryCheck.class);
            startActivity(intentInventoryCheck);
        }
        // In we click on "AddInventory" button, then...
        // we should land on Add Inventory page
        else if (v == buttonAddInventory) {
            Intent intentAddInventory = new Intent(this, AddInventory.class);
            startActivity(intentAddInventory);
        }
        // In we click on "InventoryCheck" button, then...
        // we should land on Inventory Check page
        else if (v == buttonLogOut) {
            Intent intentWelcomeScreen = new Intent(this, WelcomeScreen.class);
            startActivity(intentWelcomeScreen);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

            // Create navigation menu
            getMenuInflater().inflate(R.menu.navigationmenu,menu);

            return super.onCreateOptionsMenu(menu);

        }

    // When a menu option is selected, we navigate to other pages of the applicaion
    public boolean onOptionsItemSelected(MenuItem item){

        // If we select inventory check from the menu, then we are brought to
        // the inventory check page
        if(item.getItemId()==R.id.menuItemCheckInventory){
            Intent intentInventoryCheck = new Intent(this, InventoryCheck.class);
            startActivity(intentInventoryCheck);
        }

        // If we select add inventory from the menu, then we are brought to
        // the add inventory page
        else if(item.getItemId()==R.id.menuItemAddInventory){
            Intent intentAddInventory = new Intent(this, AddInventory.class);
            startActivity(intentAddInventory);
        }

        // If we select log out from the menu, then we are brought to
        // the login page
        else if(item.getItemId()==R.id.menuItemLogOut){
            Intent intentWelcomeScreen = new Intent(this, WelcomeScreen.class);
            startActivity(intentWelcomeScreen);
        }
        return super.onOptionsItemSelected(item);
    }
    }

