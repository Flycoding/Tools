package com.flyingh.tools;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }

    public void powerOff(View view) {
        exec("reboot -p");
    }

    public void reboot(View view) {
        exec("reboot");
    }

    private void exec(String command) {
        try {
            Runtime.getRuntime().exec("su");
            Runtime.getRuntime().exec(command);
        } catch (Exception e) {
            Toast.makeText(this, "execute fails", Toast.LENGTH_LONG).show();
        }
    }
}
