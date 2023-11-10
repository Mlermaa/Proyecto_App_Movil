package com.example.apptechdesk2023.Activity.Domain;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptechdesk2023.Activity.Adaptor.PopularAdaptor;
import com.example.apptechdesk2023.R;

import java.util.ArrayList;

public class CPUActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapterCPU;
    private RecyclerView recyclerViewCPUList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpuactivity);

        recyclerViewCPU();
    }



    private void recyclerViewCPU(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerViewCPUList = findViewById(R.id.recyclerView_CPU);
        recyclerViewCPUList.setLayoutManager(linearLayoutManager);


        ArrayList<ProductosDomain> productosList=new ArrayList<>();
        //----CPU----
        productosList.add(new ProductosDomain("Procesador Intel Core i7-3770","cpu_1","Procesador gamer Intel Core i7-3770 BX80637I73770 de 4 núcleos y 3.9GHz de frecuencia con gráfica integrada",618.000));
        productosList.add(new ProductosDomain("Procesador Intel Core i7-2600","cpu_2","Procesador gamer Intel Core i7-2600 BX80623I72600 de 4 núcleos y 3.8GHz de frecuencia con gráfica integrada",598.000));
        productosList.add(new ProductosDomain("Procesador AMD Ryzen 5 5600G ","cpu_3","Procesador gamer AMD Ryzen 5 5600G 100-100000252BOX de 6 núcleos y 4.4GHz con gráfica integrada",600.000));
        productosList.add(new ProductosDomain("Procesador AMD Ryzen 5 5600G ","cpu_3","Procesador gamer AMD Ryzen 5 5600G 100-100000252BOX de 6 núcleos y 4.4GHz con gráfica integrada",600.000));

        adapterCPU=new PopularAdaptor(productosList);
        recyclerViewCPUList.setAdapter(adapterCPU);
        }
    }