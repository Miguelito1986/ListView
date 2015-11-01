package listadeactividades.uem.es.listadeacticvidades;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ListActivity {


    String[] name = {"Actividad1", "Actividad2", "Actividad3", "Actividad4","LifeCycleTest","Sendata"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        ListView lista = (ListView) findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, name);
        setListAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView lista, View vista, int position, long id) {
        super.onListItemClick(lista, vista, position, id);
        String selection = name[position];
        try {
            Class<?>selected = Class.forName("listadeactividades.uem.es.listadeacticvidades." + selection);
            Intent selectIntent = new Intent(this, selected);
            startActivity(selectIntent);
        } catch (ClassNotFoundException e) {

            e.printStackTrace();

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
}
