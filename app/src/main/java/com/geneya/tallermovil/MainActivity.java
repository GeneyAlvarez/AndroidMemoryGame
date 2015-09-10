package com.geneya.tallermovil;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.SharedPreferences;



import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Stack;

public class MainActivity extends AppCompatActivity implements OnClickListener,SensorEventListener {

    private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b31,b32,b33,b34,b21,b22,b23,b24,b25,b26,b27,b28;
    private TextView bmain;

    private static Button aux; private static String dato;
    private static Button aux2; private static String dato2;

    private static boolean first=true;
    private static int parejas;

    private SensorManager sensorManager;
    private long lastUpdate;
    /*private SharedPreferences app_preferences;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Reset_Dificultad();

        /*SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(this);*/
        /*app_preferences = PreferenceManager.getDefaultSharedPreferences(this);
        parejas = app_preferences.getInt("counter", 0);*/

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        lastUpdate = System.currentTimeMillis();
    }


    public void mensaje(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Cambiar dificultad");
        builder.setItems(new CharSequence[]
                        {"Easy", "Medium", "Hard"},
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                        switch (which) {
                            case 0:
                                createEasy();
                                break;
                            case 1:
                                createMedium();
                                break;
                            case 2:
                                createHard();
                                break;
                        }
                    }
                });
        builder.create().show();
    }

    public void Reset_Dificultad(){

        mensaje();
    }

    public void createEasy(){
        List<String> list1=new ArrayList<String>();

        bmain = (TextView) findViewById(R.id.button);

        RelativeLayout item = (RelativeLayout)findViewById(R.id.ventana);
        item.removeAllViews();
        View child = getLayoutInflater().inflate(R.layout.easy, null);
        item.addView(child);


        b31 = (Button) findViewById(R.id.button31);
        b32 = (Button) findViewById(R.id.button32);
        b33 = (Button) findViewById(R.id.button33);
        b34 = (Button) findViewById(R.id.button34);

        bmain.setText("Texto de relleno");
        b31.setTextColor(Color.YELLOW);b31.setEnabled(true);
        b32.setTextColor(Color.YELLOW);b32.setEnabled(true);
        b33.setTextColor(Color.YELLOW);b33.setEnabled(true);
        b34.setTextColor(Color.YELLOW);b34.setEnabled(true);

        list1.add("1");
        list1.add("2");
        list1.add("1");
        list1.add("2");


        Collections.shuffle(list1);

        b31.setText(list1.get(0));
        b32.setText(list1.get(1));
        b33.setText(list1.get(2));
        b34.setText(list1.get(3));

        first=true;
    }

    public void createMedium(){
        bmain = (TextView) findViewById(R.id.button);

        List<String> list1=new ArrayList<String>();

        RelativeLayout item = (RelativeLayout)findViewById(R.id.ventana);
        item.removeAllViews();
        View child = getLayoutInflater().inflate(R.layout.medium, null);
        item.addView(child);

        b21 = (Button) findViewById(R.id.button21);
        b22 = (Button) findViewById(R.id.button22);
        b23 = (Button) findViewById(R.id.button23);
        b24 = (Button) findViewById(R.id.button24);
        b25 = (Button) findViewById(R.id.button25);
        b26 = (Button) findViewById(R.id.button26);
        b27 = (Button) findViewById(R.id.button27);
        b28 = (Button) findViewById(R.id.button28);

        bmain.setText("Texto de relleno");
        b21.setTextColor(Color.YELLOW);b21.setEnabled(true);
        b22.setTextColor(Color.YELLOW);b22.setEnabled(true);
        b23.setTextColor(Color.YELLOW);b23.setEnabled(true);
        b24.setTextColor(Color.YELLOW);b24.setEnabled(true);
        b25.setTextColor(Color.YELLOW);b25.setEnabled(true);
        b26.setTextColor(Color.YELLOW);b26.setEnabled(true);
        b27.setTextColor(Color.YELLOW);b27.setEnabled(true);
        b28.setTextColor(Color.YELLOW);b28.setEnabled(true);

        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");

        Collections.shuffle(list1);

        b21.setText(list1.get(0));
        b22.setText(list1.get(1));
        b23.setText(list1.get(2));
        b24.setText(list1.get(3));
        b25.setText(list1.get(4));
        b26.setText(list1.get(5));
        b27.setText(list1.get(6));
        b28.setText(list1.get(7));
    }

    public void createHard(){
        bmain = (TextView) findViewById(R.id.button);

        List<String> list1=new ArrayList<String>();

        RelativeLayout item = (RelativeLayout)findViewById(R.id.ventana);
        item.removeAllViews();
        View child = getLayoutInflater().inflate(R.layout.hard, null);
        item.addView(child);

        b1 = (Button) findViewById(R.id.button2);
        b2 = (Button) findViewById(R.id.button3);
        b3 = (Button) findViewById(R.id.button4);
        b4 = (Button) findViewById(R.id.button5);
        b5 = (Button) findViewById(R.id.button6);
        b6 = (Button) findViewById(R.id.button7);
        b7 = (Button) findViewById(R.id.button8);
        b8 = (Button) findViewById(R.id.button9);
        b9 = (Button) findViewById(R.id.button10);
        b10 = (Button) findViewById(R.id.button11);
        b11 = (Button) findViewById(R.id.button12);
        b12 = (Button) findViewById(R.id.button13);
        b13 = (Button) findViewById(R.id.button14);
        b14 = (Button) findViewById(R.id.button15);
        b15 = (Button) findViewById(R.id.button16);
        b16 = (Button) findViewById(R.id.button17);

        bmain.setText("Texto de relleno");
        b1.setTextColor(Color.YELLOW);b1.setEnabled(true);
        b2.setTextColor(Color.YELLOW);b2.setEnabled(true);
        b3.setTextColor(Color.YELLOW);b3.setEnabled(true);
        b4.setTextColor(Color.YELLOW);b4.setEnabled(true);
        b5.setTextColor(Color.YELLOW);b5.setEnabled(true);
        b6.setTextColor(Color.YELLOW);b6.setEnabled(true);
        b7.setTextColor(Color.YELLOW);b7.setEnabled(true);
        b8.setTextColor(Color.YELLOW);b8.setEnabled(true);
        b9.setTextColor(Color.YELLOW);b9.setEnabled(true);
        b10.setTextColor(Color.YELLOW);b10.setEnabled(true);
        b11.setTextColor(Color.YELLOW);b11.setEnabled(true);
        b12.setTextColor(Color.YELLOW);b12.setEnabled(true);
        b13.setTextColor(Color.YELLOW);b13.setEnabled(true);
        b14.setTextColor(Color.YELLOW);b14.setEnabled(true);
        b15.setTextColor(Color.YELLOW);b15.setEnabled(true);
        b16.setTextColor(Color.YELLOW);b16.setEnabled(true);

        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        list1.add("5");
        list1.add("6");
        list1.add("7");
        list1.add("8");
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        list1.add("5");
        list1.add("6");
        list1.add("7");
        list1.add("8");
        Collections.shuffle(list1);

        b1.setText(list1.get(0));
        b2.setText(list1.get(1));
        b3.setText(list1.get(2));
        b4.setText(list1.get(3));
        b5.setText(list1.get(4));
        b6.setText(list1.get(5));
        b7.setText(list1.get(6));
        b8.setText(list1.get(7));
        b9.setText(list1.get(8));
        b10.setText(list1.get(9));
        b11.setText(list1.get(10));
        b12.setText(list1.get(11));
        b13.setText(list1.get(12));
        b14.setText(list1.get(13));
        b15.setText(list1.get(14));
        b16.setText(list1.get(15));
    }



    public void Ventana2(View view){
        Intent i = new Intent(this, hist.class);
        startActivity(i);
    }


    public void onClickmedium(View v){

        if (first == true)
        {
            switch (v.getId()) {

                case R.id.button21:
                    dato = (String) b21.getText();
                    aux = b21;
                    b21.setTextColor(Color.BLACK);
                    break;

                case R.id.button22:
                    dato = (String) b22.getText();
                    aux = b22;
                    b22.setTextColor(Color.BLACK);
                    break;

                case R.id.button23:
                    dato = (String) b23.getText();
                    aux = b23;
                    b23.setTextColor(Color.BLACK);
                    break;

                case R.id.button24:
                    dato = (String) b24.getText();
                    aux = b24;
                    b24.setTextColor(Color.BLACK);
                    break;

                case R.id.button25:
                    dato = (String) b25.getText();
                    aux = b25;
                    b25.setTextColor(Color.BLACK);
                    break;

                case R.id.button26:
                    dato = (String) b26.getText();
                    aux = b26;
                    b26.setTextColor(Color.BLACK);
                    break;

                case R.id.button27:
                    dato = (String) b27.getText();
                    aux = b27;
                    b27.setTextColor(Color.BLACK);
                    break;

                case R.id.button28:
                    dato = (String) b28.getText();
                    aux = b28;
                    b28.setTextColor(Color.BLACK);
                    break;

            }
        }
        else
        {
            switch (v.getId()) {

                case R.id.button21:
                    dato2 = (String) b21.getText();
                    aux2 = b21;
                    b21.setTextColor(Color.BLACK);
                    break;

                case R.id.button22:
                    dato2 = (String) b22.getText();
                    aux2 = b22;
                    b22.setTextColor(Color.BLACK);
                    break;

                case R.id.button23:
                    dato2 = (String) b23.getText();
                    aux2 = b23;
                    b23.setTextColor(Color.BLACK);
                    break;

                case R.id.button24:
                    dato2 = (String) b24.getText();
                    aux2 = b24;
                    b24.setTextColor(Color.BLACK);
                    break;

                case R.id.button25:
                    dato2 = (String) b25.getText();
                    aux2 = b25;
                    b25.setTextColor(Color.BLACK);
                    break;

                case R.id.button26:
                    dato2 = (String) b26.getText();
                    aux2 = b26;
                    b26.setTextColor(Color.BLACK);
                    break;

                case R.id.button27:
                    dato2 = (String) b27.getText();
                    aux2 = b27;
                    b27.setTextColor(Color.BLACK);
                    break;

                case R.id.button28:
                    dato2 = (String) b28.getText();
                    aux2 = b28;
                    b28.setTextColor(Color.BLACK);
                    break;

            }

            try {
                Thread.sleep(800);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        if(first)
        {
            first=false;
        }
        else
        {
            if(dato.equals(dato2))
            {
                aux.setEnabled(false);
                aux2.setEnabled(false);
                aux.setTextColor(Color.parseColor("#FF6600"));
                aux2.setTextColor(Color.parseColor("#FF6600"));
                parejas++;
                    /*SharedPreferences.Editor editor = app_preferences.edit();
                    editor.putInt("counter", ++parejas);
                    editor.commit();*/


                bmain.setText("Punto :v");
                if(parejas==4) {
                    bmain.setText("Usted ha Ganado :v");
                }
            }
            else
            {
                aux.setTextColor(Color.YELLOW);
                aux2.setTextColor(Color.YELLOW);
                bmain.setText("Nope :v");
               /*sleep*/

            }

            first=true;
        }

    }

    public void onClickeasy(View v){

        if (first == true)
        {
            switch (v.getId()) {

                case R.id.button31:
                    dato = (String) b31.getText();
                    aux = b31;
                    b31.setTextColor(Color.BLACK);
                    break;

                case R.id.button32:
                    dato = (String) b32.getText();
                    aux = b32;
                    b32.setTextColor(Color.BLACK);
                    break;

                case R.id.button33:
                    dato = (String) b33.getText();
                    aux = b33;
                    b33.setTextColor(Color.BLACK);
                    break;

                case R.id.button34:
                    dato = (String) b34.getText();
                    aux = b34;
                    b34.setTextColor(Color.BLACK);
                    break;

            }
        }
        else
        {
            switch (v.getId()) {
                case R.id.button31:
                    dato2 = (String) b31.getText();
                    aux2 = b31;
                    b31.setTextColor(Color.BLACK);
                    break;

                case R.id.button32:
                    dato2 = (String) b32.getText();
                    aux2 = b32;
                    b32.setTextColor(Color.BLACK);
                    break;

                case R.id.button33:
                    dato2 = (String) b33.getText();
                    aux2 = b33;
                    b33.setTextColor(Color.BLACK);
                    break;

                case R.id.button34:
                    dato2 = (String) b34.getText();
                    aux2 = b34;
                    b34.setTextColor(Color.BLACK);
                    break;
            }

            try {
                Thread.sleep(800);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(first)
        {
            first=false;
        }
        else
        {
            if(dato.equals(dato2))
            {
                aux.setEnabled(false);
                aux2.setEnabled(false);
                aux.setTextColor(Color.parseColor("#FF6600"));
                aux2.setTextColor(Color.parseColor("#FF6600"));
                parejas++;
                    /*SharedPreferences.Editor editor = app_preferences.edit();
                    editor.putInt("counter", ++parejas);
                    editor.commit();*/


                bmain.setText("Punto :v");
                if(parejas==2) {
                    bmain.setText("Usted ha Ganado :v");
                }
            }
            else
            {
                aux.setTextColor(Color.YELLOW);
                aux2.setTextColor(Color.YELLOW);
                bmain.setText("Nope :v");
               /*sleep*/


            }

            first=true;
        }

    }


    public void onClick(View v) {


        if (first == true) {

            switch(v.getId())
            {

                case R.id.button2:
                    dato = (String) b1.getText();
                    aux = b1;
                    b1.setTextColor(Color.BLACK);
                    break;

                case R.id.button3:
                    dato = (String) b2.getText();
                    aux = b2;
                    b2.setTextColor(Color.BLACK);
                    break;

                case R.id.button4:
                    dato = (String) b3.getText();
                    aux = b3;
                    b3.setTextColor(Color.BLACK);
                    break;

                case R.id.button5:
                    dato = (String) b4.getText();
                    aux = b4;
                    b4.setTextColor(Color.BLACK);
                    break;

                case R.id.button6:
                    dato = (String) b5.getText();
                    aux = b5;
                    b5.setTextColor(Color.BLACK);
                    break;

                case R.id.button7:
                    dato = (String) b6.getText();
                    aux = b6;
                    b6.setTextColor(Color.BLACK);
                    break;

                case R.id.button8:
                    dato = (String) b7.getText();
                    aux = b7;
                    b7.setTextColor(Color.BLACK);
                    break;

                case R.id.button9:
                    dato = (String) b8.getText();
                    aux = b8;
                    b8.setTextColor(Color.BLACK);
                    break;

                case R.id.button10:
                    dato = (String) b9.getText();
                    aux = b9;
                    b9.setTextColor(Color.BLACK);
                    break;

                case R.id.button11:
                    dato = (String) b10.getText();
                    aux = b10;
                    b10.setTextColor(Color.BLACK);
                    break;

                case R.id.button12:
                    dato = (String) b11.getText();
                    aux = b11;
                    b11.setTextColor(Color.BLACK);
                    break;

                case R.id.button13:
                    dato = (String) b12.getText();
                    aux = b12;
                    b12.setTextColor(Color.BLACK);
                    break;

                case R.id.button14:
                    dato = (String) b13.getText();
                    aux = b13;
                    b13.setTextColor(Color.BLACK);
                    break;

                case R.id.button15:
                    dato = (String) b14.getText();
                    aux = b14;
                    b14.setTextColor(Color.BLACK);
                    break;

                case R.id.button16:
                    dato = (String) b15.getText();
                    aux = b15;
                    b15.setTextColor(Color.BLACK);
                    break;

                case R.id.button17:
                    dato = (String) b16.getText();
                    aux = b16;
                    b16.setTextColor(Color.BLACK);
                    break;
            }

        }
        else
        {
            if(v.getId()==findViewById(R.id.button2).getId())
                {dato2 = (String) b1.getText();
                aux2 = b1;b1.setTextColor(Color.BLACK);}

            if(v.getId()==findViewById(R.id.button3).getId())
            {dato2 = (String) b2.getText();
                aux2 = b2;b2.setTextColor(Color.BLACK);}

            if(v.getId()==findViewById(R.id.button4).getId())
            {dato2 = (String) b3.getText();
                aux2 = b3;b3.setTextColor(Color.BLACK);}

            if(v.getId()==findViewById(R.id.button5).getId())
            {dato2 = (String) b4.getText();
                aux2 = b4;b4.setTextColor(Color.BLACK);}

            if(v.getId()==findViewById(R.id.button6).getId())
            {dato2 = (String) b5.getText();
                aux2 = b5;b5.setTextColor(Color.BLACK);}

            if(v.getId()==findViewById(R.id.button7).getId())
            {dato2 = (String) b6.getText();
                aux2 = b6;b6.setTextColor(Color.BLACK);}

            if(v.getId()==findViewById(R.id.button8).getId())
            {dato2 = (String) b7.getText();
                aux2 = b7;b7.setTextColor(Color.BLACK);}

            if(v.getId()==findViewById(R.id.button9).getId())
            {dato2 = (String) b8.getText();
                aux2 = b8;b8.setTextColor(Color.BLACK);}

            if(v.getId()==findViewById(R.id.button10).getId())
            {dato2 = (String) b9.getText();
                aux2 = b9;b9.setTextColor(Color.BLACK);}

            if(v.getId()==findViewById(R.id.button11).getId())
            {dato2 = (String) b10.getText();
                aux2 = b10;b10.setTextColor(Color.BLACK);}

            if(v.getId()==findViewById(R.id.button12).getId())
            {dato2 = (String) b11.getText();
                aux2 = b11;b11.setTextColor(Color.BLACK);}

            if(v.getId()==findViewById(R.id.button13).getId())
            {dato2 = (String) b12.getText();
                aux2 = b12;b12.setTextColor(Color.BLACK);}

            if(v.getId()==findViewById(R.id.button14).getId())
            {dato2 = (String) b13.getText();
                aux2 = b13;b13.setTextColor(Color.BLACK);}

            if(v.getId()==findViewById(R.id.button15).getId())
            {dato2 = (String) b14.getText();
                aux2 = b14;b14.setTextColor(Color.BLACK);}

            if(v.getId()==findViewById(R.id.button16).getId())
            {dato2 = (String) b15.getText();
                aux2 = b15;b15.setTextColor(Color.BLACK);}

            if(v.getId()==findViewById(R.id.button17).getId())
            {dato2 = (String) b16.getText();
                aux2 = b16;b16.setTextColor(Color.BLACK);}

            try {
                Thread.sleep(800);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        if(first)
        {
            first=false;
        }
        else
        {
            if(dato.equals(dato2))
            {
                aux.setEnabled(false);
                aux2.setEnabled(false);
                aux.setTextColor(Color.parseColor("#FF6600"));
                aux2.setTextColor(Color.parseColor("#FF6600"));
                parejas++;
                    /*SharedPreferences.Editor editor = app_preferences.edit();
                    editor.putInt("counter", ++parejas);
                    editor.commit();*/


                bmain.setText("Punto :v");
                if(parejas==8) {
                    bmain.setText("Usted ha Ganado :v");
                }
            }
            else
            {
                aux.setTextColor(Color.YELLOW);
                aux2.setTextColor(Color.YELLOW);
                bmain.setText("Nope :v");
               /*sleep*/


            }

            first=true;
        }

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            getAccelerometer(event);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    private void getAccelerometer(SensorEvent event) {
        float[] values = event.values;
        // Movement
        float x = values[0];
        float y = values[1];
        float z = values[2];

        float accelationSquareRoot = (x * x + y * y + z * z) / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
        long actualTime = event.timestamp;
        if (accelationSquareRoot >= 5) //
        {
            if (actualTime - lastUpdate < 200) {
                return;
            }
            lastUpdate = actualTime;
            Toast.makeText(this, "Device was shuffed", Toast.LENGTH_SHORT).show();
            mensaje();

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

}


