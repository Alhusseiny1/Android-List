package com.alhusseiny.androidlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ListView mylist;
    BaseAdapter adapter;
    ArrayList<Account> arrayList= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylist = findViewById(R.id.myList);
        adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return 10;
            }

            @Override
            public Object getItem(int position) {
                return arrayList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = getLayoutInflater().inflate(R.layout.list_item, null,true);
                TextView textViewName = v.findViewById(R.id.textViewName);
                TextView textViewAccNumber = v.findViewById(R.id.textViewAccNumber);
                TextView textViewBalance = v.findViewById(R.id.textViewBalance);

                Account x = arrayList.get(position);
                textViewName.setText(x.getName() );
                textViewAccNumber.setText(x.getAccNumber() );


                Locale locale = new Locale("en", "KE");
                NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
                String balance=currencyFormatter.format(x.getBalance());

                textViewBalance.setText(balance);

                return v;
            }
        };

        mylist.setAdapter(adapter);

        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Account k = arrayList.get(position);
                arrayList.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, k.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        Account ac1 = new Account("Jim","AC001",12000);
        Account ac2 = new Account("Mary","AC002",13000);
        Account ac3 = new Account("Milly","AC003",22000);
        Account ac4 = new Account("Musa","AC004",15000);
        Account ac5 = new Account("Jamal","AC005",62000);
        Account ac6 = new Account("Chris","AC006",42000);
        Account ac7 = new Account("Hellen","AC007",52000);
        Account ac8 = new Account("Kim","AC008",19000);
        Account ac9 = new Account("Kiogora","AC009",92000);
        Account ac10 = new Account("Miry","AC010",12300);

       arrayList.add(ac1);
       arrayList.add(ac2);
       arrayList.add(ac3);
       arrayList.add(ac4);
       arrayList.add(ac5);
       arrayList.add(ac6);
       arrayList.add(ac7);
       arrayList.add(ac8);
       arrayList.add(ac9);
       arrayList.add(ac10);


        //refresh
        adapter.notifyDataSetChanged();
    }
}
