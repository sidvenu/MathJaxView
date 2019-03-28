package io.github.sidvenu.mathjaxtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;

import io.github.sidvenu.mathjaxview.MathJaxView;

public class MainActivity extends AppCompatActivity {
    MathJaxView view;
    String tex = "Inline formula:" +
            " $ax^2 + bx + c = 0$ " +
            "or displayed formula: $$\\sum_{i=0}^n i^2 = \\frac{(n^2+n)(2n+1)}{6}$$"+
            "Chemistry equation:$$\\ce{x Na(NH4)HPO4 ->[\\Delta] (NaPO3)_x + x NH3 ^ + x H2O}$$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.formula2);
        view.setText(tex);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
