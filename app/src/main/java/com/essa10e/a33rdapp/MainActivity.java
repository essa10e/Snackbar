package com.essa10e.a33rdapp;

/**
 * http://www.thecrazyprogrammer.com/2016/08/android-snackbar-example.html
 *
 * and also, this article is Great:
 * https://spin.atomicobject.com/2017/07/10/android-snackbar-tutorial/
 *
 * Android Snackbars are, unfortunately, not as tasty as they sound. But they are extremely
 * useful for showing errors or other lightweight feedback to a user–with minimal setup required.
 * This is a brief tutorial for setting up a basic Snackbar, adding actions, and customizing its appearance.

 A Snackbar is a small banner that pops up at the bottom of the user’s phone screen.
 It might be useful for indicating a form validation error, confirming to users that
 an action was taken, or alerting them to an update. In addition to providing this information,
 you can also offer a custom action such as “dismiss,” “retry,” “undo,” or “override.”
 */

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;
    CoordinatorLayout coordinatorLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(coordinatorLayout, "Simple Snackbar", Snackbar.LENGTH_LONG).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(coordinatorLayout, "Snackbar with Action", Snackbar.LENGTH_LONG)
                        .setAction("OK", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Snackbar.make(coordinatorLayout,"You clicked on action button",Snackbar.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(coordinatorLayout,"Custom Snackbar",Snackbar.LENGTH_LONG)
                        .setAction("OK", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Snackbar.make(coordinatorLayout,"You clicked on action button",Snackbar.LENGTH_SHORT).show();
                            }
                        });

                //set color of action button text:
                snackbar.setActionTextColor(Color.YELLOW);
                //set color of snackbar text
                TextView view = (TextView)snackbar.getView().findViewById(android.support.design.R.id.snackbar_text);

                view.setTextColor(Color.GREEN);

                snackbar.show();
            }
        });


    }
}
