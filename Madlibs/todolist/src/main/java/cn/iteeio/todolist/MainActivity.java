package cn.iteeio.todolist;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainActivity extends ActionBarActivity {

    private List<String> todoData = new ArrayList();
    ArrayAdapter adapter =  null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initList();
        ListView ls = (ListView)findViewById(R.id.todoList);
        adapter =  new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,todoData);
        ls.setAdapter(adapter);
        ls.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "Click ListItem Number " + position, Toast.LENGTH_LONG)
                        .show();
               //delete item from list
                todoData.remove(todoData.get(position));
                adapter.notifyDataSetChanged();
                writeToTxt();
                return false;
            }
        });
    }

    // read data from txt file
    public void initList(){
      try {
         Scanner scan = new Scanner(openFileInput("list.txt"));
         while (scan.hasNextLine()) {
            String line = scan.nextLine();
            todoData.add(line);
         }
      }catch(Exception e){
          e.printStackTrace();
      }
    }
    public void writeToTxt(){
        try{
            PrintStream out = new PrintStream(openFileOutput("list.txt", MODE_PRIVATE));
           for(int i=0;i<todoData.size();i++){
               out.println(todoData.get(i));
           }
            out.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }



    public void addTodo(View v){
        EditText vl = (EditText)findViewById(R.id.vl);
        ListView ls = (ListView)findViewById(R.id.todoList);
        if(!"".equals(vl.getText().toString())){
            todoData.add(vl.getText().toString());
            adapter.notifyDataSetChanged();
            vl.setText("");
            writeToTxt();
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
