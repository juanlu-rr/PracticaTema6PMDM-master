package practica6;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.studium.xxracso40xx.practicatema6pmdm.R;

public class BlocNotas extends AppCompatActivity
{
EditText edit1;
SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloc_notas);
       prefs = getSharedPreferences("ficheroconfiguracion", Context.MODE_PRIVATE);
        edit1 = findViewById(R.id.editText);
        edit1.setText(prefs.getString("BlocNotas", ""));

    }
    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menunotas, menu);
        MenuBuilder m = (MenuBuilder) menu;
        m.setOptionalIconsVisible(true);
        return true;
    }
    @SuppressLint("NewApi")
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("BlocNotas", edit1.getText().toString());
        editor.commit();
        return false;
    }
}
