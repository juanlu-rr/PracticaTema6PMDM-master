package practica6;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.studium.xxracso40xx.practicatema6pmdm.R;

import static android.Manifest.permission.CALL_PHONE;

public class Personas extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE =  1;
    ImageView imagen1, imagen2, imagen3, imagen4, imagen5, imagen6;
    SharedPreferences prefs;
    String correo, telefono;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personas);
        imagen1 = findViewById(R.id.imageView3);
        imagen2 = findViewById(R.id.imageView4);
        imagen3 = findViewById(R.id.imageView5);
        imagen4 = findViewById(R.id.imageView6);
        imagen5 = findViewById(R.id.imageView7);
        imagen6 = findViewById(R.id.imageView8);

       /* registerForContextMenu(imagen1);
        registerForContextMenu(imagen2);
        registerForContextMenu(imagen3);
        registerForContextMenu(imagen4);
        registerForContextMenu(imagen5);
        registerForContextMenu(imagen6);
        */
        imagen1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                correo="correo1";
                telefono="telefono1";
                registerForContextMenu(imagen1);
                return false;
            }
        });
        imagen2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                correo="correo2";
                telefono="telefono2";
                registerForContextMenu(imagen2);
                return false;
            }
        });
        imagen3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                correo="correo3";
                telefono="telefono3";
                registerForContextMenu(imagen3);
                return false;
            }
        });
        imagen4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                correo="correo4";
                telefono="telefono4";
                registerForContextMenu(imagen4);
                return false;
            }
        });
        imagen5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                correo="correo5";
                telefono="telefono5";
                registerForContextMenu(imagen5);
                return false;
            }
        });
        imagen6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                correo="correo6";
                telefono="telefono6";
                registerForContextMenu(imagen6);
                return false;
            }
        });

    }
    //ESTOS ONCLICK SIRVEN PARA DECIR QUE VARIABLES SE UTILIZARÁN DEPENDIENDO DE LA IMAGEN QUE SE HAYA HECHO CLICK
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menupersonas, menu);
    }
    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menueditar, menu);
        MenuBuilder m = (MenuBuilder) menu;
        m.setOptionalIconsVisible(true);
        return true;
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String cadena="";
        prefs = getSharedPreferences("ficheroconfiguracion", Context.MODE_PRIVATE);
        switch(item.getItemId())
        {
            case R.id.opcion4:
                cadena = prefs.getString(telefono, null);
                if(cadena==null)
                {
                    //AQUÍ UN TOAST DICIENDO QUE ESTÁ VACÍO
                    Toast.makeText(this, "Está vacio el campo teléfono", Toast.LENGTH_LONG).show();
                }
                else
                {
                    if (ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED)
                    {
                        //Intent i = new Intent(Intent.ACTION_CALL, Uri.parse(cadena));
                        //startActivity(i);
                        /*Intent intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse(cadena));
                        startActivity(intent);
                        */
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:" + cadena));
                        startActivity(callIntent);
                    }
                    else
                    {
                        requestPermissions(new String[]{CALL_PHONE}, 1);
                    }

                  /*  if (ActivityCompat.checkSelfPermission(this,
                            Manifest.permission.CALL_PHONE) !=
                            PackageManager.PERMISSION_GRANTED)
                    {
                        ActivityCompat.requestPermissions(this,
                                new String[]{Manifest.permission.CALL_PHONE},
                                MY_PERMISSIONS_REQUEST_CALL_PHONE);
                    }
                    else
                        {

                    }
                    */
                }
                break;
                case R.id.opcion5:
                cadena = prefs.getString(correo, null);
                if(cadena==null)
                {
                    Toast.makeText(this, "Está vacio el campo correo", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);
                    emailIntent.setType("text/plain");
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{cadena});
                    startActivity(emailIntent);
                }
                break;
        }
        return super.onContextItemSelected(item);
    }
    @SuppressLint("NewApi")
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent intent2 = new Intent(this, EditarPersonas.class);
        startActivity(intent2);
        return false;
    }
}
