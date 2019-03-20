package practica6;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.studium.xxracso40xx.practicatema6pmdm.R;

public class MainActivity extends AppCompatActivity {
Intent intent1, intent2;
ImageView imagen1, imagen2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent2 = new Intent(this, BlocNotas.class);
        intent1 = new Intent(this, Personas.class);
        imagen1 = findViewById(R.id.imageView2);
        imagen2 = findViewById(R.id.imageView);
        imagen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
            startActivity(intent1);
            }
        });
        imagen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            { startActivity(intent2);
            }
        });
    }
    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuBuilder m = (MenuBuilder) menu;
        m.setOptionalIconsVisible(true);
        return true;
    }
    @SuppressLint("NewApi")
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.opcion1: startActivity(intent1);break;
            case R.id.opcion2: startActivity(intent2);break;
        }
        return false;
    }
}
