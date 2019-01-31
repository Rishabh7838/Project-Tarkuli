package com.example.rish.projecttarkuli;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import com.example.rish.projecttarkuli.Adapter.CustomerAdapter;
import com.example.rish.projecttarkuli.Model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
private HashMap<String,String> map = new HashMap<>();
private ArrayList<Customer> custList= new ArrayList();
private Intent i = new Intent();
private String userName;
private TextView Name;
private RecyclerView RV;
private FloatingActionButton logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i = getIntent();
        Name = findViewById(R.id.user_tv);
        RV = findViewById(R.id.RV);
        logout = findViewById(R.id.logout);
        if(i!=null)
        {
            userName = i.getStringExtra("Email");
            Name.setText(userName);
        }

        map.put("Aman","Delhi");
        map.put("Rman","Delhi");
        map.put("Udit","Delhi");
        map.put("Rishabh","Delhi");
        map.put("Sarthak","Delhi");

        map.put("Sahil","Gurgaon");
        map.put("Shitij","Gurgaon");
        map.put("Rahul","Gurgaon");
        map.put("Reena","Gurgaon");
        map.put("Anu","Gurgaon");

        map.put("Riya","Kota");
        map.put("Anmol","Kota");
        map.put("Roy","Kota");
        map.put("Sameer","Kota");
        map.put("Deep","Kota");

        map.put("Rocky","Jaipur");
        map.put("Ram","Jaipur");
        map.put("Ashu","Jaipur");
        map.put("Rohit","Jaipur");
        map.put("Sanjeev","Jaipur");

        showCustomers(userName);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void showCustomers(String userName) {

        for (Map.Entry<String, String> entry : map.entrySet())
        {
            Customer cust = new Customer();
            if(userName.equals("Manager"))
            {
                cust.setLocation(entry.getValue());
                cust.setName(entry.getKey());
                custList.add(cust);
            }
            else if(userName.equals("Supervisor1"))
            {
                if(entry.getValue().equals("Delhi")||entry.getValue().equals("Gurgaon"))
                {
                    cust.setLocation(entry.getValue());
                    cust.setName(entry.getKey());
                    custList.add(cust);
                }
            }
            else if(userName.equals("Supervisor2"))
            {
                if(entry.getValue().equals("Kota")||entry.getValue().equals("Jaipur"))
                {
                    cust.setLocation(entry.getValue());
                    cust.setName(entry.getKey());
                    custList.add(cust);
                }
            }
            else if(userName.equals("Employee1"))
            {
                if(entry.getValue().equals("Delhi"))
                {
                    cust.setLocation(entry.getValue());
                    cust.setName(entry.getKey());
                    custList.add(cust);
                }
            }

            CustomerAdapter adapter = new CustomerAdapter(MainActivity.this,custList);
            RV.setHasFixedSize(true);
            RV.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            RV.setAdapter(adapter);
        }
    }

}
