package com.klinker.android.floating_window;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * @author Luke Klinker
 */
public class MainActivity extends Activity {

    public Context context;

    /**
     * Called when the activity is first created to set up all of the features.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;

        // If the user is in the PopupMainActivity function, the setUpWindow function would be called from that class
        // otherwise it would call the function from this class that has no implementation.
        setUpWindow();

        // Make sure to set your content view AFTER you have set up the window or it will crash.
        setContentView(R.layout.main);

        // Again, this will call either the function from this class or the PopupMainActivity one,
        // depending on where the user is
        setUpButton();
    }

    public void setUpWindow() {
        // Nothing here because we don't need to set up anything extra for the full app.
    }

    public void setUpButton() {
        // Creates the button and defines it's behavior for the full app.
        Button switchMode = (Button) findViewById(R.id.switch_modes);
        switchMode.setText(getResources().getString(R.string.switch_to_window));
        switchMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

                Intent window = new Intent(context, com.klinker.android.floating_window.PopupMainActivity.class);
                window.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(window);
            }
        });
    }
}
