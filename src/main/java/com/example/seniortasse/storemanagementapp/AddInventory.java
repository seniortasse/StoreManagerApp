package com.example.seniortasse.storemanagementapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddInventory extends Activity implements View.OnClickListener{



    /* Declare the button "Return Home" */
    Button buttonReturnHome2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_inventory);

        /*Get references to the widgets*/
        buttonReturnHome2 = findViewById(R.id.buttonReturnHome2);

        //Make buttons listening to clicks
        buttonReturnHome2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        // In we click on "Return Home" button, then...
        // we should return to the home page
        if(v==buttonReturnHome2){
            Intent intentHomePage=new Intent(this,HomePage.class);
            startActivity(intentHomePage);
        }

    }



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
        else if(item.getItemId()==R.id.menuItemHome){
            Intent intentHomePage=new Intent(this,HomePage.class);
            startActivity(intentHomePage);
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
