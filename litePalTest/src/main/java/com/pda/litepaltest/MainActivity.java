package com.pda.litepaltest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Connector.getDatabase();
        Person person = new Person();
        for (int a = 0;a<=10;a++){
            person.setPassword("111111");
            person.setUserName("222222");
            person.save();
        }
        List<Person> users = DataSupport.findAll(Person.class);
        for (int a = 0;a<users.size();a++){
            Log.e("111111",users.get(a).toString());
        }
    }
}
