package practica6;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.studium.xxracso40xx.practicatema6pmdm.R;

public class EditarPersonas extends AppCompatActivity
{
    ImageView imagen1, imagen2, imagen3, imagen4, imagen5, imagen6;
    String correo="", telefono="";
    EditText edit1, edit2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_personas);
        imagen1 = findViewById(R.id.imageView9);
        imagen2 = findViewById(R.id.imageView10);
        imagen3 = findViewById(R.id.imageView11);
        imagen4 = findViewById(R.id.imageView12);
        imagen5 = findViewById(R.id.imageView13);
        imagen6 = findViewById(R.id.imageView14);
        edit1 = findViewById(R.id.editText2);
        edit2 = findViewById(R.id.editText3);
    }
    public void onClick(View view)
    {
        SharedPreferences prefs = getSharedPreferences("ficheroconfiguracion", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(telefono, edit1.getText().toString());
        editor.putString(correo, edit2.getText().toString());
        editor.commit();
        Toast.makeText(this,getString(R.string.confirmacionBoton) , Toast.LENGTH_SHORT).show();
    }
    public void onClick1(View view)
    {
        imagen1.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        imagen2.setBackgroundColor(android.R.drawable.btn_default);
        imagen3.setBackgroundColor(android.R.drawable.btn_default);
        imagen4.setBackgroundColor(android.R.drawable.btn_default);
        imagen5.setBackgroundColor(android.R.drawable.btn_default);
        imagen6.setBackgroundColor(android.R.drawable.btn_default);
        correo="correo1";
        telefono="telefono1";
    }
    public void onClick2(View view)
    {
        imagen2.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        imagen1.setBackgroundColor(android.R.drawable.btn_default);
        imagen3.setBackgroundColor(android.R.drawable.btn_default);
        imagen4.setBackgroundColor(android.R.drawable.btn_default);
        imagen5.setBackgroundColor(android.R.drawable.btn_default);
        imagen6.setBackgroundColor(android.R.drawable.btn_default);

        correo="correo2";
        telefono="telefono2";
    }
    public void onClick3(View view)
    {
        imagen3.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        imagen1.setBackgroundColor(android.R.drawable.btn_default);
        imagen2.setBackgroundColor(android.R.drawable.btn_default);
        imagen4.setBackgroundColor(android.R.drawable.btn_default);
        imagen5.setBackgroundColor(android.R.drawable.btn_default);
        imagen6.setBackgroundColor(android.R.drawable.btn_default);
        correo="correo3";
        telefono="telefono3";
    }
    public void onClick4(View view)
    {
        imagen4.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        imagen1.setBackgroundColor(android.R.drawable.btn_default);
        imagen3.setBackgroundColor(android.R.drawable.btn_default);
        imagen2.setBackgroundColor(android.R.drawable.btn_default);
        imagen5.setBackgroundColor(android.R.drawable.btn_default);
        imagen6.setBackgroundColor(android.R.drawable.btn_default);
        correo="correo4";
        telefono="telefono4";
    }
    public void onClick5(View view)
    {
        imagen5.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        imagen1.setBackgroundColor(android.R.drawable.btn_default);
        imagen3.setBackgroundColor(android.R.drawable.btn_default);
        imagen4.setBackgroundColor(android.R.drawable.btn_default);
        imagen2.setBackgroundColor(android.R.drawable.btn_default);
        imagen6.setBackgroundColor(android.R.drawable.btn_default);
        correo="correo5";
        telefono="telefono5";
    }
    public void onClick6(View view)
    {
        imagen6.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        imagen1.setBackgroundColor(android.R.drawable.btn_default);
        imagen3.setBackgroundColor(android.R.drawable.btn_default);
        imagen4.setBackgroundColor(android.R.drawable.btn_default);
        imagen5.setBackgroundColor(android.R.drawable.btn_default);
        imagen2.setBackgroundColor(android.R.drawable.btn_default);
        correo="correo6";
        telefono="telefono6";
    }
}
