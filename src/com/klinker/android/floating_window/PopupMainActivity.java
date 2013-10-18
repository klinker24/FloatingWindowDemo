/*
* Copyright 2013 Luke Klinker
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

package com.klinker.android.floating_window;

import android.content.Intent;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

/**
 * @author Luke Klinker
 *
 * It extends MainActivity so that you can do as little work here as possible. It will contain al of the functions from the
 * MainActivity, so you only have to Override the ones that should change the functionality if it is in floating window form.
 */
public class PopupMainActivity extends MainActivity {

    /**
     * This method overrides the MainActivity method to set up the actual window for the popup.
     * This is really the only method needed to turn the app into popup form. Any other methods would change the behavior of the UI.
     * Call this method at the beginning of the main activity.
     * You can't call setContentView(...) before calling the window service because it will throw an error every time.
     */
    @Override
    public void setUpWindow() {

        // Creates the layout for the window and the look of it
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND,
                WindowManager.LayoutParams.FLAG_DIM_BEHIND);

        // Params for the window.
        // You can easily set the alpha and the dim behind the window from here
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.alpha = 1.0f;    // lower than one makes it more transparent
        params.dimAmount = 0f;  // set it higher if you want to dim behind the window
        getWindow().setAttributes(params);

        // Gets the display size so that you can set the window to a percent of that
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        // You could also easily used an integer value from the shared preferences to set the percent
        if (height > width) {
            getWindow().setLayout((int) (width * .9), (int) (height * .7));
        } else {
            getWindow().setLayout((int) (width * .7), (int) (height * .8));
        }
    }

    /**
     * This method is used to set up the button and what the outcome of pressing it will be.
     * This is an example of a way to make the app behave differently in the windowed form.
     * No matter how complex your Main Activity is, you can take bits and peices and change them to
     *
     * Another way to change items depending on if the user is in the windowed form or the full form would be to set a
     * boolean for isPopup to true in the setUpWindow function. The boolean should be defined as public or protected in
     * the MainActivity.
     */
    @Override
    public void setUpButton() {
        // finds the button from my content view
        Button switchMode = (Button) findViewById(R.id.switch_modes);

        // sets the text to the text i want in my windowed view
        switchMode.setText(getResources().getString(R.string.switch_to_full));

        // makes it open the full app when you click the button
        switchMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // closes the current process.
                // You wouldn't actually have to do this if you wanted a part of your app just to come up on top of your current activity.
                finish();

                // Starts the new regular main activity
                Intent fullApp = new Intent(context, MainActivity.class);
                fullApp.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(fullApp);
            }
        });
    }
}
